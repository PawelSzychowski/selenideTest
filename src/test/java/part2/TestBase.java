package part2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
}
