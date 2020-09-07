package config

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
    val host: String,
    val user: String,
    val password: Int,
    val landingEndpoint: String?,
    val registrationUrl: String,
    val loginUrl: String,
    @JsonProperty("type")
    val fileType: String,
    val testType: String?,
    val loginMail: String,
    val loginPassword: String
) {
    private val httpsPrefix: String = "https://"

    fun getBaseUrlWithAuthorization(): String {
        return "$httpsPrefix$user:$password@$host"
    }

    fun getBaseUrl():String{
        return "$httpsPrefix$host/"
    }
}




