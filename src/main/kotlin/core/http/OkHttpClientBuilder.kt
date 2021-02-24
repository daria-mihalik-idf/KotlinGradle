package core.http

import core.config.ApplicationConfig
import okhttp3.OkHttpClient

class OkHttpClientBuilder(private val applicationConfig: ApplicationConfig) {
  fun build(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(AuthInterceptor(applicationConfig)).build()
  }
}