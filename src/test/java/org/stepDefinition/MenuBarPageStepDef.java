package org.stepDefinition;

import org.textcontext.MenuBarPage;

import io.cucumber.java.en.When;

public class MenuBarPageStepDef {
	@When("User should click the 3P Chargebacks")
	public void user_should_click_the_3P_Chargebacks() {
	    MenuBarPage p = new MenuBarPage();
	    p.chargebacks3P();
	}
	@When("User should click the History By Store path")
	public void user_should_click_the_History_By_Store_path() throws InterruptedException {
		 MenuBarPage p = new MenuBarPage();
		    p.HistoryByStore();
		    p.slideMenu();
	}
	@When("User should click the Transactions path")
	public void user_should_click_the_Transactions_path() throws InterruptedException {
		 MenuBarPage p = new MenuBarPage();
		    p.Transactions();
		    p.slideMenu();
	}
}
