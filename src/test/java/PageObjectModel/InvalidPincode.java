package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvalidPincode {
    @FindBy(xpath ="//span[@id='glow-ingress-line2']")
    private WebElement slctyradrs;
    @FindBy(xpath = "//input[@id='GLUXZipUpdateInput']")
    private WebElement enterapincode;
    @FindBy(xpath ="//input[@aria-labelledby='GLUXZipUpdate-announce']" )
    private WebElement applyclick;
    @FindBy(xpath ="//span[@id='glow-ingress-line2']" )
    private WebElement headerpincode;
    @FindBy(xpath ="//div[@class='a-box-inner a-alert-container']")
    private WebElement errormsg;
    public InvalidPincode(WebDriver driver){
        PageFactory.initElements(driver,this); }
    public void selectyouraddressclick(){
        slctyradrs.click();
    }
    public void Enterpincode(String pincode) throws InterruptedException {
        Thread.sleep(4000);
        enterapincode.sendKeys(pincode);
        applyclick.click();
        Thread.sleep(4000);
    }
    public boolean iserrormsgPesent() {
        return errormsg.isDisplayed();
    }
}
