package core.http

interface MyNewResponse {
  fun getHeaders(): Map<String, String>
  fun getBody(): String?
  fun getStatusCode(): Int
}
