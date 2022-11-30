package com.TestCases;

import java.awt.AWTException;

import com.Pages.HomePage;
import com.Pages.LoginPage;
import com.Pages.ProfilePage;
import com.facebook.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(com.Listener.TestLisner.class)
public class ProfilePageTest extends BaseClass {
    LoginPage loginpage;
    HomePage homepage;
    ProfilePage profilepage;

    public ProfilePageTest() {
        super();
    }

    @BeforeMethod
    public void SetUp() throws InterruptedException {
        initialization();
        loginpage = new LoginPage();
        homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
        homepage.clickOnProfile();
        profilepage = new ProfilePage();
    }

    @Test(priority = 1, description = "Update profile")
    @Severity(SeverityLevel.NORMAL)
    @Description("Update profile")
    @Story("Update the Bio details")
    public void editTheProfileTest() throws AWTException {
        log.info("editTheProfileTest Method Runing...");
        profilepage.clickEditButtion();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}