package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.pages.ProductPage;
import org.testng.annotations.Test;

public class VisualRegressionTests extends BaseTest {


    @Test
    public void testECommerceVisualRegression() {
        this.driverManager.getDriver().get("https://ecommerce-playground.lambdatest.io/index.php");
        final var productPage = new ProductPage(this.driverManager.getDriver());
        productPage.checkVisual();
    }
}
