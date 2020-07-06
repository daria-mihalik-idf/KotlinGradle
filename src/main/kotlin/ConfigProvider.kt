import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import kotlintest.ApplicationConfig
import javax.naming.Context

interface ConfigProvider {
    fun getConfig(): ApplicationConfig
}

class MmConfigProvider : ConfigProvider {
    override fun getConfig(): ApplicationConfig {
        return Thread.currentThread().contextClassLoader.getResourceAsStream("config\\configTest")?.use {
            ObjectMapper(YAMLFactory())
                    .registerModule(KotlinModule())
                    .readValue(it, ApplicationConfig::class.java)
        }!!
    }
}
