# Wikipedia Search Test

This Java project, consisting of `WikipediaHomePage.java` and `WikipediaSearchTest.java`, uses Selenium WebDriver to automate a search on the English Wikipedia website.  It is designed to be used in a Maven project.

## Project Description

The project performs the following actions:

1.  Opens the Wikipedia homepage in a Chrome browser.
2.  Locates the search bar using a Page Object (`WikipediaHomePage`).
3.  Enters "Selenium" into the search bar.
4.  Clicks the search button.
5.  Verifies that the page title contains the search term "Selenium".
6.  Prints a message indicating whether the search term was found in the title.
7.  Closes the browser.

The project demonstrates a basic test case for verifying search functionality on a website, and also the use of the Page Object pattern.  It uses Selenium's explicit wait to handle asynchronous page loading.

## Files

* `WikipediaHomePage.java`: Defines the Page Object for the Wikipedia home page.  It encapsulates the locators and methods for interacting with the search bar and button.
* `WikipediaSearchTest.java`: Contains the main test logic. It uses the `WikipediaHomePage` Page Object to perform the search and verify the results.

## Features

* Demonstrates how to set up and use Selenium WebDriver with ChromeDriver in a Maven project.
* Implements the Page Object pattern for better code organization and maintainability.
* Uses explicit waits (`WebDriverWait`) to handle dynamic content.
* Verifies the presence of a search term in the page title.
* Handles `NoSuchElementException` and `TimeoutException`.
* Properly closes the browser and quits the WebDriver instance.

## How to Use

1.  **Prerequisites:**
    * Java Development Kit (JDK) installed.
    * Maven installed.
    * Selenium WebDriver Java dependency managed by Maven.
    * ChromeDriver installed and the system property `webdriver.chrome.driver` set to the correct path.

2.  **Project Setup (Maven):**
    * This project is designed to be used with Maven.  Ensure that your `pom.xml` file includes the necessary Selenium WebDriver dependency.  A basic `pom.xml` would look like this:

    ```xml
    <project>
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.example</groupId>
      <artifactId>wikipedia-search-test</artifactId>
      <version>1.0-SNAPSHOT</version>
      <dependencies>
        <dependency>
          <groupId>org.seleniumhq.selenium</groupId>
          <artifactId>selenium-java</artifactId>
          <version>4.18.1</version> </dependency>
        </dependencies>
      <build>
        <plugins>
          <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
              <source>1.8</source> <target>1.8</target>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </project>
    ```

3.  **Set ChromeDriver Path:**
    * In `WikipediaSearchTest.java`, the line `System.setProperty("webdriver.chrome.driver", "[Local URL to Web Driver]");` sets the path to the ChromeDriver.  **You must change this path** to the location of your ChromeDriver executable.

4.  **Compile and Run the Test:**
    * Open a terminal or command prompt.
    * Navigate to the project directory (where the `pom.xml` file is located).
    * Compile the project: `mvn compile`
    * Run the test: `mvn test`  (This will execute the `main` method in `WikipediaSearchTest.java` in this case, since no specific test framework is used)

    The program will open a Chrome browser, perform the search on Wikipedia, verify the results, and print the verification message.

## Code Explanation

###   `WikipediaHomePage.java`

* **`private WebDriver driver;`**:  Stores the WebDriver instance.
* `public WikipediaHomePage(WebDriver driver)`:  Constructor that initializes the `driver`.
* `public WebElement getSearchBox()`:  Returns the search input element using `By.id("searchInput")`.
* `public WebElement getSearchButton()`:  Returns the search button element using `By.xpath("//button[@type='submit']")`.

###   `WikipediaSearchTest.java`

* `System.setProperty("webdriver.chrome.driver", "[Local URL to Web Driver]");`:  Configures the system property to specify the location of the ChromeDriver executable.  **Important:** This path needs to be updated to match your local ChromeDriver path.
* `WebDriver driver = new ChromeDriver();`:  Initializes a new ChromeDriver instance.
* `driver.get("https://www.wikipedia.org/");`:  Opens the Wikipedia homepage.
* `WikipediaHomePage homePage = new WikipediaHomePage(driver);`:  Creates an instance of the `WikipediaHomePage` Page Object.
* `WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));`:  Creates a `WebDriverWait` instance with a timeout of 10 seconds.
* `wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));`:  Waits until the search bar is visible.
* `homePage.getSearchBox().sendKeys("Selenium");`:  Enters "Selenium" into the search bar using the Page Object.
* `wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));`: Waits until the search button is clickable.
* `homePage.getSearchButton().click();`:  Clicks the search button using the Page Object.
* `String title = driver.getTitle();`:  Gets the title of the page.
* `title.contains("Selenium")`:  Checks if the title contains "Selenium".
* `driver.quit();`: Closes the browser and terminates the WebDriver session in the `finally` block.
