package core.http

interface HttpClient {

  fun get(baseUrl: String, urlEndpoint: String, headers: Map<String, String> = mapOf()): MyResponse

  fun post(baseUrl: String, urlEndpoint: String, body: String, headers: Map<String, String> = mapOf()): MyResponse

  fun put(baseUrl: String, urlEndpoint: String, body: String, headers: Map<String, String> = mapOf()): MyNewResponse

  fun delete(baseUrl: String, urlEndpoint: String, headers: Map<String, String> = mapOf()): MyNewResponse
}