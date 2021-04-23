package core.sqlClient.model

import com.vladsch.kotlin.jdbc.Model
import com.vladsch.kotlin.jdbc.Session

class UserAccountTableModel(
    session: Session?,
    quote: String? = null
) : Model<UserAccountTableModel, UserAccountTable>(session, tableName, true, false, quote) {

  var id: Long? by db
  val blocked: Boolean by db
  val change_password_on_login: Boolean by db
  val creation_date: String? by db
  val creator: String? by db
  val deleted: Boolean by db
  val email: String? by db
  val login: String? by db
  val name: String? by db
  val password: String? by db
  val phone: String? by db
  val role_id: Int? by db
  var version: Int? by db
  val application: String? by db
  val confirm_policy: Int? by db
  val registration_uuid: String? by db

  override fun invoke(): UserAccountTableModel {
    return UserAccountTableModel(_session)
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
    const val tableName = "user_account"
  }
}