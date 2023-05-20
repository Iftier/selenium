package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");
        WebDriver driver;


        // setup chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();


        //Open a chromedriver browser
        driver =new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        // navigate to the URL https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

        // enter standard user in the username field
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");


        // enter password
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        //click login
        driver.findElement(By.cssSelector("#login-button")).click();


        // verify checkout icon is visible
        boolean checkoutIconDisplayed =driver.findElement(By.cssSelector("#shopping_cart_container > a")).isDisplayed();
        if (checkoutIconDisplayed){
            System.out.println("ICON IS DISPLAYED");
        }else {
            System.out.println("ICON IS NOT DISPLAYED");
        }

        // logout
        // EXPLICIT WAIT
        // wait for hamburger manu to be clickable until 5000 millisecond
        // it will keep cheacking
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#react-burger-menu-btn"))));


        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();


        // fluent wait
        FluentWait wait1 = new FluentWait(driver);
        wait1.withTimeout(Duration.ofMillis(10000));
        wait1.pollingEvery(Duration.ofMillis(2000));
        wait1.ignoring(ElementNotInteractableException.class);

        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();



        //wait 5 seconds
        Thread.sleep(5000);

        // CLOSE THE browser
        driver.quit();

    }
}