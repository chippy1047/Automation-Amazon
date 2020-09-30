package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

          public class ProductDetails extends Driver{
//          @FindBy(xpath = "//span[contains(text(),'Apple iPhone 11 (128GB) - White')]")
//          private WebElement productdetails;
        @FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (128GB) - Black')]")
         private WebElement productdetails;
          public ProductDetails(WebDriver driver){
                 PageFactory.initElements(driver, this);
          }
          //item list
          public void prdtdts(){
                 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                 productdetails.click();
          }
          //crct prdt
          public String chkprdtitm()  {
                 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                 WebElement prdtname=driver.findElement(By.xpath("//span[@id='productTitle']"));
                 String result=prdtname.getText();
                 return result;
          }
          //item list gettext
          public String itemlist(){
                 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                 String rst=productdetails.getText();
                 return rst;
          }
          public void changetab(){
              ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
              driver.switchTo().window(tabs2.get(1));
          }
          }
