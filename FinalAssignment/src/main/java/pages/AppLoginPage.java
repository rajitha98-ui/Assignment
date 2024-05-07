package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AppLoginPage {

    By usernameField = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    By passwordField = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    By invalidErrorMessage = By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]");
    By emptyUsernameErrorMessage = By.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    By emptyPasswordErrorMessage = By.xpath("//android.widget.TextView[@text=\"Password is required\"]");

    AndroidDriver driver;
    public SwagLoginPage(AndroidDriver driver) {
        this.driver = driver;

    }

    public void Login(String UserName, String Password) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(usernameField).sendKeys(UserName);
        driver.findElement(passwordField).sendKeys(Password);
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
    }



    public String EmptyErrorMsg(){
        return driver.findElement(invalidErrorMessage).getText();
    }




    public String EmptyUnameError(){
        return driver.findElement(emptyUsernameErrorMessage).getText();
    }

    public String EmptyPasswordError(){
        return driver.findElement(emptyPasswordErrorMessage).getText();
    }
}
