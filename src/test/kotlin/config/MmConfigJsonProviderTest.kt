package config

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class MmConfigJsonProviderTest{

    @Test
    fun configValCheck() {
        val config = MmConfigJsonProvider().getConfig()

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

