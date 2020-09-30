package PageObjectModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

     public class Search {
    //searchbox
     @FindBy(xpath ="//input[@id='twotabsearchtextbox']")
     private WebElement srch;
     //searchbutton
     @FindBy(xpath = "//input[@type='submit']")
     private WebElement scrhbtn;
     //resultpage
     @FindBy(xpath = "//span[text()='\"iphone\"']")//srch eqal sided print
     private WebElement rsltpg;
     public Search(WebDriver driver){
            PageFactory.initElements(driver, this);
     }
     //searchitemfunc
     public void srchitem(String srchitm) throws InterruptedException {
            srch.sendKeys(srchitm);
            Thread.sleep(2000);
            scrhbtn.click();
            Thread.sleep(4000);
     }
     //resultpagefunc
     public String CheckResultPage() {
            String rlt=rsltpg.getText();
            rlt=rlt.replaceAll("^[\"']+|[\"']+$", "");
            return rlt;
     }
     }
