package org.stepDefinition;

import org.textcontext.LoginPage;

import io.cucumber.java.en.Given;


public class LogInStepDef {
	@Given("User should enter the login details using {string} and {string}")
	public void user_should_enter_the_login_details_using_and(String username, String password) {
	    LoginPage p= new LoginPage();
	    p.Login(username, password);
	}
	@Given("User should click the login button")
	public void user_should_click_the_login_button() {
		 LoginPage p= new LoginPage();
		 p.loginClick();
	}
	
	

}
