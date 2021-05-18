package core.http

import core.config.ApplicationConfig
import core.context.listener.Listener

class RegistrationService(
    applicationConfig: ApplicationConfig,
    private val listeners: List<Listener>
) {
  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient(applicationConfig)
  private val baseUrl = applicationConfig.getBaseUrl()
  private val urlEndpoint = applicationConfig.registrationUrl

  fun registrationGet(url: String = baseUrl, endpoint: String = urlEndpoint): MyResponse {
    val response = defaultHttpClient.get(url, endpoint)
    listeners.forEach { it.onUpdate(response) }
    return response
  }
}