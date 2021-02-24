package core.http

import okhttp3.Response

class MyResponse(private val response: Response) : MyNewResponse {

  override fun getHeaders(): Map<String, String> {
    return response.headers.toMap()
  }

  override fun getBody(): String? {
    return response.body.toString()
  }

  override fun getStatusCode(): Int {
    return response.code
  }
}