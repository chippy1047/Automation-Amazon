package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.PasswordChange;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordChangeTestScript extends Driver {
       @Test(dataProvider = "chngpaswd", dataProviderClass = DPlogin.class)
public void ChangePassword(String UsrNm, String Pswd,String nwpswd) throws InterruptedException {
    PasswordChange passwordChange=new PasswordChange(driver);
    passwordChange.enterUsernameandPassword(UsrNm,Pswd);
    passwordChange.changepassword(Pswd,nwpswd);
    boolean successmsg=passwordChange.issuccessmsgPesent();
    Assert.assertEquals(successmsg,true);
}
}
