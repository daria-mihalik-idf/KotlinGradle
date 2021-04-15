package sql

import core.sqlClient.MySqlService
import core.sqlClient.model.UserAccountTableModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SqlTest : SqlBaseTest() {
  private val mySqlService = MySqlService(config)
  private val id: Long = 1002492
  private val roleId: Long = 100

  @Test
  fun selectOneRowFromDb() {
    val queryResult: Map<String, Any?> = mySqlService.getUserDataById(id)
    Assertions.assertTrue(
        queryResult.isNotEmpty(),
        "Query result is empty"
    )
  }

  @Test
  fun selectAllRawFromDb() {
    val queryResult: List<Map<String, Any?>> = mySqlService.getUserdataByRoleId(roleId)
    Assertions.assertTrue(
        queryResult.isNotEmpty(),
        "Query result is empty"
    )
  }

  @Test
  fun selectOneRawFromDbModel() {
    val model = UserAccountTableModel()
    val queryResult = model.useModel()
    Assertions.assertTrue(
        queryResult.isNotEmpty(),
        "Query result is empty"
    )
  }
}