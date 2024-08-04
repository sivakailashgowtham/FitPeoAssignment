package org.example.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RevenueCalculatorPageObject {


    @FindBy(xpath = "//input[@type='range']")
    public static WebElement ScrollBar;

    @FindBy(xpath = "//input[@type='number']")
    public static WebElement textField;

    @FindBy(xpath = "//p[text()='CPT-99091']/..//input[@type='checkbox']")
    public static WebElement Checkbox_99091;

    @FindBy(xpath = "//p[text()='CPT-99454']/..//input[@type='checkbox']")
    public static WebElement Checkbox_99454;

    @FindBy(xpath = "//p[text()='CPT-99474']/..//input[@type='checkbox']")
    public static WebElement Checkbox_99474;

    @FindBy(xpath = "//p[text()='CPT-99453']/..//input[@type='checkbox']")
    public static WebElement Checkbox_99453;

@FindBy(xpath = "//p[text()='Total Recurring Reimbursement for all Patients Per Month:']//p")
    public static WebElement ReimbursementAmount;



}
