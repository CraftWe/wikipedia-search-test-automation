package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaHomePage {
    private WebDriver driver;

    public WikipediaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @return
     */
    public WebElement getSearchBox() {
        return driver.findElement(By.id("searchInput"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
}