package core.context

object ContextHolder {

  private var context: Context? = null

  fun getDefaultContext(): Context {
    if (context == null) {
      context = DefaultContext()
    }
    return context!!
  }
}