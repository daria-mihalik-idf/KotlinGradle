package sql

import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.sqlClient.DbClient
import core.sqlClient.MySqlClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class SqlBaseTest {
  protected val config = ApplicationConfigProviderManager().getConfig(FileType.YAML).sqlConfig
  private val mySqlClient: DbClient = MySqlClient(config)

  @BeforeAll
  fun getDbConnection() {
    mySqlClient.getDbConnection()
  }

  @AfterAll
  fun closeDbConnection() {
    mySqlClient.closeDbConnection()
  }
}