package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.HomePageObject;
import org.example.pageObject.RevenueCalculatorPageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FitPeoAssign {
    WebDriver driver;

    @Given("User navigate to fitPeo homePage")
    public void user_navigate_to_fit_peo_home_page() {
        String chromeDriverPath = System.getProperty("user.dir") + "\\Driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://fitpeo.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }
    @When("user click revenue calculator page")
    public void user_click_revenue_calculator_page() {
        PageFactory.initElements(driver, HomePageObject.class);
        PageFactory.initElements(driver, RevenueCalculatorPageObject.class);
        HomePageObject.RevenueCalculator.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", RevenueCalculatorPageObject.ScrollBar);

    }
    @When("user select values in revenue calculator")
    public void user_select_values_in_revenue_calculator() {

        int offset=93;
        Actions actions = new Actions(driver);
        actions.clickAndHold(RevenueCalculatorPageObject.ScrollBar);
        actions.moveByOffset(offset,0);
        actions.release();
        actions.perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", RevenueCalculatorPageObject.textField);
        actions.click(RevenueCalculatorPageObject.textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys("560").perform();

        String sliderBarValue=(String) ((JavascriptExecutor)driver).executeScript("return arguments[0].getAttribute(arguments[1]);", RevenueCalculatorPageObject.ScrollBar,"value");
         int slideValue=Integer.parseInt(sliderBarValue);
        Assert.assertEquals("sliderBar value is wrong", 560, slideValue);


    }
    @When("user selecting cpt codes")
    public void user_selecting_cpt_codes() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", RevenueCalculatorPageObject.Checkbox_99091);
        RevenueCalculatorPageObject.Checkbox_99091.click();
        RevenueCalculatorPageObject.Checkbox_99453.click();
        RevenueCalculatorPageObject.Checkbox_99454.click();
        RevenueCalculatorPageObject.Checkbox_99474.click();

    }
    @Then("user verify the header with selected amount")
    public void user_verify_the_header_with_selected_amount() {

        String amount=RevenueCalculatorPageObject.ReimbursementAmount.getText();
        String expectedAmount="$75600";
        Assert.assertEquals("Same amount",amount,expectedAmount);

    }
}
