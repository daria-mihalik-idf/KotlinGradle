package core

data class CrmUser(var crmLoginMail: String, var crmLoginPassword: String, val crmCaptchaValue: String) {
}
