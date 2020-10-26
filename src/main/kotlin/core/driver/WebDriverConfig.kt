package core.driver

data class WebDriverConfig(
    var browserType: String,
    var screenResolutionWidth: Int,
    var screenResolutionHeight: Int,
    var timeouts: Long
)

