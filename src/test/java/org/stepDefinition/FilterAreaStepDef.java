package org.stepDefinition;

import org.textcontext.ExtractedCSV;
import org.textcontext.FiltersArea;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterAreaStepDef {
	@When("User should filter the location as Artisan Alchemy, Blissful Buffet")
	public void user_should_filter_the_location_as_artisan_alchemy_blissful_buffet() {
	    FiltersArea a= new FiltersArea();
	    a.locationsmenu();
	}
	@When("User should filter the marketplace as Grubhub")
	public void user_should_filter_the_marketplace_as_grubhub() {
		FiltersArea a= new FiltersArea();
		a.marketPlacemenu();
	}
	@Then("User should the click the Download button to extract the CSV file.")
	public void user_should_the_click_the_download_button_to_extract_the_csv_file() throws InterruptedException {
		FiltersArea a= new FiltersArea();
		a.downloadCSVbtn();
		ExtractedCSV b = new ExtractedCSV();
		b.FileOperation();
		b.orderIdCheck();
	}
}
