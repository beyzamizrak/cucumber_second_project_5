package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SmartBearHomePage {

    public SmartBearHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#ctl00_menu>li")
    public List<WebElement> menuItems;

    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement CheckAllButton;

    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;

    @FindBy(css = "#ctl00_MainContent_orderGrid input[type='checkbox']")
    public WebElement checkBoxes;

    @FindBy(id =  "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = "//ol[2]//input")
    public List<WebElement> inputs;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaOption;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelected;

    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement message;

    @FindBy(id = "ctl00_MainContent_orderGrid")
    public WebElement table;



}
