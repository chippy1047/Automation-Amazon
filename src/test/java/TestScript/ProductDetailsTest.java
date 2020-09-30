package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.ProductDetails;
import PageObjectModel.Search;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends Driver {
       @Test(dataProvider = "prdtdSrch", dataProviderClass = DPlogin.class)
public void prdtvalidatsrch(String pdt) throws InterruptedException {
       Search search = new Search(driver);
       //searchitemfun
       search.srchitem(pdt);
       //resultpagefunc
       String Srchrslt=search.CheckResultPage();
       //verifyUsershouldbeincorrectpage
       Assert.assertEquals(Srchrslt,pdt);
       ProductDetails productDetails = new ProductDetails(driver);
       //item list gettext
       String itemlist=productDetails.itemlist();
       //clicking in item list
       productDetails.prdtdts();
       //changetab
       productDetails.changetab();
       //getcorrectproducttext
       String crctitm=productDetails.chkprdtitm();
       Assert.assertEquals(crctitm,itemlist);
}
}



