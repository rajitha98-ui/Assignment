package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AppLogOutPage {
    AndroidDriver driver;
    By logOut = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]");

    public AppLogOutPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void ClickLogout(){
        driver.findElement(logOut);
    }

}
