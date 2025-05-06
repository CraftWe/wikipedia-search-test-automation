import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.WikipediaHomePage;



public class WikipediaSearchTest {

    /**
     * @param args
     */
    public static void main(String[] args) throws TimeoutException {
        // System path to the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "[Local URL to Web Driver]");

        // Create a new WebDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            searchForSelenium(driver);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    /**
     * @param driver
     */
    public static void searchForSelenium(WebDriver driver) {

        driver.get("https://www.wikipedia.org/");

        WikipediaHomePage homePage = new WikipediaHomePage(driver);

        // Explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));

        // Enter search term
        homePage.getSearchBox().sendKeys("Selenium");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        homePage.getSearchButton().click();

        // Verification
        String title = driver.getTitle();
        if (title.contains("Selenium")) {
            System.out.println("Search term found in title: " + title);
        } else {
            System.out.println("Search term not found in title.");
        }
    }
}