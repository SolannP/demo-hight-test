package pages.yopmail.emailbox;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObjectModel;

import java.time.Duration;

public class YopMailEmailBox extends PageObjectModel {
    protected String url;
    protected String incomingMailFrame ="ifinbox";
    protected String mailContentFrame ="ifmail";
    protected By refreshMailButton = By.id("refresh");
    private By centerCookiesCloseButton = By.id("accept");
    protected By mailSelected;
    public YopMailEmailBox(WebDriver driver) {
        super(driver);
        url = driver.getCurrentUrl();
    }

    /**
     * Click on accept cookies button
     * @return the same page for further interaction
     */
    public YopMailEmailBox acceptCookies(){
        try{
            driver.findElement(centerCookiesCloseButton).click();
        }
        catch (NoSuchElementException exception){}
        return this;
    }

    /**
     * Click on refresh incoming email button
     * @return the same page for further interaction
     */
    public YopMailEmailBox clickOnRefreshButton(){
        moveoToTab(url);
        driver.findElement(refreshMailButton).click();
        return this;
    }

    /**
     * Email located in left column
     * @param index starting at 1
     * @return the same page for further interaction
     */
    public YopMailEmailBox selectIncomingEmailBasedOnIndex(int index){
        makeInteractableIncomingMailFrame();
        driver.findElement(getMailToSelect(index)).click();
        return this;
    }

    /**
     * Refresh page until mail come in the left column
     * @param index starting at 1
     * @param second to wait for the email
     * @return the same page for further interaction
     */
    public YopMailEmailBox waitIncomingEmailBasedOnIndex(int index,int second){
        makeInteractableIncomingMailFrame();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        for (int i=0; i < second; i++){
            try{
                clickOnRefreshButton();
                makeInteractableIncomingMailFrame();
                wait.until(ExpectedConditions.elementToBeClickable(getMailToSelect(index)));
            }
            //catch (NoSuchElementException exception) {}
            catch (TimeoutException exception) {}
        }
        return this;
    }

    /**
     * Check a html tag having the provided sentence. Cannot search for ponctuation nor white space, only text
     * @param textsToSearch
     * @return the whole text present on matching html tag page
     */
    public String getSectionInMailContaining(String textsToSearch){
        makeInteractableMailContentFrame();
        String xpath = "//*";
        var sentenceSplitByWord = textsToSearch.replaceAll("[^\\w\\s]"," ").replaceAll("\\s+","|").split("\\|");
        for(String word : sentenceSplitByWord){
            xpath += "[contains(text(),'"+ word +"')]";
        }
        return driver.findElement(By.xpath(xpath)).getText();
    }

    private By getMailToSelect(int index) {
        return mailSelected = By.xpath("//div[@class='mctn']/div["+ (index +1) +"]//button");
    }
    private void makeInteractableIncomingMailFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(incomingMailFrame);
    }
    private void makeInteractableMailContentFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(mailContentFrame);
    }
}
