package com.browserstack.stepdefs.demoTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.io.File;


public class DemoTest {
    String userName;
    String accessKey;
    RemoteWebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        userName = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : "";
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : "";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("userName", userName);
        bstackOptions.put("accessKey", accessKey);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:platformVersion", "12.0");
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("bstack:options", bstackOptions);
        bstackOptions.putIfAbsent("source", "cucumber-java:appium-sample-main:v1.0");
        capabilities.setCapability("bstack:options", bstackOptions);
        driver = new AndroidDriver<>(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

    @After
    public void tearDown(){
        System.out.println("quitting driver");
        driver.quit();
    }

    @Given("I try to search using Wikipedia App")
    public void I_try_to_search_wikipedia_app() throws Throwable {
        WebElement searchElement = (WebElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
    }


    @Then("I search with keyword BrowserStack")
    public void I_search_with_keyword_browserstack() throws InterruptedException {
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
    }

    @Then("The search results should be listed")
    public void search_results_should_be_listed() {
        List<WebElement> allProductsName = driver.findElements(MobileBy.className("android.widget.TextView"));
        Assert.assertFalse(allProductsName.isEmpty());
    }


    @When("I start test on the Local Sample App")
    public void I_start_test_on_the_local_sample_app() {
        WebElement searchElement = (WebElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.example.android.basicnetworking:id/test_action")));
        searchElement.click();
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.className("android.widget.TextView")));
    }

    @Then("I should see '(.+)'")
    public void I_should_see(String localString) throws Exception {
        WebElement testElement = null;
        List<WebElement> allTextViewElements = driver.findElements(MobileBy.className("android.widget.TextView"));
        Thread.sleep(10);
        for (WebElement textElement : allTextViewElements) {
            if (textElement.getText().contains("The active connection is")) {
                testElement = textElement;
            }
        }

        if (testElement == null) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "screenshot.png"));
            System.out.println("Screenshot stored at " + System.getProperty("user.dir") + "screenshot.png");
            throw new Error("Cannot find the needed TextView element from app");
        }
        String matchedString = testElement.getText();
        System.out.println(matchedString);
        Assert.assertTrue(matchedString.contains("The active connection is wifi"));
        Assert.assertTrue(matchedString.contains(localString));
    }

}
