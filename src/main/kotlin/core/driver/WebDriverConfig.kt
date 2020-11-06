package core.driver

data class WebDriverConfig(
    var browserType: String,
    var screenResolutionWidth: Int,
    var screenResolutionHeight: Int,
    var timeouts: Long,
    var driverType: DriverType,
    var webDriverHost: String,
    var webDriverPort: String
)






