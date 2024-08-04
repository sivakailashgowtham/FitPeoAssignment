package org.example.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject {


    @FindBy(xpath = "//div[contains(text(),'Revenue Calculator')]")
    public static WebElement RevenueCalculator;
}
