package shopping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {

    String baseURL = "https://mobile.x-cart.com";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
        public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException
        {

            //1.1 Mouse hover on the “Hot deals” link
            mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

            //1.2 Mouse hover on the “Bestsellers”  link and click
            mouseHoverOnly(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
            mouseHoverClick(By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));

            //1.3 Verify the text “Bestsellers”
            verifyText("Bestsellers", "Bestsellers", "Text not Verified");
            getTextFromElement(By.xpath("//h1[@id='page-title']"));

            //1.4 Mouse hover on “Sort By” and select “Name A-Z”
            mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
            mouseHoverClick(By.xpath("//a[@data-sort-by='translations.name' and @data-sort-order='asc']\n"));
            verifyText("Name A - Z", "Name A - Z", "Not in alphabetical order");
            getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]"));

            //1.5 Click on “Add to cart” button of the product “Ollie - The App ControlledRobot"
            clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));

            //1.6 Verify the message “Product has been added to your cart” display in  green bar
            verifyText("Product has been added to your cart","Product has been added to your cart","Not Match");
            getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));

            //1.7 Click on X sign to close the message
            clickOnElement(By.xpath("//a[@class='close']"));

            //1.8 Click on “Your cart” icon and Click on “View cart” button
            clickOnElement(By.xpath("//div[@class='minicart-items-number']"));
            clickOnElement(By.xpath("//a[@class='regular-button cart']"));
            //  clickOnElement(By.xpath("//div[@title='Your cart']"));

            //1.9 Verify the text “Your shopping cart - 1 item”
            verifyText("Your shopping cart - 1 items","Your shopping cart - 1 items","Not Match");
            getTextFromElement(By.xpath("//h1[@class='title']"));

            //1.10 Verify the Subtotal $299.00
            verifyText("$299.00","$299.00","Not Match");
            getTextFromElement(By.xpath("//a[@class='regular-main-button checkout']"));

            //1.11 Verify the total $311.03
            verifyText("$309.73","$309.73","Not Match");
            //getTextFromElement(By.xpath("//li[@class='total']"));
            getTextFromElement(By.xpath("//span[contains(text(),'309.73')]"));

            // 1.12 Click on “Go to checkout” button
            clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button checkout']"));

            //1.13 Verify the text “Log in to your account”
            verifyText("Log in to your account","Log in to your account","Not Match");
            getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]"));

            //1.14 Enter Email address
            sendTextToElement(By.xpath("//input[@id='email']"),"prime123@gmail.com");

            //1.15 Click on “Continue” Button
            clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));

            //1.16 Verify the text “Secure Checkout”
            verifyText("Secure Checkout","Secure Checkout","Not Match");
            getTextFromElement(By.xpath("//h1[@class='title']"));

            //1.17 Fill all the mandatory fields
            sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"),"kalpesh");//Firstname
            sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"),"Patel");//Lastname
            sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"),"99 The Rutts  ave");//address
            sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"bushey");//city
            sendTextToElement(By.xpath("//select[@id='shippingaddress-country-code']"),"India");//country
            sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"),"Ahmedabad");//state
            sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"),"382485");//90001
            sendTextToElement(By.xpath("//input[@id='email']"),"kaleshpatel2022@gmail.com");//email

            //1.18 the check box “Create an account for later use”
            clickOnElement(By.xpath("//input[@id='create_profile']"));
            //1.19 Enter the password
            sendTextToElement(By.xpath("//input[@id='password']"), "Abc123!");
            //1.20 Select the Delivery Method to “Local Shipping”
            clickOnElement(By.xpath("//input[@id='method128']"));
            //1.21 Select Payment Method “COD”
            clickOnElement(By.xpath("//input[@id='pmethod6']"));
            //1.22 Verify the total $99.00
            verifyText("$311.03","$311.03","Not Match");
            getTextFromElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]"));
            //1.23 Click on “Place Order” Button
            clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));
            //1.24 Verify the text “Thank you for your order”
            verifyText("Thank you for your order","Thank you for your order","Not Match");
            getTextFromElement(By.xpath("//h1[@id='page-title']"));

        }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        //click
        clickOnElement(By.xpath("(//span[contains(text(),'Shipping')])[2]"));
        //this is from requirement
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        //click
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));
        //this is from requirement
        String expectedMessage = "New!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
    }
    @Test
    public void
    verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[5]/a/span"));
        String expectedMessage = "Comming soon";
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"page-title\"]"));

    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){

        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[6]/a/span"));
        String expectedMessage = "Contact us";
        String actualMessage = getTextFromElement(By.xpath("//*[@id=\"page-title\"]"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


