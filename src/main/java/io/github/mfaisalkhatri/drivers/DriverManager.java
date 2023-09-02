package io.github.mfaisalkhatri.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import static java.text.MessageFormat.format;

public class DriverManager {

    protected WebDriver driver;
    private static final String LT_USERNAME = System.getProperty("LT_USERNAME");
    private static final String LT_ACCESS_KEY = System.getProperty("LT_ACCESS_KEY");
    private static final String GRID_URL = "@hub.lambdatest.com/wd/hub";

    public void createChromeDriverInCloud() {
        final ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        final HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", LT_USERNAME);
        ltOptions.put("accessKey", LT_ACCESS_KEY);
        ltOptions.put("resolution", "2560x1440");
        ltOptions.put("video", true);
        ltOptions.put("smartUI.project", "Visual Regression Selenium");
        ltOptions.put("smartUI.baseline", false);
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        final var smartOptions = new HashMap<String, Object> ();
        smartOptions.put ("largeImageThreshold", 1200);
        ltOptions.put ("smartUI.options", smartOptions);
        browserOptions.setCapability("LT:Options", ltOptions);
        try {
            this.driver = new RemoteWebDriver(new URL(format("https://{0}:{1}{2}", LT_USERNAME, LT_ACCESS_KEY, GRID_URL)), browserOptions);
        } catch (final MalformedURLException e) {
            throw new Error("RemoteDriver's URL not set correctly!");
        }
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quitDriver() {
        this.driver.quit();
    }
}
