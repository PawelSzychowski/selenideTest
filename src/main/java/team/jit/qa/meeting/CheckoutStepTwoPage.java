package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

public class CheckoutStepTwoPage extends PageBase {

  public static final By FINISH_BUTTON_SELECTOR = By.id("finish");
  public static final By VALUE_LABEL_SELECTOR = By.className("summary_value_label");

  @Override
  String endpointAddress() {
    return "checkout-step-two.html";
  }


  public CheckoutStepTwoPage clickOnElement(By selector) {
    $(selector).click();
    return this;
  }

  public CheckoutStepTwoPage validateLabelValue(String value) {
    $$(VALUE_LABEL_SELECTOR).shouldBe(CollectionCondition.itemWithText(value));
    return this;
  }

}
