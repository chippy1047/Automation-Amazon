package PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortPriceHightoLow {
    @FindBy(id="twotabsearchtextbox")
    private WebElement srch;
    @FindBy(className = "nav-input")
    private WebElement scrhbtn;
    @FindBy(xpath = "//span[@id='a-autoid-0-announce']")
    private WebElement sortby;
    @FindBy(xpath ="//a[@id='s-result-sort-select_2']")
    private WebElement hightolowclick;
   @FindBy(xpath = "//span[@id='a-autoid-2-announce']")
    private WebElement getTexthightolow;


    public SortPriceHightoLow(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
public void SetHightoLow() throws InterruptedException {
    sortby.click();
    //Thread.sleep(2000);
    hightolowclick.click();
    }
    public String extracthightolow(){
        String HighToLow=getTexthightolow.getText();
        System.out.println(HighToLow);
        return HighToLow;
    }
}
