package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find login element and click on it
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        WebElement welcomeMessage = driver.findElement(By.className("page-title"));
        // Actual Message of welcome page
        String actualWelcomeMessage = welcomeMessage.getText();
// ExpectedMessage
        String expectedMessage = "Welcome, Please Sign In!";
//validate Actual and Expected Message
        Assert.assertEquals("Wrong Welcome Message", expectedMessage, actualWelcomeMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
//Find username  locator by id provide value by sendskeys
        WebElement userName = driver.findElement(By.id("Email"));
        userName.sendKeys("monalisa@gmail.com");
        // Find password locator by name, provide value by sendkeys
        WebElement userPassWord = driver.findElement(By.name("Password"));
        userPassWord.sendKeys("monalisa123?");
        //
        WebElement userLogIn = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        userLogIn.click();

        WebElement userLogOut = driver.findElement(By.className("ico-logout"));

        Assert.assertEquals("text not display", "Log out", userLogOut.getText());
    }

    @Test
    public void verifyTheErrorMessage() {
        // Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
//Find username  locator by id provide value by sendskeys
        WebElement userName = driver.findElement(By.id("Email"));
        userName.sendKeys("prime890@yahoo.com");
        // Find password locator by name, provide value by sendkeys
        WebElement userPassWord = driver.findElement(By.name("Password"));
        userPassWord.sendKeys("Prime012");
        //
        WebElement userLogIn = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        userLogIn.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
        Assert.assertEquals("text not display", expectedMessage, errorMessage.getText());

    }

}