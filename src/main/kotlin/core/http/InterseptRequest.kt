package core.http

import core.config.ApplicationConfig
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor(private val applicationConfig: ApplicationConfig) : Interceptor {
  //todo take app config from static holder when implemented
  override fun intercept(chain: Interceptor.Chain): Response {
    val requestBuilder: Request.Builder = chain.request().newBuilder()
    requestBuilder.addHeader("Authorization", Credentials.basic(applicationConfig.user,
        applicationConfig.password.toString()))
    return chain.proceed(requestBuilder.build())
  }
}