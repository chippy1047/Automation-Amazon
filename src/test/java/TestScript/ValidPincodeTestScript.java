package TestScript;
import DataProvider.DPlogin;
import PageObjectModel.ValidPincode;
import commons.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidPincodeTestScript extends Driver {
       @Test(dataProvider = "Pincode", dataProviderClass = DPlogin.class)
public void pincodevalidate(String pincode) throws InterruptedException {
       ValidPincode validPincode=new ValidPincode(driver);
       validPincode.selectyouraddressclick();
       validPincode.Enterpincode(pincode);
       String extractpincode=validPincode.Validateheaderpincode();
       Assert.assertEquals(extractpincode,pincode);
}
}
