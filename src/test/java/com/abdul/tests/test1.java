package com.abdul.tests;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Automatically sets up the ChromeDriver binary
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void openGooglePage() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title should contain 'Google'");
    }
    
    @Test
    public void openYouTubePage() {
        driver.get("https://www.youtube.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("YouTube"), "Title should contain 'YouTube'");
    }
    
    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
