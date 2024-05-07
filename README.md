

Mobile Testing & Test Automation - Final Assinment.

Rajitha Mihisru 

ICITB-CMTA-17



1. Identify and come up with 5 different Android element locators of the “Swag Labs” application (A sample E-Commerce mobile application).

 ID: - driver.findElement(By.id("00000000-0000-000e-ffff-ffff0000002e"))

 XPath: - driver.findElement(By.xpath("//android.widget.EditText[@content-desc="test-Password"]"))

 Class Name: - driver.findElement(By.className("android.widget.EditText"))

 Accessibility ID: - driver.findElementByAccessibilityId("test-Password")



2. Write 4 negative test cases for the “Swag Labs” application.


● Empty Username Login:

Test Case: Login with Empty username.

Expected Result: User should not be able to login and should receive an error message username is required.


● Empty Password Login:

Test Case: Login with empty password.

Expected Result: An error message should be displayed indicating that the password is required.



● Invalid Credential Login:

Test Case: Login with incorrect username and password.

Expected Result: An error message should be displayed error message indicating Username and Password do not match any user in this service.


● Empty Zip Code in Checkout Form:

Test Case: Enter invalid First name and zip code with the empty last name in the checkout form fields.

Expected Result: An error message should be displayed indicating that the Last Name is required.



3. Write 4 happy path test cases for the “Swag Labs” application.



● Successful Login with Valid Credentials:

Test Case: Enter a valid username and password, and login to the application.

Expected Result: The user should be logged in successfully and directed to the home page.


● Add Product to Cart:

Test Case: Add Item to the cart.

Expected Result: selected Item should be added to the cart successfully.


● Proceed to Checkout:

Test Case: After adding a product to the cart, proceed to the checkout process.

Expected Result: The user should be able to proceed through the checkout process without any errors after adding the product to the cart.


● Logout:

Test Case: Perform the logout action from the application.

Expected Result: The user should be successfully logged out from the application.
