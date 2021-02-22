package core.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import core.CrmUser
import core.config.ApplicationConfig
import java.io.File

class CrmLoginService(applicationConfig: ApplicationConfig) {

  private val aplConfig = applicationConfig
  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient()
  private val baseUrl = applicationConfig.getBaseUrl()
  private val urlEndpoint = applicationConfig.crmAuthUrl
  private val headers: Map<String, String> = mapOf()

  private fun getCrmAuthRequest(): String {
    val objectMapper = ObjectMapper()
    val crmUser = CrmUser(aplConfig.crmLoginData.crmLoginMail,
        aplConfig.crmLoginData.crmLoginPassword,
        aplConfig.crmLoginData.crmCaptchaValue)
    objectMapper.writeValue(File("src/test/resources/crmLoginUserData.json"), crmUser)
    return jacksonObjectMapper().writeValueAsString(crmUser)
  }

  fun logInCrm(): MyResponse {
    val body: String = getCrmAuthRequest()
    return defaultHttpClient.post(baseUrl, urlEndpoint, body, headers)
  }
}