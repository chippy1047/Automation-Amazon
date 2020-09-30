package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.InvalidPincode;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidPincodeTestScript extends Driver {
       @Test(dataProvider = "InValidPincode", dataProviderClass = DPlogin.class)
public void InValidPincode(String pincode) throws InterruptedException {
       InvalidPincode invalidPincode=new InvalidPincode(driver);
       invalidPincode.selectyouraddressclick();
       invalidPincode.Enterpincode(pincode);
       boolean value=invalidPincode.iserrormsgPesent();
       Assert.assertEquals(value,true);
}
}
