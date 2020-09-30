package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.Invalidlogin;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidloginTest extends Driver {
       @Test(dataProvider = "InvalidLogin", dataProviderClass = DPlogin.class)
public void invalidlogin(String UserName) throws InterruptedException {
       Invalidlogin invalidlogin=new Invalidlogin(driver);
       invalidlogin.enterUsername(UserName);
       Thread.sleep(4000);
       boolean ermsgflag=invalidlogin.iserrmsgPesent();
       Assert.assertEquals(true,ermsgflag);
}
}
