package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchingPage;

import java.math.BigDecimal;

@Test
public class Searching extends Base {

    private final String SEARCHING_PHRASE = "Iphone 11";
    private final String COLOR = "czarny";
    private final int EXTRA_PERCENT = 23;

    @Test
    public void findHighestPriceOfPhoneAndIncrease() {
        MainPage mainPage = new MainPage(driver);
        mainPage.closeConsent();
        mainPage.enterPhraseToSearchingBoxAndConfirm(SEARCHING_PHRASE);

        SearchingPage searchingPage = new SearchingPage(driver);
        searchingPage.chooseColor(COLOR);
        int numberOfFoundItems = searchingPage.getNumberOfFoundItems();
        printNumberOfFoundItems(numberOfFoundItems);
        if (numberOfFoundItems < 1) return;

        BigDecimal highestPrice = searchingPage.getHighestPriceAndPrint();
        printHighestPrice(highestPrice);

        BigDecimal increasedHighestPrice = searchingPage.addExtraPercent(highestPrice, EXTRA_PERCENT);
        printIncreasedHighestPrice(increasedHighestPrice);
    }

    private void printNumberOfFoundItems(int numberOfFoundItems) {
        if (numberOfFoundItems > 0) System.out.println("Number of found items: " + numberOfFoundItems);
        else System.out.println(String.format("Desired item: %s %s - not found", SEARCHING_PHRASE, COLOR));
    }

    private void printHighestPrice(BigDecimal highestPrice) {
        if (highestPrice != null) System.out.println("The highest price is: " + highestPrice.toString());
        else System.out.println("Highest price not found");
    }

    private void printIncreasedHighestPrice(BigDecimal increasedHighestPrice) {
        if (increasedHighestPrice != null) System.out.println("The increased highest price is: " +
                increasedHighestPrice.toString());
        else System.out.println("Computing increased highest price is not possible");
    }

}
