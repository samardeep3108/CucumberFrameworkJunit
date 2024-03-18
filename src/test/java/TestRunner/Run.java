package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions
(
		features = {".//Features/LoginFeature.feature" ,".//Features/AddCandidate.feature"},
		tags =  "@sanity" , 
		glue = "StepDefinition", 
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumber-report/reports1.html"}
			)

		
		

public class Run {
	//nothing will be provided in the class everything will be outside class
}
