package part2;

import static team.jit.qa.meeting.LoginPage.ERROR_MESSAGE_CONTAINER;
import static team.jit.qa.meeting.LoginPage.LOGIN_BUTTON_SELECTOR;

import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;
import team.jit.qa.meeting.LoginPage;

public class UserLoginToPageTest extends TestBase {

  private final LoginPage loginPage;

  @Inject
  public UserLoginToPageTest(LoginPage loginPage) {
    this.loginPage = loginPage;
  }

  @Test
  public void provideWrongUsernameWithoutPasswordWhenLoginShouldGiveError() {
    //given
    String expected = "Epic sadface: Password is required";
    //when
    loginPage.openPage();
    loginPage.setUsername("TestValue")
        .click(LOGIN_BUTTON_SELECTOR);
    String actual = loginPage.getTextFromSelector(ERROR_MESSAGE_CONTAINER);
    //then
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void loginWithWrongShouldCaseError() {
    //given
    String expected = "Epic sadface: Username and password do not match any user in this service";
    //when
    loginPage.openPage();
    loginPage.setUsername("TestValue")
        .setPassword("TestValue")
        .click(LOGIN_BUTTON_SELECTOR);
    String actual = loginPage.getTextFromSelector(ERROR_MESSAGE_CONTAINER);
    //then
    Assert.assertEquals(actual, expected);
  }
}