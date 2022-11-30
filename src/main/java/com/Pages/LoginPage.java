package com.Pages;

import com.facebook.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class LoginPage extends BaseClass {
    // Object Repository
    @FindBy(id = "email")
    WebElement userName;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    WebElement login;

    @FindBy(linkText = "Forgotten password?")
    WebElement forgotpass;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Get the title from login page")
    public String validateLoginpageTitle() {
        return driver.getTitle();
    }

    @Step("user login the facebook")
    public HomePage Login(String un, String pass) throws InterruptedException {
        userName.sendKeys(un);
        password.sendKeys(pass);
        login.click();
        Thread.sleep(5000);
        return new HomePage();
    }

    @Step("check the forgott password option")
    public void forgottPassword() {
        forgotpass.click();
    }

    @Step("check the multiple user login")
    public HomePage mulitipleUserLogin(String username, String passWord) {
        userName.sendKeys(username);
        password.sendKeys(passWord);
        login.click();
        return new HomePage();
    }

}