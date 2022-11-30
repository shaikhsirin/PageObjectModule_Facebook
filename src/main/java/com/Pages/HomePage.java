package com.Pages;

import com.facebook.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;


public class HomePage extends BaseClass {

// Object Repository
@FindBy(xpath = "//span[text()='Sirin Shaikh']")
	WebElement profile;

@FindBy(xpath = "//span[text()='Find Friends']")
	WebElement friends;

@FindBy(xpath = "//a[@aria-label='Home']")
	WebElement home;

@FindBy(xpath = "//div[@class='bp9cbjyn is6700om qavdm89g gsh9l1b6 lwukve8w jpyiy761 j83agx80 k7cz35w2 taijpn5t bsnbvmp4']")
	WebElement createStory;

@FindBy(xpath = "//div[text()='Create a Text Story']")
	WebElement textStory;

@FindBy(xpath = "//textarea[@dir='ltr']")
	WebElement text;

@FindBy(xpath = "//span[text()='Share to Story']")
	WebElement Share;

public HomePage() {
        PageFactory.initElements(driver, this);
        }


@Step("check the profile text")
public String checkProfileText() {

    return profile.getText();
        }

@Step("check the profile module go to the profile page or not")
public ProfilePage clickOnProfile() {
    profile.click();
        return new ProfilePage();
        }

@Step("check the find friends text")
public String findFriendsText() {
        return friends.getText();
        }

@Step("check the find friend module go the find friend page or not")
public void clickOnFindFriends() {
        friends.click();
        }

@Step("create the new story in facebook")
public void createNewStory() {
        home.click();
        createStory.click();
        textStory.click();
        text.sendKeys("Sirin.....");
        Share.click();
        }

}