//        **********************XPATHS_ASSIGNMENT**********************

package org.example;
//Package Imports
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


//  Main Class
public class Main {
    public static void main(String[] args) {

//      Change web driver according to your browser. Here Chrome browser has been used.
        WebDriver driver = new ChromeDriver();

        try {

//      Opening Amazon.in
            driver.get("https://www.amazon.in/");

//      Maximize window size
            driver.manage().window().maximize();

//      Searching amazon.in for the entered user input("books")
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
                    .sendKeys("books" + Keys.ENTER);

/*     Storing amazon.in "results for" string to validate whether the
       search result is in accordance with the user search input("books")*/

            //Axes Descendant used here
            String searchResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']//descendant::span[@class='a-color-state a-text-bold']")).getText();

//      Storing first search result's title
            String firstResultTitle = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).getText();

//      Accessing the next page button("SVG element")
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[local-name()='svg' and @aria-hidden]/*[local-name()='path'])[3]"));

//          Moving to the given SVG element and clicking on it and moving to next page
        //  Scrolling the page down to the svg element
            JavascriptExecutor scrollAction = (JavascriptExecutor) driver;
            scrollAction.executeScript("arguments[0].scrollIntoView()", nextPageButton);
            Actions action = new Actions(driver);
            action.moveToElement(nextPageButton).
                    click().build().perform();

//      Accessing disappearing element
            WebElement signInHover = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
            action.moveToElement(signInHover).build().perform();
//      Disappearing Create a new wish list link
            WebElement createWishList = driver.findElement(By.xpath("//*[text()='Create a Wish List']"));
            createWishList.click();

//      Closing driver window
            driver.close();

//      Validating whether the results shown by Amazon.in match the user input("books")
            if (searchResult.contains("books")) {
                System.out.println("Since top left corner in amazon search results shows n results for \"books\", hence search results are validated.");

                System.out.println("Search results successfully validated!");
//          Printing first search result's title
                System.out.println("\nTitle of the book that appears first in results: \n"+firstResultTitle+"\n");
            } else {
                System.out.println("Incorrect results");
            }
            System.out.println("Thank You!");


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}


//        **********************THANK YOU**********************

/*CREDITS:
    Bhuvan Kohli
    bhuvan.kohli@geminisolutions.com
*/
