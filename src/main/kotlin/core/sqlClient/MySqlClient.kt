package core.sqlClient

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import core.config.ApplicationConfig
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import java.sql.ResultSet

class MySqlClient : DbClient {

  private var session: Session? = null


  override fun getDbConnection(): Session {
    val applicationConfig: ApplicationConfig = ApplicationConfigProviderManager().getConfig(FileType.YAML)

    if (session == null) {
      session = session(
          url = applicationConfig.sqlConfig.dbUrl,
          user = applicationConfig.sqlConfig.dbUser,
          password = applicationConfig.sqlConfig.dbPassword
      )
    }
    return session as Session
  }

  override fun selectOneRow(
      sqlQueryRaw: String,
      queryParams: Map<String, Any?>
  ): Map<String, Any?> {
    val sqlQuery = SqlQuery(sqlQueryRaw.format(queryParams.getValue("id")))
    return getDbConnection().query(sqlQuery, resultSetFirstRow)
  }

  override fun selectAllRows(
      sqlQueryRaw: String,
      queryParams: Map<String, Any?>
  ): List<Map<String, Any?>> {
    val sqlQuery = SqlQuery(sqlQueryRaw.format(queryParams.getValue("role_id")))
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
}