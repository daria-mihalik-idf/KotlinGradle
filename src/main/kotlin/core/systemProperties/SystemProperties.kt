package core.systemProperties

interface SystemProperties {
  fun getName(): String
  fun get(): String? = System.getProperty(getName())
  fun getDefault(defaultValue: String): String = System.getProperty(getName()) ?: defaultValue
  fun set(value: String): String? = System.setProperty(getName(), value)
}
