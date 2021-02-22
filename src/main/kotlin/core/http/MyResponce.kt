package core.http

import okhttp3.Response

class MyResponse(response: Response) : MyNewResponse {
  private val body = response.body?.string()
  val code = response.code
  private val headers = response.headers

  override fun getHeaders(): Map<String, String> {
    // TODO: return headers
    return emptyMap()
  }

  override fun getBody(): String? {
    return body
  }

  override fun getStatusCode(): Int {
    return code
  }
}