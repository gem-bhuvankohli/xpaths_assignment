//        **********************XPATHS_ASSIGNMENT**********************

package org.example;
//Package Imports

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonSearchValidation {
    public static void main(String[] args) {

//      Change web driver according to your browser. Here Chrome browser has been used.
        WebDriver driver = new ChromeDriver();

        try {

//      Opening Amazon.in
            driver.get("https://www.amazon.in/");
            LoggerUtils.info("Launching url");

//      Maximize window size
            driver.manage().window().maximize();

//      Searching amazon.in for the entered user input("books")
            driver.findElement(Locators.searchBox).sendKeys("books" + Keys.ENTER);

/*     Storing amazon.in "results for" string to validate whether the
       search result is in accordance with the user search input("books")*/

            //Axes Descendant used here
            String searchResult = driver.findElement(Locators.searchResult).getText();

//      Storing first search result's title
            String firstResultTitle = driver.findElement(Locators.firstResultTitle).getText();

//      Accessing the next page button("SVG element")
            WebElement nextPageButton = driver.findElement(Locators.nextPageButton);

//          Moving to the given SVG element and clicking on it and moving to next page
            //  Scrolling the page down to the svg element
            JavascriptExecutor scrollAction = (JavascriptExecutor) driver;
            scrollAction.executeScript("arguments[0].scrollIntoView()", nextPageButton);
            Actions action = new Actions(driver);
            action.moveToElement(nextPageButton).click().build().perform();

//      Accessing disappearing element
            WebElement signInHover = driver.findElement(Locators.signInHover);
            action.moveToElement(signInHover).build().perform();
//      Disappearing Create a new wish list link
            WebElement createWishList = driver.findElement(Locators.createWishList);
            createWishList.click();

//      Closing driver window
            driver.close();

//      Validating whether the results shown by Amazon.in match the user input("books")
            if (searchResult.contains("books")) {
                LoggerUtils.info("Since top left corner in amazon search results shows n results for \"books\", hence search results are validated.");

                LoggerUtils.info("Search results successfully validated!");
//          Printing first search result's title
                LoggerUtils.info("\nTitle of the book that appears first in results: \n" + firstResultTitle + "\n");
            } else {
                LoggerUtils.error("Incorrect results");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
