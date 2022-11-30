package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;

import com.facebook.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class ProfilePage extends BaseClass {

    //Object Repository
    @FindBy(xpath="//span[text()='Edit profile']")
    WebElement EditProfile;

    @FindBy(xpath="//span[text()='Edit']")
    WebElement Edit;

    @FindBy(xpath="//textarea[@placeholder='Describe who you are']")
    WebElement Describe;

    @FindBy(xpath="//span[text()='Save']")
    WebElement Save;

    //Inizilation
    public ProfilePage() {
        PageFactory.initElements(driver,this);
    }

    //Action
    @Step("Edit the bio details")
    public void clickEditButtion() throws AWTException {
        EditProfile.click();
        Robot robot = new Robot();
        robot.mouseWheel(1);
        Edit.click();
        Describe.sendKeys("Sirin....");
        Save.click();
    }

}