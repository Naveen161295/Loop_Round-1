package org.TestRunner;






import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/FeatureFiles/DataVerification.feature", monochrome = true, dryRun = false
, glue = "org.stepDefinition")
public class TestRunner extends AbstractTestNGCucumberTests {

	

}
