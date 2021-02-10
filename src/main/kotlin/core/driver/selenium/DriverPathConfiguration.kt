package core.driver.selenium

interface DriverPathConfiguration {

  val browserPackage: String
  val browserPath: String

  fun configureDriverPath() {
    System.setProperty(browserPackage, browserPath)
  }
}