package com.example.selenium;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefinitions
{
    private WebDriver webDriver;

    @When("I go to {string}")
    public void iGoTo(String url) throws URISyntaxException
    {
        webDriver = SeleniumUtil.getWebDriver();
        webDriver.get(url);
    }

    @And("I type {string}")
    public void iType(String searchQuery) {
        webDriver.findElement( By.id( "L2AGLb" ) ).click();
        webDriver.findElement( By.name("q")).sendKeys(searchQuery);
    }

    @And("I hit Enter")
    public void iHitEnter() {
        webDriver.findElement(By.name("q")).submit();
    }

    @Then("I should be shown the results from my query")
    public void iShouldBeShownTheResultsFromMyQuery() {
        try {
            webDriver.findElement(By.xpath("//*[contains(text(), 'Vídeos')]"));
        } catch ( NoSuchElementException e) {
            throw new AssertionError("Result Page not displayed");
        }
        webDriver.quit();
    }
}
