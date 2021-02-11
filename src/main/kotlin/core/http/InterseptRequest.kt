package core.http

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val requestBuilder: Request.Builder = chain.request().newBuilder()
    requestBuilder.addHeader("Authorization", Credentials.basic("moneyman", "1005"))
    return chain.proceed(requestBuilder.build())
  }
}