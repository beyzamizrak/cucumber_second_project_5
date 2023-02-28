package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearHomePage;
import pages.SmartBearLoginPage;
import utils.Driver;
import utils.DropdownHandler;
import utils.TableHandler;
import utils.Waiter;

import java.util.List;

public class SmartBearSteps {


    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;

    SmartBearHomePage smartBearHomePage;

    List<WebElement> tableRow;



    @Before
    public void setUp(){
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearHomePage = new SmartBearHomePage();
    }


    @Given("user is on {String} ")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user enters username as {String}")
    public void userEntersUsername(String username) {
        smartBearLoginPage.usernameInputBox.sendKeys(username);
    }

    @And("user enters password as {String}")
    public void userEntersPassword(String password) {
        smartBearLoginPage.passwordInputBox.sendKeys(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        smartBearLoginPage.logInButton.click();
    }

    @Then("user should see {String} message")
    public void userShouldSeeInvalidLoginOrPasswordMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, smartBearLoginPage.invalidLoginMessage.getText());
    }

    @When("user enters username as {String}")
    public void userEntersUsernameAsTester(String username) {
        smartBearLoginPage.usernameInputBox.sendKeys(username);
    }

    @And("user enters password as {String}")
    public void userEntersPasswordAsTest(String password) {
        smartBearLoginPage.passwordInputBox.sendKeys(password);
    }

    @Then("user should be routed to {String}")
    public void userShouldBeRoutedTo(String url) {
        driver.get(url);
    }

    @And("validate below menu items are displayed")
    public void validateBelowMenuItemsAreDisplayed(DataTable items) {
        for (int i = 0; i < items.asList().size(); i++) {
            Assert.assertEquals(items.asList().get(i), smartBearHomePage.menuItems.get(i).getText());
        }
    }

    @When("user clicks on {String} button")
    public void userClicksOnButton(String button) {
        switch(button) {
            case "Check All":
                smartBearHomePage.CheckAllButton.click();
                break;
            case "Uncheck All":
                smartBearHomePage.uncheckAllButton.click();
                break;
            case "Process":
                smartBearHomePage.processButton.click();
                break;
            case "Delete Selected":
                smartBearHomePage.deleteSelected.click();
                break;
            default:
                throw new NotFoundException("This button doesn't exist!");
        }
    }

    @Then("all rows should be checked")
    public void allRowsShouldBeChecked() {
        Assert.assertTrue(smartBearHomePage.checkBoxes.isSelected());
    }


    @Then("all rows should be unchecked")
    public void allRowsShouldBeUnchecked() {
        Assert.assertFalse(smartBearHomePage.checkBoxes.isSelected());
    }

    @When("user clicks on {String} menu item")
    public void userClicksOnOrderMenuItem(String option) {
        switch (option){
            case "Order":
                smartBearHomePage.menuItems.get(2).click();
            case "View all orders":
                smartBearHomePage.menuItems.get(0).click();
                break;
            default:
                throw new NotFoundException("This menu option doesn't exist!");
        }

    }

    @And("user selects {String} as product")
    public void userSelectsFamilyAlbumAsProduct(String product) {
        DropdownHandler.selectByVisibleText(smartBearHomePage.dropdown, product);
    }

    @And("user enters 2 as quantity")
    public void userEntersAsQuantity() {
        smartBearHomePage.quantityBox.sendKeys("2");
    }

    @And("user enters all address information")
    public void userEntersAllAddressInformation(DataTable addressInfo) {
        for (int i = 0; i < addressInfo.asList().size(); i++) {
            smartBearHomePage.inputs.get(i).sendKeys(addressInfo.asList().get(i));
        }
        Waiter.pause(4);
    }

    @And("user enters all payment information")
    public void userEntersAllPaymentInformation() {
        smartBearHomePage.visaOption.click();
        smartBearHomePage.cardNumber.sendKeys("2332345676547893");
        smartBearHomePage.expireDate.sendKeys("21/25");
    }


    @Then("user should see their order displayed in the “List of All Orders” table")
    public void userShouldSeeTheirOrderDisplayedInTheListOfAllOrdersTable() {
            tableRow = TableHandler.getTableRow(driver, 2);
            for (int i = 0; i < tableRow.size() - 1; i++) {
                Assert.assertTrue(tableRow.get(i).isDisplayed());
            }

    }

    @And("validate all information entered displayed correct with the order")
    public void validateAllInformationEnteredDisplayedCorrectWithTheOrder(DataTable orderInfo) {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertEquals(orderInfo.asList().get(i), tableRow.get(i).getText());
        }

    }


    @Then("validate all orders are deleted from the “List of All Orders”")
    public void validateAllOrdersAreDeletedFromTheListOfAllOrders() {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertFalse(tableRow.get(i).isDisplayed());
        }
    }

    @And("validate user sees {String} message")
    public void validateUserSeesMessage(String message) {
        Assert.assertEquals(message, smartBearHomePage.message.getText());
    }
}
