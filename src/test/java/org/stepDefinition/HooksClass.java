package org.stepDefinition;



import org.utility.UtilityClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class HooksClass extends UtilityClass{
	@Before
	public void Hooks() {
		
		getDriver("chrome");
		getUrl();
		
	}
	

	@After
	public void tearDowm()  {
	quit();
	}

}
