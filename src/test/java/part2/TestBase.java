package part2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Guice;

@Guice
public class TestBase {

  @BeforeMethod
  void setUp() {
    Configuration.baseUrl = "https://www.saucedemo.com/";
  }

  @AfterMethod
  void cleanup() {
    Selenide.clearBrowserCookies();
    Selenide.closeWindow();
  }

  @BeforeSuite
  static void setupAllureReports() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
        .screenshots(true)
        .savePageSource(true));

  }
}
