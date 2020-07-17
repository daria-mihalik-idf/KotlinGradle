package config

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class MmConfigYamlProviderTest {
    @Test
    fun configValCheck() {
        val config = ConfigProviderManager().setFileType(InputFile.YAML).getConfig()

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
                },
                {
                    Assertions.assertEquals(fileType, "YAML")
                },
                {
                    Assertions.assertEquals(testType, null)
                }
            )
        }
    }
}

