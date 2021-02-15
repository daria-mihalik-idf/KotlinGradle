package core.http

interface OkHttp3Client {

  fun get(baseUrl: String, urlEndpoint: String): MyResponse

  fun post(json: String, baseUrl: String, urlEndpoint: String): MyResponse
}