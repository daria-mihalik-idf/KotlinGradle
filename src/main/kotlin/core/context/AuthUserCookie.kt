package core.context

import core.context.listener.AuthUserCookieListener
import core.context.listener.CookiesListener


  abstract class MmSessionCookie(val cookieName: String) : CookiesListener {
    open var cookieValue: String = ""

    var cookie: Map<String, String>
      get() = if (cookieValue.isEmpty()) {
        emptyMap()
      } else {
        mapOf(cookieName to cookieValue)
      }
      set(@Suppress("UNUSED_PARAMETER") value) {}

    override fun takeRequiredData(dataField: Map<String, String>) {
      getCookieByName(dataField).also { requiredCookie ->
        if (requiredCookie.isNotEmpty()) {
          requiredCookie[requiredCookie.keys.iterator().next()]?.apply {
            if (this.isNotEmpty()) {
              cookieValue = this
            }
          }
        }
      }
    }

    private fun getCookieByName(cookies: Map<String, String>): Map<String, String> {
      return cookies.filterKeys { it.contains(cookieName, ignoreCase = true) }
    }
  }



  class AuthUserCookie(cookieName: String = "AuthUser") : MmSessionCookie(cookieName = cookieName) {

    private val authUserMetadataSplitSymbol = ";"

    override var cookieValue: String = ""
      set(value) {
        val formattedValue = splitCookieMetadata(value)
        if (field != formattedValue) {
          field = formattedValue
          notifyOnAuthUserCookieUpdate(formattedValue)
        }
      }

    val cookieNotifiers: MutableList<AuthUserCookieListener> = mutableListOf()

    private fun notifyOnAuthUserCookieUpdate(value: String) {
      cookieNotifiers.forEach { it.takeRequiredData(value) }
    }

    private fun splitCookieMetadata(cookie: String): String {
      return if (cookie.contains(authUserMetadataSplitSymbol)) {
        cookie.substringBefore(authUserMetadataSplitSymbol)
      } else cookie
    }
  }

