package core.http

interface HttpClient {

  fun get(baseUrl: String, urlEndpoint: String, body: String, headers: Map<String, String>): MyResponse

  fun post(baseUrl: String, urlEndpoint: String, body: String, headers: Map<String, String>): MyResponse

  fun put(baseUrl: String, urlEndpoint: String, body: String, headers: Map<String, String>): MyNewResponse

  fun delete(baseUrl: String, urlEndpoint: String, body: String, headers: Map<String, String>): MyNewResponse
}