package core.sqlClient

class SqlQuery {

  val userAccountSelectByIdQuery: String = """
    select * from mx_moneyman.user_account
    where id = %S
  """.trimIndent()

  val userAccountSelectByEmailQuery: String = """
    select * from mx_moneyman.user_account
    where role_id = %S
  """.trimIndent()
}