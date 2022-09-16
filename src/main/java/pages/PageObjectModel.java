package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public abstract class PageObjectModel {
    protected WebDriver driver;
    public PageObjectModel(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Move to an existing tab uisng Web driver
     * @param expectedUrl a string of the complete URL Structure (protocols + domain + path + and so on)
     * @return true if the movement on the expected tab have been performed, false otherwise
     */
    protected boolean moveoToTab(String expectedUrl) {
        if(driver.getCurrentUrl() != expectedUrl){
            boolean tabExist = false;
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            for( String openTab : tabs2){
                driver.switchTo().window(openTab);
                if(driver.getCurrentUrl().equals(expectedUrl)) {
                    tabExist = true;
                    break;
                }
            }
            return tabExist;
        }
        else return true;
    }

    /**
     * Move the port view in a way that element appears on the clickable page
     * @param element as By object
     * @return true if the movement on the expected element have been performed, false otherwise
     */
    protected boolean moveToElement(By element) {
        return moveToElement(driver.findElement(element));
    }

    /**
     * Move the port view in a way that element appears on the clickable page
     * @param element as WebElement object
     * @return true if the movement on the expected element have been performed, false otherwise
     */
    protected boolean moveToElement(WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        }
        catch (NoSuchElementException error){
            return false;
        }
        return true;
    }

    /**
     * Scroll to the port view in a way that element appears on the clickable page
     * @param element as By locator
     * @return true if the movement on the expected element have been performed, false otherwise
     */
    protected boolean scrollToElement(By element){
        return scrollToElement(driver.findElement(element));
    }
    /**
     * Scroll to the port view in a way that element appears on the clickable page
     * @param element as WebElement locator
     * @return true if the movement on the expected element have been performed, false otherwise
     */
    protected boolean scrollToElement(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
        return (Boolean)jsExecutor.executeScript(
                "var elem = arguments[0],                 " +
                        "  box = elem.getBoundingClientRect(),    " +
                        "  cx = box.left + box.width / 2,         " +
                        "  cy = box.top + box.height / 2,         " +
                        "  e = document.elementFromPoint(cx, cy); " +
                        "for (; e; e = e.parentElement) {         " +
                        "  if (e === elem)                        " +
                        "    return true;                         " +
                        "}                                        " +
                        "return false;                            "
                , element);
    }
}
