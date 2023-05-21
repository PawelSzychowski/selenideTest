package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import java.time.Duration;
import org.openqa.selenium.By;

public class InventoryPage extends PageBase {

  public static final By TITLE_SELECTOR = By.className("title");
  public static final By SHOPPING_CART_LINK_SELECTOR = By.className("shopping_cart_link");
  public static final By ADD_BACKPACK_TO_CART_SELECTOR = By.id("add-to-cart-sauce-labs-backpack");

  @Override
  String endpointAddress() {
    return "inventory.html";
  }

  public String getTitleText() {
    return $(TITLE_SELECTOR).shouldBe(Condition.exist, Duration.ofSeconds(10)).getText();
  }

  public InventoryPage clickOnElement(By selector) {
    $(selector).click();
    return this;
  }
}
