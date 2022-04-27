package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseURL = "https://mobile.x-cart.com";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //click
        clickOnElement(By.xpath("(//span[contains(text(),'Shipping')])[2]"));
        //this is from requirement
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //click
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));
        //this is from requirement
        String expectedMessage = "New arrivals";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void
    verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[5]/a/span"));
        String expectedMessage = "Coming soon";
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"page-title\"]"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){

        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[6]/a/span"));
        String expectedMessage = "Contact us";
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"page-title\"]"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
