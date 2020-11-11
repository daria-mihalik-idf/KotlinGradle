package core.configProvider

interface ConfigProvider {

  val filePath: String

  fun getConfig(): Any
}