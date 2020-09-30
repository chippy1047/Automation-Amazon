package TestScript;

import DataProvider.DPlogin;
import PageObjectModel.*;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaveForLaterTest extends Driver {
       @Test(dataProvider = "aDdToCaRt",dataProviderClass = DPlogin.class)
public void SaveforLater(String prdt) throws InterruptedException {
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
    //clickingAddtoCart
    addCart.clickaddtocart();
    RemoveFromCart rmvfrmcrt=new RemoveFromCart();
    //clickCart
    rmvfrmcrt.cartclick();
    //getCartPageItem
    String cartitem=rmvfrmcrt.cartpageitem();
    //checkPrdtandCartpageproduct
    Assert.assertEquals(cartitem,crctitm);
    SaveForLater saveForLater=new SaveForLater();
    //clicksavelaterbtn
    saveForLater.savelater();
    //saveforlaterpageandmsgispresent
    boolean msgprsnt=saveForLater.isIteminsaveforLater();
    //checksaveforlatermsgis present
    Assert.assertEquals(msgprsnt,true);
    ////prdtissameinsaveforlaterpage
    String prdtInSvFrLatr=saveForLater.prdtsameInsavefrLater();
    //checkcartprdtissameasSaveforlaterpdt
    Assert.assertEquals(prdtInSvFrLatr,cartitem);
    //getcartcount
    String cartnumber=rmvfrmcrt.cartcount();
    //checkcartcountiszero
    Assert.assertEquals(cartnumber,"0");


}}
