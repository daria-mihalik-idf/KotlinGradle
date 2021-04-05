package sql

import core.sqlClient.MySqlService
import core.sqlClient.SqlQuery
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SqlTest : SqlBaseTest() {
  private val sqlQuery: SqlQuery = SqlQuery()
  private val mySqlService = MySqlService()

  @Test
  fun selectOneRowFromDb() {
    val id: Long = 1002492
    val queryResult = mySqlService.getUserDataById(sqlQuery.userAccountSelectByIdQuery, id)
    Assertions.assertTrue(
        queryResult.isNotEmpty(),
        "Query result is empty"
    )
  }

  @Test
  fun selectAllRawFromDb() {
    val roleId: Long = 100
    val queryResult = mySqlService.getUserdataByEmail(sqlQuery.userAccountSelectByEmailQuery, roleId)
    Assertions.assertTrue(
        queryResult.isNotEmpty(),
        "Query result is empty"
    )
  }
}