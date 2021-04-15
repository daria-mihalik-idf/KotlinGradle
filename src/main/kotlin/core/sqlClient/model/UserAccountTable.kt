package core.sqlClient.model

data class UserAccountTable(
    var id: Long?,
    val blocked: Boolean,
    val change_password_on_login: Boolean,
    val creation_date: String,
    val creator: String?,
    val deleted: Boolean,
    val email: String,
    val login: String,
    val name: String,
    val password: String,
    val phone: String,
    val role_id: Int,
    val version: Int?,
    val application: String?,
    val confirm_policy: Int?,
    val registration_uuid: String?
)