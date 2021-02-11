package core.http

import okhttp3.Response

interface DefaultHttpClient {

  fun get(): Response

  fun post(): Response
}