package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.OfficesPage;
import pages.PartnersPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class ValtechTest {
    private RemoteWebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException {
        //to run on docker
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), capabilities);

        //to run locally
//        if(browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
//            driver = new ChromeDriver();
//        }
//        if(browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
//            driver = new FirefoxDriver();
//        }
//        if(browser.equalsIgnoreCase("edge")) {
//            System.setProperty("webdriver.edge.driver", "src//test//resources//msedgedriver.exe");
//            driver = new EdgeDriver();
//        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.valtech.co.uk");
    }

    @Test
    public void partners() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu();
        homePage.selectPartnersItem();
        PartnersPage partnersPage = new PartnersPage(driver);
        assertEquals(partnersPage.checkPage(), "Partners");
        //partnersPage.clickOnOurPartnersButton();
        partnersPage.printPartners();
    }

    @Test
    public void offices() {
        HomePage homePage = new HomePage(driver);
        homePage.openMenu();
        homePage.selectOfficesItem();
        OfficesPage officesPage = new OfficesPage(driver);
        assertEquals(officesPage.checkPage(), "Offices");
        officesPage.clickOnUnitedKingdom();
        officesPage.printUKOffices();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}