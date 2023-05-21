package part2;

import static team.jit.qa.meeting.CartPage.CHECKOUT_BUTTON_SELECTOR;
import static team.jit.qa.meeting.CheckoutStepOnePage.CONTINUE_BUTTON_SELECTOR;
import static team.jit.qa.meeting.CheckoutStepTwoPage.FINISH_BUTTON_SELECTOR;
import static team.jit.qa.meeting.InventoryPage.ADD_BACKPACK_TO_CART_SELECTOR;
import static team.jit.qa.meeting.InventoryPage.SHOPPING_CART_LINK_SELECTOR;
import static team.jit.qa.meeting.LoginPage.LOGIN_BUTTON_SELECTOR;

import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.Test;
import team.jit.qa.meeting.CartPage;
import team.jit.qa.meeting.CheckoutCompletePage;
import team.jit.qa.meeting.CheckoutStepOnePage;
import team.jit.qa.meeting.CheckoutStepTwoPage;
import team.jit.qa.meeting.InventoryPage;
import team.jit.qa.meeting.LoginPage;

public class UserBuyProductTest extends TestBase {

  private final LoginPage loginPage;
  private final InventoryPage inventoryPage;
  private final CartPage cartPage;
  private final CheckoutStepOnePage checkoutStepOnePage;
  private final CheckoutStepTwoPage checkoutStepTwoPage;
  private final CheckoutCompletePage checkoutCompletePage;

  @Inject
  public UserBuyProductTest(LoginPage loginPage, InventoryPage inventoryPage,
      CartPage cartPage, CheckoutStepOnePage checkoutStepOnePage,
      CheckoutStepTwoPage checkoutStepTwoPage,
      CheckoutCompletePage checkoutCompletePage) {
    this.loginPage = loginPage;
    this.inventoryPage = inventoryPage;
    this.cartPage = cartPage;
    this.checkoutStepOnePage = checkoutStepOnePage;
    this.checkoutStepTwoPage = checkoutStepTwoPage;
    this.checkoutCompletePage = checkoutCompletePage;
  }


  @Test
  public void buyBackPackByStandardUser() {
    //Given
    String expected = "Thank you for your order!";
    //When
    loginPage.openPage();
    loginPage.setUsername("standard_user")
        .setPassword("secret_sauce")
        .click(LOGIN_BUTTON_SELECTOR);
    inventoryPage
        .clickOnElement(ADD_BACKPACK_TO_CART_SELECTOR)
        .clickOnElement(SHOPPING_CART_LINK_SELECTOR);
    cartPage.clickOnElement(CHECKOUT_BUTTON_SELECTOR);
    checkoutStepOnePage
        .setFirstName("John")
        .setLastName("Doe")
        .setPostalCode("00-000")
        .clickOnElement(CONTINUE_BUTTON_SELECTOR);
    checkoutStepTwoPage
        .validateLabelValue("Free Pony Express Delivery!")
        .clickOnElement(FINISH_BUTTON_SELECTOR);
    String actual = checkoutCompletePage
        .getCompleteHeaderText();
    //Then
    Assert.assertEquals(actual, expected);
  }
}