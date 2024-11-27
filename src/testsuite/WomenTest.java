package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Write down the following test in the WomenTestclass
 * 1. verifyTheSortByProductNameFilter()
 * * Mouse Hover on the ‘Women’ Menu
 * * Mouse Hover on the ‘Tops’
 * * Click on the ‘Jackets’
 * * Select Sort By filter “Product Name”
 * * Verify the product name displayed in
 * alphabetical order
 * 2. verifyTheSortByPriceFilter()
 * * Mouse Hover on the ‘Women’ Menu
 * * Mouse Hover on the ‘Tops’
 * * Click on the ‘Jackets’
 * * Select Sort By filter “Price”
 * * Verify the product price displayed in
 * Low to High
 */
public class WomenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    // set up web browser

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {

        //mouser hover on women menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        // mouse hover on tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // click on jackets
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']"));

        selectByVisibleTextDropdown(By.id("sorter"), "Product Name");

        // get elements of products name
        List<String> productNames = getWebElements(By.xpath("//a[@class = 'product-item-link']")).stream()
                .map(WebElement::getText)
                .toList();

        // verify  product name displayed in alphabetical order
        Assert.assertTrue("Products are not sorted alphabetically by name",
                isSortedAlphabetically(productNames.toArray(new String[0])));
    }

    @Test
    public void verifyTheSortByPriceFilter() {

        //mouser hover on women menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        // mouse hover on tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // click on jackets
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']"));

        selectByVisibleTextDropdown(By.id("sorter"), "Price");

        // Verify product prices are sorted in ascending order
        List<Double> productPrices = getWebElements(By.cssSelector(".price-wrapper.price")).stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "").replace(",", "")))
                .collect(Collectors.toList());

        Assert.assertTrue("Products are not sorted by price in ascending order!",
                isSortedAscending(productPrices));

    }


    @After
    public void tearDown() {
        //closeBrowser();
    }
}
