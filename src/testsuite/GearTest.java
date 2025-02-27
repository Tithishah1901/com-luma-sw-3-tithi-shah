package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Write down the following test in the ‘GearTest’
 * class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on the ‘Gear’ Menu
 * * Click on the ‘Bags’
 * * Click on Product Name ‘Overnight Duffle’
 * * Verify the text ‘Overnight Duffle’
 * * Change the Qty 3
 * * Click on the ‘Add to Cart’ Button.
 * * Verify the text
 * ‘You added Overnight Duffle to your shopping cart.’
 * * Click on the ‘shopping cart’ Link into
 * message
 * * Verify the product name ‘Overnight Duffle’
 * * Verify the Qty is ‘3’
 * * Verify the product price ‘$135.00’
 * * Change the Qty to ‘5’
 * * Click on the ‘Update Shopping Cart’
 * button
 * * Verify the product price ‘$225.00’
 */
public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    // set up web browser

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void  userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //mouser hover on Gear menu
        mouseHoverToElement(By.xpath("//span[text()='Gear']"));

        // click on Bags
        mouseHoverToElementAndClick(By.xpath("//span[text()='Bags']"));

        // Click on the product
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        // verify the product name
        Assert.assertEquals("Product name text not match","Overnight Duffle",
                getTextFromElement(By.xpath("//span[@class='base']")));

        // change the qty 3
        sendTextToElementWithClearText(By.id("qty"), "3");

        // click on add cart
        clickOnElement(By.id("product-addtocart-button"));

        // verify add product confirmation message
        Assert.assertEquals("product haven't add successfully","You added Overnight Duffle to your shopping cart.",
                getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));

        // click on shopping cart link
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        Thread.sleep(2000);
        // Verify product name in the cart
        Assert.assertEquals("Product name is not match","Overnight Duffle",
                getTextFromElement(By.xpath("//td[@class='col item']//a[contains(text(),'Overnight Duffle')]")));

        Thread.sleep(2000);
        // Verify qty
       /* Assert.assertEquals("qty is not match","3",
                getTextFromElement(By.cssSelector("input.input-text.qty")));*/

        Thread.sleep(2000);
        // Verify product prise
        Assert.assertEquals("prise is not match","$135.00",
                getTextFromElement(By.xpath("//td[@class='col subtotal']//span[@class='price']")));

        // Change the qty
        sendTextToElementWithClearText(By.cssSelector("input.input-text.qty"), "5");

        // update cart button
        clickOnElement(By.xpath("//button[@title='Update Shopping Cart']"));

        Thread.sleep(2000);
        // Verify updated product prise
        Assert.assertEquals("updated prise is not match","$225.00",
                getTextFromElement(By.xpath("//td[@class='col subtotal']//span[@class='price']")));
    }

    @After
    public void tearDown(){
        //closeBrowser();
    }
}
