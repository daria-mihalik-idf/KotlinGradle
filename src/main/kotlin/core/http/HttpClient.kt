package core.http

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class HttpClient : DefaultHttpClient {

  private var client: OkHttpClient = HttpClientBuilder().build()
  private var baseUrl: String = "https://www.moneyman.com.mx/secure/new-admin/lang/en.json"

  override fun get(): Response {
    val request: Request = Request.Builder()
        .url(baseUrl)
        .get()
        .build()
    return client.newCall(request).execute()
  }

  override fun post(): Response {
    val json = "{\"login\": \"admin\",\"password\": \"11111111\",\"captcha\": \"11111\"}"
    val body: RequestBody = json.toRequestBody("application/json".toMediaTypeOrNull());
    val request: Request = Request.Builder()
        .url("https://qa-delivery-mx-master.moneyman.ru/secure/rest/sign/in")
        .post(body)
        .build();

    return client.newCall(request).execute()
  }
}