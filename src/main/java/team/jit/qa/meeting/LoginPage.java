package team.jit.qa.meeting;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {

  public static final By USER_NAME_SELECTOR = By.id("user-name");
  public static final By PASSWORD_BUTTON_SELECTOR = By.id("password");
  public static final By LOGIN_BUTTON_SELECTOR = By.id("login-button");
  public static final By ERROR_MESSAGE_CONTAINER = By.className("error-message-container");

  @Override
  String endpointAddress() {
    return "";
  }

  public LoginPage click(By selector) {
    $(selector).click();
    return this;
  }

  public String getTextFromSelector(By selector) {
    return $(selector).getText();
  }

  public LoginPage setUsername(String username) {
    $(USER_NAME_SELECTOR).setValue(username);
    return this;
  }

  public LoginPage setPassword(String password) {
    $(PASSWORD_BUTTON_SELECTOR).setValue(password);
    return this;
  }
}
