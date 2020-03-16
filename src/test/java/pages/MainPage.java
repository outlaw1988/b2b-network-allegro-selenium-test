package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    @FindBy(css = "button[data-role=close-and-accept-consent]")
    private WebElement closeConsentEl;

    @FindBy(css = "input[data-role=search-input]")
    private WebElement searchingBoxEl;

    @FindBy(css = "button[data-role=search-button]")
    private WebElement searchButtonEl;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeConsent() {
        if (closeConsentEl.isDisplayed()) closeConsentEl.click();
    }

    public void enterPhraseToSearchingBoxAndConfirm(String phrase) {
        searchingBoxEl.sendKeys(phrase);
        searchButtonEl.click();
    }

}
