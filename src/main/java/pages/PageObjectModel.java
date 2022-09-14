package pages;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectModel {
    protected WebDriver driver;
    public PageObjectModel(WebDriver driver){
        this.driver = driver;
    }
}
