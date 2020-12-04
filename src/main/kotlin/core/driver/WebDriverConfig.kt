package core.driver

import core.Browser

data class WebDriverConfig(
    var browserType: Browser,
    var browserScreenSize: String,
    var screenResolutionWidth: Int,
    var screenResolutionHeight: Int,
    var timeouts: Long,
    var driverType: DriverType,
    var webDriverHost: String,
    var webDriverPort: String
)