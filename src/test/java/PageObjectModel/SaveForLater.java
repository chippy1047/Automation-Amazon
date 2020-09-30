package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class SaveForLater extends Driver {
    //clicksaveforlater
    public void savelater() throws InterruptedException {
           driver.findElement(By.xpath("//input[@aria-label='Save for later Apple iPhone XR (128GB) - Black']")).click();
           Thread.sleep(4000);
    }
    //saveforlaterpageandmsgispresent
    public boolean isIteminsaveforLater(){
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           WebElement msgprsnt=driver.findElement(By.xpath("//div[@id='sc-saved-cart-list-caption-text']"));
           return msgprsnt.isDisplayed();
    }
    //prdtissameinsaveforlaterpage
    public String prdtsameInsavefrLater(){
           String prdtInsvFrlatr=driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']")).getText();
           return prdtInsvFrlatr;
    }
}
