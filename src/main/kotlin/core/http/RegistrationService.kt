package core.http

import core.config.ApplicationConfig
import core.context.listener.RegistrationServiceListener

class RegistrationService(
    applicationConfig: ApplicationConfig,
    private val listeners: List<RegistrationServiceListener>
) {
  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient(applicationConfig)
  private val baseUrl = applicationConfig.getBaseUrl()
  private val urlEndpoint = applicationConfig.registrationUrl

  fun openRegistration(url: String = baseUrl, endpoint: String = urlEndpoint): MyResponse {
    val response = defaultHttpClient.get(url, endpoint)
    listeners.forEach { it.onOpenRegistration(response) }
    return response
  }
}