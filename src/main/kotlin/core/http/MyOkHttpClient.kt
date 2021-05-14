package core.http

import core.config.ApplicationConfig
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class MyOkHttpClient(applicationConfig: ApplicationConfig) : HttpClient {

  private var client: OkHttpClient = OkHttpClientBuilder(applicationConfig).build()

  override fun get(
      baseUrl: String,
      urlEndpoint: String,
      headers: Map<String, String>?
  ): MyResponse {
    val request: Request = Request.Builder()
        .url("$baseUrl$urlEndpoint")
        .get()
        .build()
    return MyResponse(client.newCall(request).execute())
  }

  override fun post(
      baseUrl: String,
      urlEndpoint: String,
      body: String,
      headers: Map<String, String>
  ): MyResponse {
    val requestBody: RequestBody = body.toRequestBody("application/json".toMediaTypeOrNull())
    val request: Request = Request.Builder()
        .url("$baseUrl$urlEndpoint")
        .post(requestBody)
        .build()
    return MyResponse(client.newCall(request).execute())
  }

  override fun put(
      baseUrl: String,
      urlEndpoint: String,
      body: String,
      headers: Map<String, String>
  ): MyNewResponse {
    val requestBody: RequestBody = body.toRequestBody("application/json".toMediaTypeOrNull())
    val request: Request = Request.Builder()
        .url("$baseUrl$urlEndpoint")
        .put(requestBody)
        .build()
    return MyResponse(client.newCall(request).execute())
  }

  override fun delete(
      baseUrl: String,
      urlEndpoint: String,
      headers: Map<String, String>
  ): MyNewResponse {
    val request: Request = Request.Builder()
        .url("$baseUrl$urlEndpoint")
        .delete()
        .build()
    return MyResponse(client.newCall(request).execute())
  }
}