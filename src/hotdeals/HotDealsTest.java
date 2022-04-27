package hotdeals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
        public void verifyThatUserShouldPlaceOrderSuccessfullyForAstroA50HaloEdition() throws InterruptedException
        {
            //1.1 Mouse hover on the “Hot deals” link
            mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
            //1.2 Mouse hover on the “Bestsellers”  link and click
            // mouseHoverOnly(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
            mouseHoverClick(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/h1[1]"));

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
            sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"),"Alpesh");//Firstname
            sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"),"panchal");//Lastname
            sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"),"70 The Rutts ");//address
            sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"Watfofd");//city
            sendTextToElement(By.xpath("//select[@id='shippingaddress-country-code']"),"UK");//country
            sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"),"London");//state
            sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"),"382425");//90001
            sendTextToElement(By.xpath("//input[@id='email']"),"prime123@gmail.com");//email

            //1.18 the check box “Create an account for later use”
            clickOnElement(By.xpath("//input[@id='create_profile']"));
            //1.19 Enter the password
            sendTextToElement(By.xpath("//input[@id='password']"), "xyz321!");
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
        public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
            //1.1 Mouse hover on the “Hot deals” link
            mouseHoverOnly(By.xpath("//div[@id='header-area']//span[@class='primary-title']"));

            //1.2 Mouse hover on the “Bestseller”  link and click
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

            //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
            mouseHoverClick(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[9]/div[1]/div[2]/div[4]/div[1]/button[1]"));
            clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[9]/div[1]/div[2]/div[4]/div[1]/button[1]"));

            //clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
            //clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[9]/div[1]/div[2]/div[4]/div[1]/button[1]"));

            //1.6 Verify the message “Product has been added to your cart” display in  green bar
            verifyText("Product has been added to your cart", "Product has been added to your cart", "Text not Verified");
            getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));

            //1.7 Click on X sign to close the message
            clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[1]/div[1]/div[1]/a[1] "));

            //1.8 Click on “Your cart” icon and Click on “View cart” button
            //  clickOnElement(By.xpath("lc-minicart lc-minicart-horizontal collapsed recently-updated"));
            // clickOnElement(By.xpath("//a[@class='regular-button cart']"));
            //1.8 Click on “Your cart” icon and Click on “View cart” button
            clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));
            clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));

            //1.9 Verify the text “Your shopping cart - 1 item”
            verifyText("Your shopping cart - 1 item","Your shopping cart - 1 item","not Match");
            getTextFromElement(By.xpath("//h1[@id='page-title']"));

            //1.10 Click on “Empty your cart” link
            clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

            //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
            // verifyText("Are you sure you want to clear your cart?","Are you sure you want to clear your cart?","Not Match");
            // getTextFromElement(By.xpath(""));

            //1.12 Click “Ok” on alert
            acceptAlert();

            //1.13 Verify the message “Item(s) deleted from your cart”
            verifyText("Item(s) deleted from your cart","Item(s) deleted from your cart","Not Match");
            getTextFromElement(By.xpath(" //li[contains(text(),'Item(s) deleted from your cart')]\n"));

            //1.15 Verify the text “Your cart is empty”
            verifyText("Your cart is empty","Your cart is empty","Not match");
            getTextFromElement(By.xpath("//h1[@id='page-title']"));
        }

        @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        verifyText("Name A - Z", getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]")), "Error-Message not displayed");
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price Low - High']"));
        verifyText("Price Low - High", getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]")), "Error-Message not displayed");
    }

    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
        verifyText("Rates", getTextFromElement(By.xpath("//span[contains(text(),'Rates')]")), "Error-Message not displayed");
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("(//a[normalize-space()='Name Z - A'])[1]"));
        verifyText("Name Z - A", getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]")), "Error-Message not displayed");
    }

    @Test
    public void verifyBestSellersProductsArrangeHighToLow() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price High - Low']"));
        verifyText("Price High - Low", getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]")), "Error-Message not displayed");
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
        verifyText("Rates", getTextFromElement(By.xpath("//span[contains(text(),'Rates')]")), "Error-Message not displayed");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


