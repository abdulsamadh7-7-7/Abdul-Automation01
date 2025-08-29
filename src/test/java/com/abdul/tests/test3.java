package com.abdul.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test3 {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options to prevent crashes
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        
        // Create ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    
    @Test
    public void openGooglePage() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title should contain 'Google'");
        System.out.println("✅ Google test passed! Title: " + title);
    }
    
    @Test
    public void openYouTubePage() {
        driver.get("https://www.youtube.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("YouTube"), "Title should contain 'YouTube'");
        System.out.println("✅ YouTube test passed! Title: " + title);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
