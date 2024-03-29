package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLogin extends Base{

    
    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        // enter standard user in the username field
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");


        // enter password
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");



    }

    @And("I click on logon button")
    public void iClickOnLogonButton() {
        //click login
        driver.findElement(By.cssSelector("#login-button")).click();

    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
         String urlAfterLogin=driver.getCurrentUrl();
         assert urlAfterLogin.contains("/inventory.html");

         

    }

}
