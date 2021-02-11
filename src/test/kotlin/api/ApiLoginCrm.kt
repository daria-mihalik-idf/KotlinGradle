package api

import core.http.HttpClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApiLoginCrm {

  @Test
  fun ff() {
    val okHttpClient = HttpClient()
    val response = okHttpClient.get().code

    Assertions.assertEquals(response, 200, "Invalid response code")
  }

  @Test
  fun ffg() {
    val okHttpClient = HttpClient()
    val response = okHttpClient.post().code

    Assertions.assertEquals(response, 200, "Invalid response code")
  }
}