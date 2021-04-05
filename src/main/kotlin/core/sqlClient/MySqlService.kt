package core.sqlClient

class MySqlService {
  private val mySqlClient: DbClient = MySqlClient()

  fun getUserDataById(sqlQueryRaw: String, id: Long): Map<String, Any?> {
    return mySqlClient.selectOneRow(sqlQueryRaw, mapOf("id" to id))
  }

  fun getUserdataByEmail(sqlQueryRaw: String, roleId: Long): List<Map<String, Any?>> {
    return mySqlClient.selectAllRows(sqlQueryRaw, mapOf("role_id" to roleId))
  }
}