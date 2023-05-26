package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GURU99 extends Base {
    @When("I select quantity")
    public void iSelectQuantity() {
        WebElement dropdownquantity = driver.findElement(By.cssSelector("#three > div > form > div > div.\\31 u.\\31 2u\\$\\(small\\).select-wrapper > select"));
        Select select = new Select(dropdownquantity);
        select.selectByIndex(1);
    }

    @And("I click on BUY NOW option")
    public void iClickOnBUYNOWOption() {
        driver.findElement(By.cssSelector("#three > div > form > div > div.\\33 u.\\31 2u\\$\\(small\\) > ul > li > input")).click();
    }

    @Then("I need to fill payment process form")
    public void iNeedToFillPaymentProcessForm() {
        driver.findElement(By.cssSelector("#card_nmuber")).sendKeys("0123456987896542");

        WebElement dropdownmonth = driver.findElement(By.cssSelector("#month"));
        Select select1 = new Select(dropdownmonth);
        select1.selectByIndex(4);

        WebElement dropdownyear = driver.findElement(By.cssSelector("#year"));
        Select select2 = new Select(dropdownyear);
        select2.selectByIndex(7);

        driver.findElement(By.cssSelector("#cvv_code")).sendKeys("123");
    }

    @When("I click PAY option")
    public void iClickPAYOption() {
        driver.findElement(By.cssSelector("#three > div > form > div.\\39 u.\\31 2u\\$\\(xsmall\\) > div > ul > li > input")).click();
    }
}
