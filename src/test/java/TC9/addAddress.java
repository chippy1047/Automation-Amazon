package TC9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class addAddress {
    @FindBy(xpath = "//span[@class='nav-line-2 nav-long-width']")
    private WebElement accountclick;
    @FindBy(xpath = "//img[@alt='Your Addresses']")
    private WebElement addressclick;
    @FindBy(xpath = "//a[@id='ya-myab-address-add-link']//div")
    private WebElement Addaddress;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    private WebElement Fullname;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    private WebElement Mob;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']")
    private WebElement pincode;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    private WebElement Housename;
    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement AddAddress;
//    @FindBy(xpath = "//input[@class='a-button-input']")
//    private WebElement City;
    @FindBy(xpath = "//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@class='a-button-text a-declarative']")
    private WebElement State;
    public addAddress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void AcccountClick() {
        accountclick.click();
    }
    public void AddressClick(String name,String mob,String pin,String house){
        addressclick.click();
        Addaddress.click();
        Fullname.sendKeys(name);
        Mob.sendKeys(mob);
        pincode.sendKeys(pin);
        Housename.sendKeys(house);
        //City.sendKeys(city);
        Select drpCountry = new Select(State);//quantity locator
        drpCountry.selectByVisibleText("KERALA");
        AddAddress.click();
        }
    }
