package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.hightest.HightestHomePage;

public abstract class BaseTestsDesktop {
    public WebDriver driver;
    protected HightestHomePage hightestHomePage;
    protected Dimension dimension = new Dimension(1920, 1080);
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","external-resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        driver.get("https://hightest.nc/");
        hightestHomePage = new HightestHomePage(driver);
    }

    /*@BeforeClass
    public void tearDown(){
        driver.quit();
    }*/
}
