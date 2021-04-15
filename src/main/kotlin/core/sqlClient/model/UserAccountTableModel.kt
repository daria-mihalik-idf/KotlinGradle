package core.sqlClient.model

import com.vladsch.kotlin.jdbc.Model
import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.sqlQuery
import com.vladsch.kotlin.jdbc.using
import core.config.ApplicationConfigProviderManager
import core.config.FileType
import core.sqlClient.DbClient
import core.sqlClient.MySqlClient

val config = ApplicationConfigProviderManager().getConfig(FileType.YAML).sqlConfig
private val mySqlClient: DbClient = MySqlClient(config)

class UserAccountTableModel(
    session: Session? = mySqlClient.getDbConnection(),
    quote: String? = null
) : Model<UserAccountTableModel, UserAccountTable>(session, tableName, true, false, quote) {

  var id: Long? by db
  val blocked: Boolean by db
  val change_password_on_login: Boolean by db
  val creation_date: String by db
  val creator: String? by db
  val deleted: Boolean by db
  val email: String by db
  val login: String by db
  val name: String by db
  val password: String by db
  val phone: String by db
  val role_id: Int by db
  var version: Int? by db
  val application: String? by db
  val confirm_policy: Int? by db
  val registration_uuid: String? by db

  override fun invoke(): UserAccountTableModel {
    return UserAccountTableModel(_session)
  }

  private val toMember: (Row) -> UserAccountTable = { row ->
    UserAccountTable(
        row.long("id"),
        row.boolean("blocked"),
        row.boolean("change_password_on_login"),
        row.string("creation_date"),
        row.stringOrNull("creator"),
        row.boolean("deleted"),
        row.string("email"),
        row.string("login"),
        row.string("name"),
        row.string("password"),
        row.string("phone"),
        row.int("role_id"),
        row.intOrNull("version"),
        row.stringOrNull("application"),
        row.intOrNull("confirm_policy"),
        row.stringOrNull("registration_uuid"),
    )
  }

  override fun toData(): UserAccountTable {
    return UserAccountTable(
        id,
        blocked,
        change_password_on_login,
        creation_date,
        creator,
        deleted,
        email,
        login,
        name,
        password,
        phone,
        role_id,
        version,
        application,
        confirm_policy,
        registration_uuid
    )
  }

  companion object {
    const val tableName = "mx_moneyman.user_account"
  }

  fun useModel(): String {
    lateinit var user: List<UserAccountTable>
    using(mySqlClient.getDbConnection()) { session ->
      UserAccountTableModel(session)
      val allMembersQuery = sqlQuery("select * from mx_moneyman.user_account where id = 1007663")
      user = session.list(allMembersQuery, toMember)
    }
    return "$user"
  }
}