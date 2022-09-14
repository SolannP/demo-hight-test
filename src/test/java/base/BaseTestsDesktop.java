package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.hightest.HomePage;

public class BaseTestsDesktop {
    public WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","external-resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);
        driver.get("https://hightest.nc/");
        homePage = new HomePage(driver);
    }

    /*@BeforeClass
    public void tearDown(){
        driver.quit();
    }*/
}
