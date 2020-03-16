package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class Base {

    protected static WebDriver driver;
    private final String CHROMEDRIVER_PATH = "";
    private final String MAIN_URL = "https://www.allegro.pl";

    @BeforeSuite
    public void beforeSuite() {
        initializeDriver();
        enterMainUrl();
    }

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
    }

    private void enterMainUrl() {
        driver.get(MAIN_URL);
    }

}
