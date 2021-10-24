Feature:Category Pages Feature

  Background:
    Given user should pass onboarding screens
    And user checks if home page exists or not


    @emulator
    Scenario: Case I (delete products on basket page)
      When user changes category to "Water"
      And user open 1. product detail
      And user adds this product to basket
      And user goes to basket and control added product and price
      And user deletes products from basket
      Then user check total price is "$0.00"

    @realDevice
    Scenario: Case II (check amount of between category and category detail page)
      When user opens the menu in the left
      And user go to category to "Baby Care"
      And user open 3. product detail
      Then user checks price of the product statically
      When user goes back to category page
      Then user should see page existence





