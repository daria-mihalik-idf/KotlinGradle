package core.sqlClient

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getDbConnection(): Session
  fun selectOneRow(
      sqlQueryRaw: String,
      queryParams: Map<String, Any?>,
  ): Map<String, Any?>

  fun selectAllRows(
      sqlQueryRaw: String,
      queryParams: Map<String, Any?>,
  ): List<Map<String, Any?>>

  fun closeDbConnection()
}