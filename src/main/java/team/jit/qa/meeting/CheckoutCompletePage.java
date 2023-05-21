package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends PageBase {

  public static final By COMPLETE_HEADER_SELECTOR = By.className("complete-header");

  @Override
  String endpointAddress() {
    return "checkout-complete.html";
  }


  public CheckoutCompletePage clickOnElement(By selector) {
    $(selector).click();
    return this;
  }

  public String getCompleteHeaderText() {
    return $(COMPLETE_HEADER_SELECTOR).getText();
  }
}
