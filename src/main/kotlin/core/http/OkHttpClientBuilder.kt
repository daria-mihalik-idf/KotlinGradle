package core.http

import okhttp3.OkHttpClient

class OkHttpClientBuilder {
  fun build(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(AuthInterceptor()).build()
  }
}