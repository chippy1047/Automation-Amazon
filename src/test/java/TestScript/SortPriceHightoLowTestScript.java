package TestScript;

import DataProvider.DPlogin;
import PageObjectModel.Search;
import PageObjectModel.SortPriceHightoLow;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SortPriceHightoLowTestScript extends Driver {
    @Test(dataProvider = "ValidSrch",dataProviderClass = DPlogin.class)
    public void Sort(String pdt) throws InterruptedException {
        Search search=new Search(driver);
        search.srchitem(pdt);
        SortPriceHightoLow sorting=new SortPriceHightoLow(driver);
        sorting.SetHightoLow();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String text=sorting.extracthightolow();
        Assert.assertEquals(text,"Sort by:Price: High to Low");
    }
}
