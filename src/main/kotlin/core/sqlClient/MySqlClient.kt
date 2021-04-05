package core.sqlClient

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import core.config.ApplicationConfig
import java.sql.ResultSet

class MySqlClient(config: ApplicationConfig.SqlConfig) : DbClient {
  private val sqlConfig = config
  private var session: Session? = null

  override fun getDbConnection(): Session {
    if (session == null) {
      session = session(
          url = sqlConfig.dbUrl,
          user = sqlConfig.dbUser,
          password = sqlConfig.dbPassword
      )
    }
    return session as Session
  }

  override fun selectOneRow(
      sqlQueryRaw: String,
      queryParams: Map<String, Any?>
  ): Map<String, Any?> {
    val sqlQuery = buildQuery(sqlQueryRaw, queryParams)
    return getDbConnection().query(sqlQuery, resultSetFirstRow)
  }

  override fun selectAllRows(
      sqlQueryRaw: String,
      queryParams: Map<String, Any?>
  ): List<Map<String, Any?>> {
    val sqlQuery = buildQuery(sqlQueryRaw, queryParams)
    return getDbConnection().query(sqlQuery, resultSetToList)
  }

  override fun closeDbConnection() {
    if (session != null) {
      getDbConnection().close()
      session = null
    }
  }

  private val resultSetFirstRow: (ResultSet) -> Map<String, Any?> = { resultSet ->
    val metaData = resultSet.metaData
    val columnsCount = metaData.columnCount
    val firstRowSelectData = HashMap<String, Any?>(columnsCount)
    if (resultSet.next()) {
      for (column in 1..columnsCount) {
        firstRowSelectData[metaData.getColumnName(column)] = resultSet.getObject(column)
      }
    }
    firstRowSelectData
  }

  private val resultSetToList: (ResultSet) -> List<Map<String, Any?>> = { resultSet ->
    val metaData = resultSet.metaData
    val columnsCount = metaData.columnCount
    val allRowsSelectData = ArrayList<HashMap<String, Any?>>()
    while (resultSet.next()) {
      val firstRowSelectData = HashMap<String, Any?>(columnsCount)
      for (column in 1..columnsCount) {
        firstRowSelectData[metaData.getColumnName(column)] = resultSet.getObject(column)
      }
      allRowsSelectData.add(firstRowSelectData)
    }
    allRowsSelectData
  }

  private fun buildQuery(sqlQueryRaw: String, queryParams: Map<String, Any?>): SqlQuery {
    return if (queryParams.isNullOrEmpty()) {
      SqlQuery(sqlQueryRaw)
    } else {
      var sqlQuery: SqlQuery = sqlQuery(sqlQueryRaw)
      queryParams.forEach { (paramName, paramValue) ->
        sqlQuery = sqlQuery.params(paramName to paramValue)
      }
      sqlQuery
    }
  }
}