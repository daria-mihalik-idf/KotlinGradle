package core.http

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class MyOkHttpClient : OkHttp3Client {

  private var client: OkHttpClient = OkHttpClientBuilder().build()

  override fun get(baseUrl: String, urlEndpoint: String): MyResponse {

    val request: Request = Request.Builder()
        .url("$baseUrl$urlEndpoint")
        .get()
        .build()
    return MyResponse(client.newCall(request).execute().code)
  }

  override fun post(json: String, baseUrl: String, urlEndpoint: String): MyResponse {
    val body: RequestBody = json.toRequestBody("application/json".toMediaTypeOrNull())
    val request: Request = Request.Builder()
        .url("$baseUrl$urlEndpoint")
        .post(body)
        .build()
    return MyResponse(client.newCall(request).execute().code)
  }
}

class MyResponse(val code: Int) {
}