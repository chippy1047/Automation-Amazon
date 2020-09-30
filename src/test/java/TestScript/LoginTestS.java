package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.LoginPage;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

       public class LoginTestS extends Driver {
              @Test(dataProvider = "ValidLogin", dataProviderClass = DPlogin.class)
       public void validateLogin(String UsrNm, String Pswd) throws InterruptedException {
              LoginPage loginPage=new LoginPage(driver);
              boolean headandsignflag=loginPage.isheadersignInPesent();
              Assert.assertEquals(true,headandsignflag);
              loginPage.enterUsernameandPassword(UsrNm, Pswd);
              boolean wlcmflag=loginPage.iswlcmpresnt();
              Assert.assertEquals(true,wlcmflag);
              Thread.sleep(4000);
}
}
