package core.http

import okhttp3.OkHttpClient

class HttpClientBuilder {
  fun build(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(AuthInterceptor()).build()
  }
}