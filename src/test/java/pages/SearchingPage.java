package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class SearchingPage {

    private WebDriver driver;

    private List<WebElement> searchingItemsEls;

    private final String colorXpath = "//h3[@data-slot='Kolor']/following-sibling::div//span[contains(text(), '%s')]";
    private final String searchingItemsCss = "div[data-box-name='items container'] article";

    public SearchingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chooseColor(String color) {
        String xpath = String.format(colorXpath, color.toLowerCase());
        WebElement colorEl = driver.findElement(By.xpath(xpath));
        colorEl.click();
    }

    public int getNumberOfFoundItems() {
        searchingItemsEls = driver.findElements(By.cssSelector(searchingItemsCss));
        return searchingItemsEls.size();
    }

    public BigDecimal getHighestPriceAndPrint() {
        BigDecimal currentHighestAmount = new BigDecimal(-1);

        for (WebElement item : searchingItemsEls) {
            WebElement amountEl = item.findElement(By.cssSelector("[class='_9c44d_1zemI'],[class='fee8042']"));
            String amountStr = amountEl.getText().replaceAll(",", "\\.")
                    .replaceAll("[^(0-9.)]", "");
            BigDecimal amount = new BigDecimal(amountStr).setScale(2, RoundingMode.CEILING);
            if (amount.compareTo(currentHighestAmount) > 0) currentHighestAmount = amount;
        }

        if (currentHighestAmount.compareTo(new BigDecimal(0)) < 0) return null;

        return currentHighestAmount;
    }

    public BigDecimal addExtraPercent(BigDecimal amount, int extraPercent) {
        if (amount == null) return null;
        BigDecimal multiplier = BigDecimal.ONE
        .add(
            BigDecimal.valueOf(extraPercent).divide(BigDecimal.valueOf(100.0))
            .setScale(2, RoundingMode.CEILING)
        );

        return amount.multiply(multiplier).setScale(2, RoundingMode.CEILING);
    }

}
