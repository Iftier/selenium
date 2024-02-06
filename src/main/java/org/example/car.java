package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class car {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        driver =new ChromeDriver();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));


        // Open https://www.roimotors.com/
        driver.get("https://www.roimotors.com/");

        driver.manage().window().maximize();

        // Search for "2024 Audi A3" using the search icon in the top right corner.
        WebElement searchIcon = driver.findElement(By.cssSelector("#template-site-search1-app-root > button > i"));
        searchIcon.click();

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("2024 Audi A3");
        searchInput.submit();

        // Print the URL of the search result page.
        System.out.println("Search Result Page URL: " + driver.getCurrentUrl());

        // Print the number of vehicles returned on the search result page
        List<WebElement> searchResults = driver.findElements(By.className("vehicle-list-item"));
        System.out.println("Number of Vehicles Returned: " + searchResults.size());

        // Sort the result by "Price Low to High"
        WebElement sortDropdown = driver.findElement(By.className("sort-select"));
        sortDropdown.click();
        driver.findElement(By.xpath("//option[contains(text(),'Price Low to High')]")).click();


    }

}
