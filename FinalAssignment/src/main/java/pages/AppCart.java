package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppCart {
    AndroidDriver driver;

    By checkoutElement = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");
    By totalPriceElement = By.xpath("//android.widget.TextView[@text=\"Total: $9.39\"]");
    By finishCheckoutButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]");
    By lastnameerror = By.xpath("//android.widget.TextView[@text=\"Last Name is required\"]");
    By firstNameField = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    By HamIcon = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
    By zipCodeField = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    By lastNameField = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    By cartItemElement = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]");
    By itemNameText = By.xpath("//android.widget.TextView[@text=\"Sauce Labs Bike Light\"]");
    By continueButtonElement = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");
    By thankYouMessageText = By.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");


    public AppCart(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isItemDisplayedInCart() {
        return driver.findElement(cartItemElement).isDisplayed();
    }





    public void CheckoutProgess(String FirstName, String LastName, String ZipCode) throws InterruptedException {
        if (isItemDisplayedInCart()){
            driver.findElement(checkoutElement).click();


            Thread.sleep(2000);
            driver.findElement(firstNameField).sendKeys(FirstName);
            driver.findElement(lastNameField).sendKeys(LastName);
            driver.findElement(zipCodeField).sendKeys(ZipCode);
            driver.findElement(continueButtonElement).click();
            Thread.sleep(2000);

            scrollToElement(driver, finishCheckoutButton);
            Thread.sleep(2000);
            driver.findElement(finishCheckoutButton).click();

            Thread.sleep(2000);
            driver.findElement(thankYouMessageText).getText();
        }
        else
            System.out.println("Empty Cart");
    }

    public void WithoutLastname(String FirstName, String LastName, String ZipCode) throws InterruptedException {
            Thread.sleep(3000);
            driver.findElement(checkOut).click();
            Thread.sleep(2000);
            driver.findElement(firstname).sendKeys(FirstName);
            driver.findElement(lastName).sendKeys(LastName);
            driver.findElement(zipCode).sendKeys(ZipCode);
            driver.findElement(continueButton).click();
            Thread.sleep(2000);
        }

    public void ClickHamburgerIcon() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(HamIcon).click();
        Thread.sleep(2000);
    }


    public String CheckItemName(){
        return driver.findElement(itemNameText).getText();
    }


    public String WithoutLastnametxt(){
        return driver.findElement(lastnameerror).getText();
    }

    public void scrollToElement(AndroidDriver driver, By locator) {
        while (!isElementPresent(driver, locator)) {
            scrollDown(driver);
        }
    }

    public boolean isElementPresent(AndroidDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }



    public static void scrollDown(AndroidDriver driver) {////////////////////
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        int startScroll = (int) (screenHeight * 0.8);
        int endScroll = (int) (screenHeight * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(screenWidth / 2, startScroll))
                .waitAction()
                .moveTo(PointOption.point(screenWidth / 2, endScroll))
                .release()
                .perform();
    }
}


