package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class CartPage extends PageBase {

  public static final By CHECKOUT_BUTTON_SELECTOR = By.className("checkout_button");

  @Override
  String endpointAddress() {
    return "cart.html";
  }


  public CartPage clickOnElement(By selector) {
    $(selector).click();
    return this;
  }
}
