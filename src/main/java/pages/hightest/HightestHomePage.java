package pages.hightest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageObjectModel;
import pages.hightest.toolbox.HightestToolBoxPage;

public class HightestHomePage extends PageObjectModel {

    private By tabToolboxLink = By.xpath("//ul/li/a[@href='https://hightest.nc/toolbox/']|//ul/li/a[@title='Toolbox']");
    private By footerCookiesCloseButton = By.xpath("//a[@id='cookie_action_close_header']");
    private By newsletterCloseButton = By.className("pum-close");
    public HightestHomePage(WebDriver driver) {
        super(driver);
    }
    public HightestToolBoxPage clickOnToolboxTab() {
        driver.findElement(tabToolboxLink).click();
        return new HightestToolBoxPage(driver);
    }
    public HightestHomePage closeNewsLetter(){
        driver.findElement(newsletterCloseButton).click();
        return this;
    }
    public HightestHomePage acceptCookies(){
        driver.findElement(footerCookiesCloseButton).click();
        return this;
    }
}
