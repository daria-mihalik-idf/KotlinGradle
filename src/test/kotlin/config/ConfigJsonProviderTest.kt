package config

import config.MmConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.function.Executable

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConfigJsonProviderTest {

    //private val invalidHost = "qa-delivery-mx-master.moneyman.by"
    //private val pass = null

    @Test
    fun configValCheck() {
        val config = MmConfigJsonProvider().getConfig()
        val password = config.password
        val user = config.user
        val host = config.host
        val landingEndpoint = config.landingEndpoint
        val url = "https://$host/$user:$password@$landingEndpoint"

        config.apply {
            assertAll(
                {
                    Assertions.assertEquals(password, 1005)
                },
                {
                    Assertions.assertEquals(user, "moneyman")
                },
                {
                    Assertions.assertEquals(host, "qa-delivery-mx-master.moneyman.ru")
                },
                {
                    Assertions.assertEquals(landingEndpoint, "/")
                }

            )
        }
    }
}

