package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class CheckoutStepOnePage extends PageBase {

  public static final By CONTINUE_BUTTON_SELECTOR = By.className("submit-button");
  public static final By FIRST_NAME_INPUT_SELECTOR = By.name("firstName");
  public static final By LAST_NAME_INPUT_SELECTOR = By.name("lastName");
  public static final By POSTAL_CODE_INPUT_SELECTOR = By.name("postalCode");

  @Override
  String endpointAddress() {
    return "checkout-step-one.html";
  }


  public CheckoutStepOnePage clickOnElement(By selector) {
    $(selector).click();
    return this;
  }

  public CheckoutStepOnePage setFirstName(String firstName) {
    $(FIRST_NAME_INPUT_SELECTOR).setValue(firstName);
    return this;
  }

  public CheckoutStepOnePage setLastName(String lastName) {
    $(LAST_NAME_INPUT_SELECTOR).setValue(lastName);
    return this;
  }

  public CheckoutStepOnePage setPostalCode(String postalCode) {
    $(POSTAL_CODE_INPUT_SELECTOR).setValue(postalCode);
    return this;
  }
}
