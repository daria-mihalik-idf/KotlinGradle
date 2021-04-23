package core.sqlClient

import core.config.ApplicationConfig

class MySqlService (config: ApplicationConfig.SqlConfig) {
  private val mySqlClient: DbClient = MySqlClient(config)
  private val sqlQuery = SqlQuery()

  fun getUserDataById(id: Long): Map<String, Any?> {
    return mySqlClient.selectOneRow(sqlQuery.userAccountSelectByIdQuery,  mapOf("id" to id))
  }

  fun getUserdataByRoleId( roleId: Long): List<Map<String, Any?>> {
    return mySqlClient.selectAllRows(sqlQuery.userAccountSelectByRoleIdQuery, mapOf("role_id" to roleId))
  }
}