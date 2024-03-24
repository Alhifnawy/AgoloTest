package Web;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import resources.POM.HomePage;
import java.util.concurrent.TimeUnit;

import static Web.WebTest.extent;

public class TestBase {

    public static WebDriver driver;

    public static HomePage homePage;
    public static ExtentTest test;
    public static ExtentReports extent;
    @BeforeClass
    public void setUp() {

    }

    @AfterClass
    public void close() {
        // Flush the report and close ExtentReports object
        extent.flush();
    }
    @BeforeMethod
    public void startDriver() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);

        homePage.navigateToURL("https://subscribe.stctv.com/");
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
        driver.quit();
    }
}