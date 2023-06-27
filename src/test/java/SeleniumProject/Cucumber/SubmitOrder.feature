Feature: Purchase the order from ecommerce test.

	//KIND OF BEFORE METHOD IN TESTnG
	Background:
	Given I landed on ecommerce page


  @tag2
  Scenario Outline: Positive test of submitting the order
    Given User Login with username <name> and password <password>
    When I add a product <productname> to cart
    And checkout <productname> and submit the order
    Then I verify the "THANKYOU FOR THE ORDER." message in screen.

    Examples: 
      | name  					 		 | password  | productname |
      | rakesh9692@gmail.com | Rakesh123 | ZARA COAT 3 |
       
