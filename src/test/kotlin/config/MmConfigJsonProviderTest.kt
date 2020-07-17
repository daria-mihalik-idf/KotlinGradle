package config

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class MmConfigJsonProviderTest{
    @JsonIgnoreProperties
    @Test
    fun configValCheck() {
        val config = ConfigProviderManager().setFileType(InputFile.JSON).getConfig()

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
                    Assertions.assertEquals(fileType, "JSON")
                },
                {
                    Assertions.assertEquals(testType, null)
                }
            )
        }
    }
}
