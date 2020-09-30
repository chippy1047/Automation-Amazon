package TestScript;

import DataProvider.DPlogin;
import PageObjectModel.Search;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTestScript extends Driver {
    @Test(dataProvider = "ValidSrch",dataProviderClass = DPlogin.class)
public void validatsrch(String pdt) throws InterruptedException {
       Search search=new Search(driver);
       search.srchitem(pdt);
       String Srchrslt=search.CheckResultPage();//check user should be in result page
       Assert.assertEquals(Srchrslt,pdt);
}
}