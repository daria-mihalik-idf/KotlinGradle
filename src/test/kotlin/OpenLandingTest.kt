import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OpenLandingTest {
    @Test
    fun openLanding() {
        //selenium
        val config = MmConfigProvider().getConfig()
        val password = config.password
        val user = config.user
        val host = config.host
        val landingEnpoint = config.landingEndpoint
        val url = "https://$user:$password@$landingEnpoint"


    }
}