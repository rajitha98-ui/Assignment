package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AppHomePage {

    AndroidDriver driver;
    By Cart  = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    By addToCartItem1 = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]");
    By Removecartitem = By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
    By cartItemIndicator = By.xpath("//android.widget.TextView[@text=\"1\"]");

    public SwagHomePage(AndroidDriver driver) {
        this.driver = driver;
    }



    public void AddToCart() throws InterruptedException {
        driver.findElement(addToCartItem1).click();
        Thread.sleep(2000);
    }

    public void AddToCart() throws InterruptedException {
        driver.findElement(Removecartitem).click();
        Thread.sleep(2000);
    }


    public boolean IsteminCartDisplayed() {
        return driver.findElement(cartItemIndicator).isDisplayed();
    }

    public void ClickCartIcon() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(Cart).click();
        Thread.sleep(3000);
    }
}
