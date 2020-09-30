package TC9;
import DataProvider.DPlogin;
import PageObjectModel.LoginPage;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addAddressTestScript extends Driver {
    @Test(dataProvider = "aDdAddress", dataProviderClass = DPlogin.class)
    public void validPincode(String UsrNm, String Pswd,String name,String mob,String pin,String housename) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        boolean headandsignflag=loginPage.isheadersignInPesent();
        Assert.assertEquals(true,headandsignflag);
        loginPage.enterUsernameandPassword(UsrNm, Pswd);
        boolean wlcmflag=loginPage.iswlcmpresnt();
        Assert.assertEquals(true,wlcmflag);
        Thread.sleep(4000);
        addAddress address=new addAddress(driver);
        address.AcccountClick();
        address.AddressClick(name,mob,pin,housename);
        Thread.sleep(4000);
    }
}
