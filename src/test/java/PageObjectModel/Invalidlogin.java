package PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class Invalidlogin {
    @FindBy(xpath = "//span[text()='Hello, Sign in']")
    private WebElement header;
    @FindBy(linkText="Sign in")
    private WebElement signIn;
    @FindBy(id="ap_email")
    private WebElement userName;
    @FindBy(className="a-button-input")
    private WebElement continuee;
    @FindBy(xpath = "//h4[text()='Incorrect phone number']")
    private WebElement ermsg;
    public Invalidlogin(WebDriver driver) {
           PageFactory.initElements(driver, this);
    }
    public void enterUsername(String Username) {
           signIn.click();
           userName.sendKeys(Username);
           continuee.click();
    }
    public boolean isheadersignInPesent(){
           return header.isDisplayed();
    }
    public boolean iserrmsgPesent() {
           return ermsg.isDisplayed();
    }
    }

