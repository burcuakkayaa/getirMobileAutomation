package stepDefinitions;

import factory.ThreadLocalDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.MainScreen;

public class MainScreenSteps extends BaseSteps {


    @Given("user should pass onboarding screens")
    public void user_should_pass_onboarding_screens() {
        mainScreen.passOnBoardingScreen();

    }
    @Given("user checks if home page exists or not")
    public void user_checks_if_home_page_exists_or_not() {
        mainScreen.checkMainScreenIsPresent();
    }

    @When("user opens the menu in the left")
    public void user_opens_the_menu_in_the_left() {
        mainScreen.clickLeftMenu();

    }
}
