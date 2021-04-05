package sql

import core.sqlClient.DbClient
import core.sqlClient.MySqlClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class SqlBaseTest {

  private val mySqlClient: DbClient = MySqlClient()

  @BeforeAll
  fun getDbConnection() {
    mySqlClient.getDbConnection()
  }

  @AfterAll
  fun closeDbConnection() {
    mySqlClient.closeDbConnection()
  }
}