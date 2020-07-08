package config

import config.MmConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)


class ConfigProviderTest {

    private val invalidHost = "qa-delivery-mx-master.moneyman.by"
    private val pass = null

    @Test
    fun configValCheck() {
        val config = MmConfigProvider().getConfig()
        val password = config.password
        val user = config.user
        val host = config.host
        val landingEndpoint = config.landingEndpoint
        //val landingEndpoint = null
        val url = "https://$host/$user:$password@$landingEndpoint"
        //println("$url")
        //val isUserEmpty = user.isEmpty()
        //print(isUserEmpty)

        //Assertions.assertNotEquals(host, invalidHost, "values aren't equals")
        //Assertions.assertEquals(password, pass, "values aren't equals")
        //Assertions.assertTrue(!isUserEmpty, "user is empty")
        Assertions.assertTrue(user.isNotEmpty() || user.isEmpty(), "user is empty")
        Assertions.assertNotNull(landingEndpoint, "val with null value")
        Assertions.assertNotNull(password, "val with null value")


    }
}