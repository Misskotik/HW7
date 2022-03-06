package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceTest extends AbstractTest {

        @Test
        @DisplayName("Add To Cart")
        @Description("Adding item to shopping cart")
        @Severity(SeverityLevel.CRITICAL)
        void addToCartTest() {
            getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.saucedemo.com/cart.html"));
            Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));


//        Actions addItem = new Actions(getDriver());
//        addItem.click(getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")))
//                .click(getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")))
//                .build()
//                .perform();
//
//        Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));
        }


        @Test
        @DisplayName("Remove From Cart")
        @Description("Removing added item from shopping cart")
        @Severity(SeverityLevel.NORMAL)
        void removeTest ()
        {
            getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));
            getDriver().findElement(By.id("remove-sauce-labs-backpack")).click();
            Assertions.assertFalse(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("1"));


        }
        @Test
        @DisplayName("Check Continue Shopping Button")
        @Description("Testing if customer can continue to shopping after he checked the shopping cart ")
        @Severity(SeverityLevel.NORMAL)
        void continueShoppingTest ()
        {
            getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            getDriver().findElement(By.id("remove-sauce-labs-backpack")).click();
            getDriver().findElement(By.id("continue-shopping")).click();
            Assertions.assertTrue(true);

        }
        @Test
        @DisplayName("Check Checkout Button")
        @Description("Testing if Checkout button works")
        @Severity(SeverityLevel.CRITICAL)
        void startCheckoutTest () {
            getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            getDriver().findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            getDriver().findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='shopping_cart_container']/a")).getText().equals("3"));
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            getDriver().findElement(By.id("checkout")).click();
            Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='header_container']/div[2]/span")).getText().equals("CHECKOUT: YOUR INFORMATION"));

        }

        @Test
        @DisplayName("Check Form Filling")
        @Description("Testing if customer can fill in the form with his data")
        @Severity(SeverityLevel.CRITICAL)
        void checkoutFormTest () {
            getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            getDriver().findElement(By.id("checkout")).click();
            getDriver().findElement(By.id("first-name")).sendKeys("Alex");
            getDriver().findElement(By.id("last-name")).sendKeys("Davon");
            getDriver().findElement(By.id("postal-code")).sendKeys("190000");
            getDriver().findElement(By.id("continue")).click();
            Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='header_container']/div[2]/span")).getText().equals("CHECKOUT: OVERVIEW"));

        }

        @Test
        @DisplayName("Check Form Filling")
        @Story("Testing if customer can add items to the cart, fill in his data and complete his order")
        @Severity(SeverityLevel.CRITICAL)
        void finishTest () {
            getDriver().findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            getDriver().findElement(By.xpath(".//div[@id='shopping_cart_container']/a")).click();
            getDriver().findElement(By.id("checkout")).click();
            getDriver().findElement(By.id("first-name")).sendKeys("Alex");
            getDriver().findElement(By.id("last-name")).sendKeys("Davon");
            getDriver().findElement(By.id("postal-code")).sendKeys("190000");
            getDriver().findElement(By.id("continue")).click();
            getDriver().findElement(By.id("finish")).click();
            Assertions.assertTrue(getDriver().findElement (By.xpath(".//div[@id='checkout_complete_container']/h2")).getText().equals("THANK YOU FOR YOUR ORDER"));

        }

    }

