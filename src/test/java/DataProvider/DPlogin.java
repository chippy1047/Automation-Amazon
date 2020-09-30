package DataProvider;
import org.testng.annotations.DataProvider;
public class DPlogin {
    @DataProvider(name ="ValidLogin")
    public static Object[][] dataprovidervalidlogin() {
        return new Object[][]{
                {"9961930410","chippy1995"}
        };
    }
    @DataProvider(name ="InvalidLogin")
    public static Object[][] dataproviderinvalidlogin() {
        return new Object[][]{
                {"996193041185"}
        };
    }
    @DataProvider(name = "ValidSrch")
    public static Object[][] dataprovidersrch(){
       return new  Object[][] {
                { "iphone"}
        };
    }
    @DataProvider(name = "prdtdSrch")
    public static Object[][] dataproviderpdtsrch(){
        return new  Object[][] {
                { "iphone"}
        };
    }
    @DataProvider(name = "aDdToCaRt")
    public static Object[][] dataprovideradtocrt(){
        return new  Object[][] {
                { "iphone"}
        };
    }
    @DataProvider(name = "Pincode")
    public static Object[][] dataproviderpincode(){
        return new  Object[][] {
                { "690502"}
        };
    }
    @DataProvider(name = "InValidPincode")
    public static Object[][] dataproviderInpincode(){
        return new  Object[][] {
                { "123456"}
        };
    }
    @DataProvider(name = "aDdAddress")
    public static Object[][] dataprovideraddADDRESS(){
        return new  Object[][] {
                { "9961930410","admin1234","Chippy","8765432907","690502","xyzertyuiihgfgh"}
        };
    }
    @DataProvider(name = "chngpaswd")
    public static Object[][] dataproviderchangepassword(){
        return new  Object[][] {
                { "7558003133","admin345678","admin3459"}
        };
    }
}
