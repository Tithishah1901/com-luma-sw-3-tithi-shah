package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Write down the following test in the ‘MenTest’
 * class
 * 1. userShouldAddProductSuccessFullyTo
 * ShoppinCart()
 * * Mouse Hover on the ‘Men’ Menu
 * * Mouse Hover on the ‘Bottoms’
 * * Click on the ‘Pants’
 * * Mouse Hover on the product name
 * ‘Cronus Yoga Pant’ and click on the size
 * 32.
 * * Mouse Hover on the product name
 * ‘Cronus Yoga Pant’ and click on the
 * Color Black.
 * * Mouse Hover on the product name
 * ‘Cronus Yoga Pant’ and click on the
 * ‘Add To Cart’ Button.
 * * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * * Click on the ‘shopping cart’ Link into
 * message
 * * Verify the text ‘Shopping Cart.’
 * * Verify the product name ‘Cronus Yoga Pant’
 * * Verify the product size ‘32’
 * * Verify the product color ‘Black
 */
public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    // set up web browser

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void  userShouldAddProductSuccessFullyToShoppingCart(){

        //mouser hover on a men menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"));

        // mouse hover on a Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

        // click on Pants
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        // Mouse hover on product name
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));

        // click on size 32
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        // click on color black
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        // click on add to cart
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));

        // verify to add item in to cart successfully
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        Assert.assertEquals("Product not added in cart",expectedText,getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));

        // click on the shopping cart link on message
        clickOnElement(By.linkText("shopping cart"));

        // verify all cart messages

        Assert.assertEquals("Shopping cart text not matched",
                "Shopping Cart", getTextFromElement(By.xpath("//span[@class='base']")));

        Assert.assertEquals("Product name not matched",
                "Cronus Yoga Pant", getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")));

        Assert.assertEquals("size text not matched",
                "32", getTextFromElement(By.xpath("(//dd[contains(text(),'32')])[1]")));

        Assert.assertEquals("color text not matched",
                "Black", getTextFromElement(By.xpath("(//dd[contains(text(),'Black')])[1]")));

    }

    @After
    public void tearDown(){
        //closeBrowser();
    }
}


