package ui.elements

import com.codeborne.selenide.Selenide
import logger.TestLogger

object Navigation {

  fun openUrl(url: String) {
    TestLogger.getLogger().info("Open Page $url")
    Selenide.open(url)
  }
}