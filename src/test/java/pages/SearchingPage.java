package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchingPage {

    private WebDriver driver;

    public SearchingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, SearchingPage.class);
    }

}
