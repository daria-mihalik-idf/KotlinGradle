package core.http

import core.config.ApplicationConfig

class RegistrationService(applicationConfig: ApplicationConfig) {
  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient(applicationConfig)
  private val baseUrl = applicationConfig.getBaseUrl()
  private val urlEndpoint = applicationConfig.registrationUrl

  fun registrationGet(url: String = baseUrl, endpoint: String = urlEndpoint): MyResponse {
    return defaultHttpClient.get(url, endpoint)
  }
}