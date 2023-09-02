package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.text.MessageFormat;

public class ProductPage {

    private WebDriver driver;
    public ProductPage(final WebDriver driver) {
        this.driver= driver;
    }
    private static final String SCREEN_NAME        = "Product-Page";

    public void checkVisual() {
        ((JavascriptExecutor) this.driver).executeScript (MessageFormat.format ("smartui.takeScreenshot={0}", SCREEN_NAME));
    }
}
