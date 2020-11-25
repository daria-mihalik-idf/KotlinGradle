package logger

import org.apache.log4j.LogManager
import org.apache.log4j.Logger
import java.nio.file.Path
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*

object TestLogger {
  private const val DEFAULT_LOGGER_NAME = "Logger"
  private val logFilePathPattern = "${getTodayDate()}${getSystemTime()}.log"

  fun getLogger(): Logger {
    val logsFilePath = getLogsPathToFile()
    val logger: Logger = LogManager.getLogger(DEFAULT_LOGGER_NAME)
    logger.addAppender(fileAppenderConfig(logsFilePath.toAbsolutePath().toString()))
    return logger
  }

  private fun getLogsPathToFile(): Path {
    return Paths.get(
        String.format(
            logFilePathPattern
        )
    )
  }

  private fun getTodayDate(): String = SimpleDateFormat("yyyyMMdd").format(Date())
  private fun getSystemTime(): String = SimpleDateFormat("HHmmssSSS").format(Date())
}