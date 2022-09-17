package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.hightest.HightestHomePage;
import pages.yopmail.YopMailHomePage;

public abstract class BaseTestsDesktop {
    public WebDriver driver;
    protected String urlHightestHome = "https://hightest.nc/";
    protected String urlYopMailHome = "https://yopmail.com/fr/";
    protected String urlYopMailBox = "https://yopmail.com/fr/wm";
    protected HightestHomePage hightestHomePage;
    protected YopMailHomePage yopMailHomePage;
    protected Dimension dimension = new Dimension(1920, 1080);
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","external-resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);

        driver.get(urlYopMailHome);
        yopMailHomePage = new YopMailHomePage(driver);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(urlHightestHome);
        hightestHomePage = new HightestHomePage(driver);

    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
