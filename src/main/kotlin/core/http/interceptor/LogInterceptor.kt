package core.http.interceptor

import logger.TestLogger
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import okio.IOException

class LogInterceptor : Interceptor {
  private val log = TestLogger.getLogger()

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    logRequest(request)
    val response: Response = chain.proceed(request)
    val responseBody = response.body?.string()
    logResponse(response)
    return response.newBuilder().body(responseBody?.toResponseBody()).build()
  }

  private fun logResponse(response: Response) {
    log.info(
        """
        Getting response: [${response.request.method}] ${response.request.url}
        Response status code: ${response.code}
        Response headers: ${"\n"}${response.headers}
        """
    )
  }

  private fun logRequest(request: Request) {
    log.info(
        """
        Sending request: [${request.method}] ${request.url}${request.headers}
        """
    )
    request.body?.let { logRequestBody(it) }
  }

  private fun logRequestBody(request: RequestBody) {
    try {
      val buffer = Buffer()
      request.writeTo(buffer)
      log.info("request body:${buffer.readUtf8()}")
    } catch (e: IOException) {
      log.error("did not work")
    }
  }
}