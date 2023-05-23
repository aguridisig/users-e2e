package com.example.selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstScriptTest
{

    @Test
    void eightComponents()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.get( "https://www.selenium.dev/selenium/web/web-form.html" );

        String title = driver.getTitle();
        assertEquals( "Web form", title );

        driver.manage().timeouts().implicitlyWait( Duration.ofMillis( 500 ) );

        WebElement textBox = driver.findElement( By.name( "my-text" ) );
        WebElement submitButton = driver.findElement( By.cssSelector( "button" ) );

        textBox.sendKeys( "Selenium" );
        submitButton.click();

        WebElement message = driver.findElement( By.id( "message" ) );
        String value = message.getText();
        assertEquals( "Received!", value );

        driver.quit();
    }
}
