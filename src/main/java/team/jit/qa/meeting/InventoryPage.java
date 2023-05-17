package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import java.time.Duration;
import org.openqa.selenium.By;

public class InventoryPage extends PageBase {

  public static final By TITLE_SELECTOR = By.className("title");

  @Override
  String endpointAddress() {
    return "inventory.html";
  }

  public String getTitleText() {
    return $(TITLE_SELECTOR).shouldBe(Condition.exist, Duration.ofSeconds(10)).getText();
  }
}
