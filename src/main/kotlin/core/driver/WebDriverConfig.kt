package core.driver

import core.Browser

data class WebDriverConfig(
    var browserType: Browser,
    var chromeVersion: String,
    var firefoxVersion: String,
    var screenResolutionWidth: Int,
    var screenResolutionHeight: Int,
    var timeouts: Long,
    var driverType: DriverType,
    var webDriverHost: String,
    var webDriverPort: String,
    var headlessMode: Boolean
) {
  fun getScreenResolution(): String {
    return "${screenResolutionWidth}x${screenResolutionHeight}"
  }
}

