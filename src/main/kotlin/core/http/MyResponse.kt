package core.http

import okhttp3.Response

class MyResponse(val response: Response) : MyNewResponse {

  override fun getHeaders(): Map<String, String> {
    return response.headers.toMap()
  }

  override fun getBody(): String? {
    return response.body.toString()
  }

  override fun getStatusCode(): Int {
    return response.code
  }

  fun getCookies(): Map<String, String> {
    return response.headers
        .filter { it.first.equals("Set-Cookie", ignoreCase = true) }
        .map { it.second.split(";")[0].split("=") }
        .associateBy({ it[0] }, { it[1] })
  }
}