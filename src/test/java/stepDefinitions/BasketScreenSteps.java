package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import screens.BasketScreen;

public class BasketScreenSteps extends  BaseSteps {



    @When("user deletes products from basket")
    public void user_deletes_products_from_basket() {
            basketScreen.removeProducts();
    }

    @Then("user check total price is {string}")
    public void user_check_total_price_is(String total) {
        Assert.assertEquals(total,basketScreen.getPrice());
    }

}
