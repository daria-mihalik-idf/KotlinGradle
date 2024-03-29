package core.http

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import core.config.ApplicationConfig

class CrmLoginService(private val applicationConfig: ApplicationConfig) {

  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient(applicationConfig)
  private val baseUrl = applicationConfig.getBaseUrl()
  private val urlEndpoint = applicationConfig.crmAuthUrl

  fun getCrmAuthRequest(): String {
    return jacksonObjectMapper().writeValueAsString(applicationConfig.crmLoginData)
  }

  fun logInCrm(url: String = baseUrl, endpoint: String = urlEndpoint): MyResponse {
    val body: String = getCrmAuthRequest()
    return defaultHttpClient.post(url, endpoint, body)
  }
}