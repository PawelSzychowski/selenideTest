package part1;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest {

  @Test
  public void userCanSearch() {
    open("https://google.com");
    String selenideJava = new GooglePage().acceptCookie().searchFor("selenide java")
        .getTextFromButton();
    Assert.assertEquals(selenideJava, "Wszystko");
  }

  public static class GooglePage {

    public GooglePage acceptCookie() {
      $(By.id("L2AGLb")).click();
      return this;
    }

    public GooglePage searchFor(String text) {
      $(By.name("q")).val(text).pressEnter();
      return this;
    }

    public String getTextFromButton() {
      return $(By.className("hdtb-mitem")).getText();
    }
  }
}
