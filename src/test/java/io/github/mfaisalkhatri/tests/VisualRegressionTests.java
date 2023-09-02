package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.pages.ProductPage;
import org.testng.annotations.Test;

public class VisualRegressionTests extends BaseTest {


    @Test
    public void testECommerceVisualRegressionScenarioOne() {
        this.driverManager.getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=20");
        final var productPage = new ProductPage(this.driverManager.getDriver());
        productPage.checkVisual();
    }

    @Test
    public void testECommerceVisualRegressionScenarioTwo() {
        this.driverManager.getDriver().get("https://ecommerce-playground.lambdatest.io/");
        final var productPage = new ProductPage(this.driverManager.getDriver());
        productPage.checkVisual();
    }
}
