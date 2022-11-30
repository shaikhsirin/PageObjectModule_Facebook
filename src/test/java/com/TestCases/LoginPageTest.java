package com.TestCases;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Utility.UtilityClass;
import com.facebook.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseClass {

    LoginPage loginpage;
    HomePage homepage;
    UtilityClass utility;
    public static String SheetName = "Sheet1";

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginpage = new LoginPage();
    }

    @Test(priority = 1,description="get the title from the login")
    @Severity(SeverityLevel.NORMAL)
    @Description("to check the title excepted or not")
    @Story("to check the excepted title match with the actual title or not")
    public void loginPageTitleTest() {
        log.info("LoginPageTitleTest Method Runing...");
        String title = loginpage.validateLoginpageTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
    }

    @Test(priority = 2,description="user login")
    @Severity(SeverityLevel.NORMAL)
    @Description("user login the facebook")
    @Story("user give the valid data to login the facebook")
    public void loginTest() throws InterruptedException {
        log.info("LoginTest Method Runing...");
        homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 3,description="check the forgot password")
    @Severity(SeverityLevel.NORMAL)
    @Description("click the forgot password option")
    @Story("check the forgot password go to the forgot password page or not")
    public void forgottPasswordTest() {
        log.info("forgottPasswordTest Method Runing...");
        loginpage.forgottPassword();
    }

    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = utility.getTestData(SheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData", priority = 4,description="check the multiple user login")
    @Severity(SeverityLevel.NORMAL)
    @Description("check the multiple user login")
    @Story("check the multiple user login working fine or not")
    public void mulitipleUserLoginTest(String username, String passWord) {
        log.info("mulitipleUserLoginTest Method Runing...");
        loginpage.mulitipleUserLogin(username, passWord);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}