package PageObjectModel;

import commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

    public class RemoveFromCart extends Driver {
    //clickCart
    public void cartclick(){
           driver.findElement(By.id("hlb-view-cart-announce")).click();
    }
    //getCartPageItem
    public String cartpageitem(){
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           WebElement ctm=driver.findElement(By.xpath("//span[@class='a-size-medium sc-product-title a-text-bold']"));
           String cartitem=ctm.getText();
           return cartitem;
    }
    //clickDelete
    public void delete() throws InterruptedException {
           driver.findElement(By.xpath("//span[@class='a-declarative']//input")).click();
           Thread.sleep(4000);
    }
    //checkemptmsgisPresent
    public boolean isemptymsgpresent(){
           WebElement emptymsg=driver.findElement(By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']//h2"));
           return emptymsg.isDisplayed();
    }
    //getcartcount
    public String cartcount(){
        String cartnum=driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
        return cartnum;
    }
    }
