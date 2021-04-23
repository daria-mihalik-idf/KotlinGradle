package core.sqlClient

class SqlQuery {

  val userAccountSelectByIdQuery: String = """
    select * from mx_moneyman.user_account
    where id = :id
  """.trimIndent()

  val userAccountSelectByRoleIdQuery: String = """
    select * from mx_moneyman.user_account
    where role_id = :role_id 
    limit 2
  """.trimIndent()
}