package org.example;

import org.openqa.selenium.By;

public class Locators {
    public static final By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    public static final By searchResult = By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']//descendant::span[@class='a-color-state a-text-bold']");
    public static final By firstResultTitle = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
    public static final By nextPageButton = By.xpath("(//*[local-name()='svg' and @aria-hidden]/*[local-name()='path'])[3]");

    public static final By signInHover = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    public static final By createWishList = By.xpath("//*[text()='Create a Wish List']");

}
