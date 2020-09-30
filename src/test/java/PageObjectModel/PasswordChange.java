package PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordChange {
    @FindBy(linkText = "Sign in")
    private WebElement signIn;
    @FindBy(id = "ap_email")
    private WebElement userName;
    @FindBy(className = "a-button-input")
    private WebElement continuee;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(id = "signInSubmit")
    private WebElement login;
    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement accountclick;
    @FindBy(xpath = "//img[@alt='Login & security']")
    private WebElement loginandsecurity;
    @FindBy(xpath = "//input[@id='auth-cnep-edit-password-button']")
    private WebElement editpswdbutn;
    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement currentpswdentr;
    @FindBy(xpath = "//input[@id='ap_password_new']")
    private WebElement newpswd;
    @FindBy(xpath = "//input[@id='ap_password_new_check']")
    private WebElement reentrnwpswd;
    @FindBy(xpath = "//input[@id='cnep_1D_submit_button']")
    private WebElement savebtn;
    @FindBy(xpath = "//div[@class='a-alert-content']")
    private WebElement successmsg;
    public PasswordChange(WebDriver driver){
           PageFactory.initElements(driver, this);
    }
    public void enterUsernameandPassword(String Username, String Password) throws InterruptedException {
           signIn.click();
           userName.sendKeys(Username);
           continuee.click();
           password.sendKeys(Password);
           Thread.sleep(4000);
           login.click();
    }
    public void changepassword(String curntpswd,String newpaswd) throws InterruptedException {
           Thread.sleep(4000);
           accountclick.click();
           loginandsecurity.click();
           editpswdbutn.click();
           currentpswdentr.sendKeys(curntpswd);
           newpswd.sendKeys(newpaswd);
           reentrnwpswd.sendKeys(newpaswd);
           savebtn.click();
    }
    public boolean issuccessmsgPesent(){
           return successmsg.isDisplayed();
    }
    }
