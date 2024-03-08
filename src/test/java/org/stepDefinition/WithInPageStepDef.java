package org.stepDefinition;

import org.textcontext.WithInPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithInPageStepDef {
	
	
	
	@When("User should select the {string} in the dropdown button")
	public void user_should_select_the_in_the_dropdown_button(String reversals) {
		WithInPage a= new WithInPage();
	    a.reversalsCheck();
	}
	@Then("User should check the Grand Total is the sum of values of each location of each month")
	public void user_should_check_the_grand_total_is_the_sum_of_values_of_each_location_of_each_month() {
		WithInPage a= new WithInPage();
	    a.DataVerification();
	}
}
