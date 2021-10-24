package stepDefinitions;

import io.cucumber.java.en.When;
import myHooks.BaseHooks;
import org.testng.Assert;

import screens.BasketScreen;
import screens.ProductDetailsScreen;

public class ProductDetailsScreenSteps extends BaseSteps {


    private String priceOnDetailsPage;
    private String priceOnBasketPage;



    @When("user adds this product to basket")
    public void user_adds_this_product_to_basket() {
        productDetailsScreen.addToBasket();

    }

    @When("user goes to basket and control added product and price")
    public void user_goes_to_basket_and_control_added_product_and_price() {
        priceOnDetailsPage = productDetailsScreen.getPrice();
        productDetailsScreen.goToBasketScreen();
        priceOnBasketPage = basketScreen.getPrice();

        Assert.assertEquals(priceOnBasketPage,priceOnDetailsPage,"Prices can not mismatch..");
    }

    @When("user checks price of the product statically")
    public void user_checks_price_of_the_product_statically() {
        priceOnDetailsPage = productDetailsScreen.getPrice();
        System.out.println("Price is : " + priceOnDetailsPage);

    }

    @When("user goes back to category page")
    public void user_goes_back_to_category_page() {
       productDetailsScreen.goBackToCategoryPage();
    }
}
