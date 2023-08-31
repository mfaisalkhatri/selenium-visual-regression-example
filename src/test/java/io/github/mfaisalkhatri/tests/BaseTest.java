package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.drivers.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected DriverManager driverManager;

    @BeforeTest(alwaysRun = true)
    public void testSetup() {
        this.driverManager = new DriverManager();
        this.driverManager.createChromeDriverInCloud();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        this.driverManager.quitDriver();
    }

}
