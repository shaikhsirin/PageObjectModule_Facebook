package com.TestCases;

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
public class HomePageTest extends BaseClass {
    LoginPage loginpage;
    HomePage homepage;
    ProfilePage profilepage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void SetUp() throws InterruptedException {
        initialization();
        loginpage = new LoginPage();
        homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1, description = "check the profile page text")
    @Severity(SeverityLevel.NORMAL)
    @Description("check the text ")
    @Story("check the expected text is equal to actual text or not ")
    public void checkProfileTextTest() {
        log.info("checkProfileTextTest Method Runing...");
        String text = homepage.checkProfileText();
        Assert.assertEquals(text, "Sirin Shaikh");
    }

    @Test(priority = 2, description = "go to the profile page")
    @Severity(SeverityLevel.NORMAL)
    @Description("click the profile page module clickable or not")
    @Story("After click the profile module it's go to the profile page")
    public void clickOnProfileTest() {
        log.info("clickOnProfileTest Method Runing...");
        profilepage = homepage.clickOnProfile();
    }

    @Test(priority = 3, description = "check the Find friends page text")
    @Severity(SeverityLevel.NORMAL)
    @Description("check the text")
    @Story("check the expected text is equal to actual text or not")
    public void FindFriendstextTest() {
        log.info("FindFriendstextTest Method Runing...");
        String text = homepage.findFriendsText();
        Assert.assertEquals(text, "Find Friends");
    }

    @Test(priority = 4, description = "go to the Find friends page")
    @Severity(SeverityLevel.NORMAL)
    @Description("click the Find friends page module clickable or not")
    @Story("After click the Find friends module it's go to the Find friends page")
    public void FindFriendsVisibleTextTest() {
        log.info("FindFriendsVisibleTextTest Method Runing...");
        homepage.clickOnFindFriends();
    }

    @Test(priority = 5, description = "create the story")
    @Severity(SeverityLevel.NORMAL)
    @Description("create the new story")
    @Story("create the new story in faceboook")
    public void createStoryTest() {
        log.info("createStoryTest Method Runing...");
        homepage.createNewStory();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}