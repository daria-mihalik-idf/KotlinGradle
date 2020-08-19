package kotlintest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig(
    val host: String,
    val user: String,
    val password: Int,
    val landingEndpoint: String?,
    val registrationUrl: String,
    @JsonProperty("type")
    val fileType: String,
    val testType: String?
) {
     fun getBaseUrlWithAuthorization(): String {
        return "https://$user:$password@$host"
    }

    fun getBaseUrlWithoutAuthorization():String{
        return "https://$host/"
    }
}




