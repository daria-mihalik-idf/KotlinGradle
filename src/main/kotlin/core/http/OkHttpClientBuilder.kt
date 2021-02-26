package core.http

import core.config.ApplicationConfig
import core.http.interceptor.AuthInterceptor
import core.http.interceptor.LogInterceptor
import okhttp3.OkHttpClient

class OkHttpClientBuilder(private val applicationConfig: ApplicationConfig) {
  fun build(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(AuthInterceptor(applicationConfig))
        .addInterceptor(LogInterceptor())
        .build()
  }
}