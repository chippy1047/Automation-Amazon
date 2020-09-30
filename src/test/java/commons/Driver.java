package commons;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Driver implements ITestListener {
    static ExtentReports reports;
    static ExtentSparkReporter extentSparkReporter;
    static ExtentTest extentTest;
    @BeforeSuite
    public void initalExtendReport() throws IOException {
        String path=System.getProperty("user.dir");
        reports=new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter(path+"\\report\\report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        reports.attachReporter(extentSparkReporter);
    }
    public static WebDriver driver=null;
    @BeforeMethod
    public static WebDriver openbrowser() {
        File file = new File("src//main//resources//CONFIG.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String url=prop.getProperty("url");
        String browser=prop.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","Driver//chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "Driver//IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions ieoptions = new InternetExplorerOptions(capabilities);
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public static String takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        String file = "ss" + random.nextInt(1000) + ".png";
        String fileName = System.getProperty("user.dir") + "\\report\\" + file;
        File destinationFile = new File(fileName);
        FileUtils.copyFile(screenshot, destinationFile);
        return file;
    }
    @AfterMethod
  public static void Closebrowser(ITestResult result) throws IOException {
       driver.quit();
    }
    public void onTestSuccess(ITestResult result){
        extentTest=reports.createTest(result.getName());
        extentTest.log(Status.PASS, result.getName());
        try{
            extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void onTestFailure(ITestResult result){
        extentTest=reports.createTest(result.getName());
        extentTest.log(Status.FAIL, result.getName());
        try{
            extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult result){
        extentTest=reports.createTest(result.getName());
        extentTest.log(Status.SKIP, result.getName());
    }
    public void onFinish(ITestContext context){
        reports.flush();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
