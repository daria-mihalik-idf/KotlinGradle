package core.http

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import core.config.ApplicationConfig

class CrmLoginService(private val applicationConfig: ApplicationConfig) {

  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient(applicationConfig)
  private val baseUrl = applicationConfig.getBaseUrl()
  private val urlEndpoint = applicationConfig.crmAuthUrl

  private fun getCrmAuthRequest(): String {
    return jacksonObjectMapper().writeValueAsString(applicationConfig.crmLoginData)
  }

  fun logInCrm(): MyResponse {
    val body: String = getCrmAuthRequest()
    return defaultHttpClient.post(baseUrl, urlEndpoint, body)
  }
}