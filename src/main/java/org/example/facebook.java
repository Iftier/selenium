package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class facebook {

    public static void main(String[] args) throws InterruptedException {

        //Initiate selenium WebDriver
        WebDriver driver;


        // Setup Chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        // Open a Chrome browser
        driver = new ChromeDriver();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        // Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/ ");

        // enter Email and password information
        driver.findElement(By.cssSelector("#email")).sendKeys("iftier_hossain@yahoo.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("231485");

        driver.findElement(By.cssSelector("#loginbutton")).click();








        //wait 5 seconds
        Thread.sleep(3000);

        // CLOSE THE browser
        driver.quit();





    }
}