package core.config

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import core.CrmUser

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
    val host: String,
    val user: String,
    val password: Int,
    val landingEndpoint: String?,
    val registrationUrl: String,
    val loginPrivateAreaPageUrl: String,
    val crmLoginPageUrl: String,
    val crmAuthUrl: String,
    val crmLoginData: CrmUser,
    @JsonProperty("type")
    val fileType: String,
    val testType: String?,
    val wireMockConfig: WireMockConfig
) {
  private val httpsPrefix: String = "https://"

  fun getBaseUrlWithAuthorization(): String {
    return "$httpsPrefix$user:$password@$host/"
  }

  fun getBaseUrl(): String {
    return "$httpsPrefix$host/"
  }

  data class WireMockConfig(val wireMockHost: String, val wireMockPort: Int)
}