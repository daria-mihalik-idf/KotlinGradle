package logger

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object TestLogger {
  private const val DEFAULT_LOGGER_NAME = "Logger"

  fun getLogger(): Logger {
    return LogManager.getLogger(DEFAULT_LOGGER_NAME)
  }
}