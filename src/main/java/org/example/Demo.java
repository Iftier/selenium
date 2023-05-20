package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        //Initiate selenium WebDriver
        WebDriver driver;


        // Setup Chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        // Open a Chrome browser
        driver = new ChromeDriver();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        // Go to https://demoqa.com/dynamic-properties
        driver.get(" https://demoqa.com/dynamic-properties");

        // Verify "Color change" button is visible
        boolean coloChangeButtonVisible =driver.findElement(By.cssSelector("#colorChange")).isDisplayed();
        if (coloChangeButtonVisible){
            System.out.println("COLO CHANGE ICON IS DISPLAYED");
        }else {
            System.out.println("ICON IS NOT DISPLAYED");
        }

        // Verify "Will enable 5 seconds" button is disabled
        boolean willEnableButton= driver.findElement(By.cssSelector("#enableAfter")).isDisplayed();
        if (willEnableButton){
            System.out.println("Button is disabled");
        }else {
            System.out.println("Button is enabled");
        }


        // verify "will enable 5 seconds" button is enabled after 5 seconds
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#enableAfter"))));

        // verify "Visible after 5 seconds" button is visible after 5 seconds

        FluentWait wait1 = new FluentWait<>(driver);
        wait1.withTimeout(Duration.ofMillis(6000));
        wait1.pollingEvery(Duration.ofMillis(5000));
        wait1.ignoring(NoSuchElementException.class);


        //wait 5 seconds
        Thread.sleep(5000);

        // CLOSE THE browser
        driver.quit();


    }
}