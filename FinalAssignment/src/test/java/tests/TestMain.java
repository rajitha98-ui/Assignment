package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SwagCartPage;
import pages.SwagHomePage;
import pages.SwagLoginPage;
import pages.SwagNavigatorPage;

import java.io.File;
import java.net.URL;

public class TestMain {
    static AndroidDriver driver;
    static AppLoginPage appLoginPage;
    static AppHomePage appHomePage;
    static AppCart appcCart;
    static AppLogOutPage appLogOutPage;

    @BeforeClass
    public static void Setup(){
        try {
            File appDir = new File("C:\\Users\\rajit\\OneDrive\\Desktop\\Rajitha\\Assignment_Rajitha\\FinalAssignment\\Apps");
            File app = new File(appDir, "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion","9.0");
            capabilities.setCapability("appium:deviceName", "emulator-5554");
            capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("app", app.getAbsolutePath());

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

            appHomePage = new AppHomePage(driver);
            appLoginPage = new AppLoginPage(driver);
            appCart = new AppCart(driver);
            AppLogOutPage = new appLogOutPage(driver);/////////////////////////////////////

        } catch (Exception e) {
            System.out.println("Cause is: "+e.getCause());
            System.out.println("Message is: "+e.getMessage());
            e.printStackTrace();
        }
    }




    //.01.Empty Username Login
    @Test
    public void TestCase01() throws InterruptedException {
        swagLoginPage.Login("","secret_sauce");
        Assert.assertEquals(appLoginPage.EmptyUnameError(),"Username is required");
        System.out.println("Test Case 01 - Login Failed Due to Empty Username");
    }

    //02.Empty Username Login
    @Test
    public void TestCase02() throws InterruptedException {
        swagLoginPage.Login("standard_user","");
        Assert.assertEquals(appLoginPage.EmptyPasswordError(),"Password is required");
        System.out.println("Test Case 02 - Login Failed Due to Empty Password");
    }

    //03.Invalid Credential Login
    public void TestCase03() throws InterruptedException {
        swagLoginPage.Login("Tom","Cf20258");
        Assert.assertEquals(appLoginPage.EmptyErrorMsg(),"Username and password do not match any user in this service.");
        System.out.println("Test Case 03 - Login Failed Due to Invalid Credentials");
    }

    //04.valid Credential Login
    @Test
    public void TestCase04() throws InterruptedException {
        appLoginPage.Login("standard_user","secret_sauce");
        System.out.println("Test Case 04 - Login succeed");
    }




   //Add Items to Cart
    @Test
    public void TestCase05() throws InterruptedException {
        appHomePage.AddToCart();
        Assert.assertTrue(appHomePage.IsteminCartDisplayed());
        appHomePage.ClickCartIcon();
        Assert.assertEquals(appcCart.CheckItemName(),"Sauce Labs Bike Light");
        System.out.println("Test Case 05 - Item Added to the cart ");
    }


    //With out last name checkout///
    @Test
    public void TestCase06() throws InterruptedException {
        appcCart.WithoutLastname("Tom","","2564");
        Assert.assertEquals(appcCart.WithoutLastnametxt(),"Last Name is required");
        System.out.println("Test Case 06 - Checkout Failed due to empty last name.");
    }

    //Complete the checkout
    @Test
    public void TestCase07() throws InterruptedException {
        appHomePage.ClickCartIcon();
        appcCart.CheckoutProgess("Lil","Roy","5698");
        System.out.println("Test Case 07 - Checkout Complete.");
    }

    //perform Logout
    @Test
    public void TestCase08() throws InterruptedException {
        appcCart.ClickHamburgerIcon();
        appLogOutPage.ClickLogout();
        System.out.println("Test Case 08 - Logout succeed.");
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
