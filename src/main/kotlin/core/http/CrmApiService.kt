package core.http

class CrmApiService {
  private val defaultHttpClient: MyOkHttpClient = MyOkHttpClient()
  private var baseUrl: String = "https://www.moneyman.com.mx"
  private var urlEndpoint = "/secure/new-admin/lang/en.json"
  private val json = "{\"login\": \"admin\",\"password\": \"11111111\",\"captcha\": \"11111\"}"
  private val baseCrmLoginUrl: String = "https://qa-delivery-mx-master.moneyman.ru"
  private val baseCrmLoginUrlEndpoint: String = "/secure/rest/sign/in"

  fun getCrmLoginPage(): MyResponse {
    return defaultHttpClient.get(baseUrl, urlEndpoint)
  }

  fun logInCrm(): MyResponse {
    return defaultHttpClient.post(json, baseCrmLoginUrl, baseCrmLoginUrlEndpoint)
  }
}