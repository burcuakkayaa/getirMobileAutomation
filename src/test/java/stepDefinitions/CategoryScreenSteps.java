package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.CategoryScreen;

public class CategoryScreenSteps extends BaseSteps {



    @When("user go to category to {string}")
    public void user_go_to_category_to(String categoryName) {
       categoryScreen.goToCategory(categoryName);
    }

    @Then("user should see page existence")
    public void user_should_see_page_existence() {
        categoryScreen.checkCategoryPage();

    }

    @When("user open {int}. product detail")
    public void userOpenProductDetail(int index) {
        categoryScreen.selectProduct(index);
    }

    @When("user changes category to {string}")
    public void userChangesCategoryTo(String categoryName) {
        categoryScreen.getCategoryScreen(categoryName);
    }
}
