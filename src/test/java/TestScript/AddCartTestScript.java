package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.AddCart;
import PageObjectModel.ProductDetails;
import PageObjectModel.Search;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCartTestScript extends Driver {
    @Test(dataProvider = "aDdToCaRt",dataProviderClass = DPlogin.class)
    public void AddToCart(String prdt) throws InterruptedException {
        AddCart addCart=new AddCart(driver);
        int crtnum=addCart.cartnum();
        Assert.assertEquals(crtnum,0);
        Search search = new Search(driver);
        //searchitemfun
        search.srchitem(prdt);
        //resultpagefunc
        String Srchrslt=search.CheckResultPage();
        //verifyUsershouldbeincorrectpage
        Assert.assertEquals(Srchrslt,prdt);
        ProductDetails productDetails = new ProductDetails(driver);
        //item list gettext
        String itemlist=productDetails.itemlist();
        //clicking in item list
        productDetails.prdtdts();
        //changetab
        productDetails.changetab();
        //getcorrectproducttext
        String crctitm=productDetails.chkprdtitm();
        //checkingPrdtDetailsMatchWithItemdetails
        Assert.assertEquals(crctitm,itemlist);
        //clickitemquantityto3
        addCart.changequntitytothree();
        //clickingAddtoCart
        addCart.clickaddtocart();
        //getupdatedquantity
        String NAVCRTNUM=addCart.getquantity();
        //checking3withupdatedquantity
        Assert.assertEquals(NAVCRTNUM,"3");
    }
}
