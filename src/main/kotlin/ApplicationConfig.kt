package kotlintest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationConfig ( val host: String, val user: String, val password: Int , val landingEndpoint: String?)



