package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("start-maximized");
//            options.addArguments("--incognito");
//            options.addArguments("disable-popup-blocking");
//
//            driver = new ChromeDriver(options);
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//            driver.get("https://www.saucedemo.com");
//            driver.manage().window().maximize();
//            driver.findElement(By.id("user-name")).sendKeys("standard_user");
//            driver.findElement(By.id("password")).sendKeys("secret_sauce");
//            driver.findElement(By.id("login-button")).click();
//
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @BeforeEach
    void goTo() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


//       Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.saucedemo.com/inventory.html"),"Page not Found");
//}




    @AfterAll
    static void close () {
        driver.quit();
    }

    public static WebDriver getDriver () {
        return driver;
    }
}



