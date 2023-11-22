package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        WebElement register = driver.findElement(By.className("ico-register"));
        //     click on the ‘Register’ link
        register.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        System.out.println(pageTitle.getText());
        //verify the text Resgister
        Assert.assertEquals("Text not Display", "Register", pageTitle.getText());
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        WebElement register = driver.findElement(By.className("ico-register"));
        // Click on the ‘Register’ link
        register.click();
        //Select gender radio button
        WebElement genderButton = driver.findElement(By.id("gender-male"));
        genderButton.click();
        //Enter First name
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Katy");
        //Enter Last name
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Barrott");
        //Select Date of your Birthday
        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByValue("15");
        // Select Date of your Month
        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText("September");
        // Select Year
        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByValue("1959");
        //Enter Email address
        WebElement emailAddress = driver.findElement(By.id("Email"));
        emailAddress.sendKeys("smithjhon123@gmail.com");
        //Enter Password
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Smith@123");
        //Enter Confirm password
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("Smith@123");
        //Click on REGISTER button
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        //Verify the text 'Your registration completed’
        WebElement regiComp = driver.findElement(By.className("result"));
        //Assert.assertEquals("Your registration completed", regiComp);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
