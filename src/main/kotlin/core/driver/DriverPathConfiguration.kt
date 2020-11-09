package core.driver

interface DriverPathConfiguration {

  val browserPackage: String
  val browserPath: String

  fun configureDriverPath() {
    System.setProperty(browserPackage, browserPath)
  }
}