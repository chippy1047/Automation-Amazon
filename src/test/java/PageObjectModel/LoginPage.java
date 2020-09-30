package PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage {
    @FindBy(xpath = "//span[text()='Hello, Sign in']")
    private WebElement header;
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
    @FindBy(xpath = "//span[text()='Hello, Chippy'] ")
    private WebElement txt_wlcmmsg;
    public LoginPage(WebDriver driver){
           PageFactory.initElements(driver, this);
    }
    public void enterUsernameandPassword(String Username, String Password) {
           signIn.click();
           userName.sendKeys(Username);
           continuee.click();
           password.sendKeys(Password);
           login.click();
    }
    public boolean isheadersignInPesent(){
           return header.isDisplayed();
    }
    public boolean iswlcmpresnt(){
           return txt_wlcmmsg.isDisplayed();
    }
    }