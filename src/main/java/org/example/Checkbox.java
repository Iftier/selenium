package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Checkbox {

    public static void main(String[] args) throws InterruptedException {

        //Initiate selenium WebDriver
        WebDriver driver;


        // Setup Chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        // Open a Chrome browser
        driver = new ChromeDriver();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        // Go to https://demoqa.com/checkbox

        driver.get(" https://demoqa.com/checkbox");


        //wait 1 seconds
        Thread.sleep(1000);

        //click  ( + ) icon box
        driver.findElement(By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all > svg")).click();

        //wait 2 seconds
        Thread.sleep(2000);

        // click private icon
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg")).click();


        // click public icon
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg")).click();

        boolean publicprivate =driver.findElement(By.cssSelector("#result > span:nth-child(1)")).isDisplayed();
        if (publicprivate){
            System.out.println("public and private are mention");
        }else {
            System.out.println("public and private are not mention");
        }

        //wait 1 seconds
        Thread.sleep(1000);

        // CLOSE THE browser
        driver.quit();



    }
}