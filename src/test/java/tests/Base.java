package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Base {

    protected static WebDriver driver;
    private final String CHROMEDRIVER_PATH = "src/test/java/drivers/chromedriver";
    private final String MAIN_URL = "https://www.allegro.pl";
    private final int TIMEOUT = 10;

    @BeforeSuite
    public void beforeSuite() {
        initializeDriver();
        enterMainUrl();
    }

    private void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void enterMainUrl() {
        driver.get(MAIN_URL);
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
    }

}
