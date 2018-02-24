package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import java.lang.*;
import java.io.*;

public class ContactAgileTrailblazerStep {

    public static WebDriver driver;

    @Given("^Navigate to AgileTrailblzer page$")
    public void navigateToAgileTrailblzerPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "src/test/Browser/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://mock.agiletrailblazers.com/contact.html");
    }

    @And("^Validate the form has the specified fields$")
    public void validateTheFormHasTheSpecifiedFields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("mobile")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("office")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("subject")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("message")).isDisplayed());
    }

    @And("^Close the AgileTrailblazer page$")
    public void closeTheAgileTrailblazerPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }

    @And("^Validate Name required field$")
    public void validateNameRequiredField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("email")).sendKeys("test1@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("14587895745");
        driver.findElement(By.id("office")).sendKeys("3954754545");
        Select subject = new Select(driver.findElement(By.id("subject")));
        subject.selectByVisibleText("Agile");
        driver.findElement(By.id("message")).sendKeys("Message Test");
        driver.findElement(By.id("submit")).click();
        String nameWarning = driver.findElement(By.id("nameAlert")).getText();
        Assert.assertTrue(nameWarning.contains("Please enter your name"));
    }

    @And("^Validate Email address required field$")
    public void validateEmailAddressRequiredField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).sendKeys("USER2");
        driver.findElement(By.id("mobile")).sendKeys("14587895745");
        driver.findElement(By.id("office")).sendKeys("3954754545");
        Select subject = new Select(driver.findElement(By.id("subject")));
        subject.selectByVisibleText("Agile");
        driver.findElement(By.id("message")).sendKeys("Message Test");
        driver.findElement(By.id("submit")).click();
        String emailWarning = driver.findElement(By.id("emailAlert")).getText();
        Assert.assertTrue(emailWarning.contains("Please enter your email"));
    }

    @And("^Validate Message field$")
    public void validateSubjectField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).sendKeys("USER2");
        driver.findElement(By.id("email")).sendKeys("test1@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("14587895745");
        driver.findElement(By.id("office")).sendKeys("3954754545");
        Select subject = new Select(driver.findElement(By.id("subject")));
        subject.selectByVisibleText("Agile");
        driver.findElement(By.id("submit")).click();
        String messageWarning = driver.findElement(By.id("messageAlert")).getText();
        Assert.assertTrue(messageWarning.contains("Please enter a message"));
    }

    @And("^Validate Mobile Phone as optional field$")
    public void validateMobilePhoneAsOptionalField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).sendKeys("USER5");
        driver.findElement(By.id("email")).sendKeys("test1@gmail.com");
        driver.findElement(By.id("office")).sendKeys("3954754545");
        Select subject = new Select(driver.findElement(By.id("subject")));
        subject.selectByVisibleText("Agile");
        driver.findElement(By.id("message")).sendKeys("Message Test");
        driver.findElement(By.id("submit")).click();
        String successMessage = driver.findElement(By.id("success-message")).getText();
        Assert.assertEquals(successMessage, "Your message was sent successfully. Thanks.");
    }

    @And("^Validate Office Phone as optional field$")
    public void validateOfficePhoneAsOptionalField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).sendKeys("USER5");
        driver.findElement(By.id("email")).sendKeys("test1@gmail.com");
        driver.findElement(By.id("mobile")).sendKeys("3954754545");
        Select subject = new Select(driver.findElement(By.id("subject")));
        subject.selectByVisibleText("Agile");
        driver.findElement(By.id("message")).sendKeys("Message Test");
        driver.findElement(By.id("submit")).click();
        String successMessage = driver.findElement(By.id("success-message")).getText();
        Assert.assertEquals(successMessage, "Your message was sent successfully. Thanks.");
    }

    @And("^Verify the Search results$")
    public void verifyTheSearchResults() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        driver.findElement(By.id("search-nav")).click();
        driver.findElement(By.id("s")).sendKeys("admin");
        driver.findElement(By.id("submit-button")).click();
        String searchTitle = driver.findElement(By.id("search-title")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(searchTitle, "Search Results for: admin");
    }
}
