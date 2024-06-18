package Runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(
		
		features= {".//Features/homePage.feature"},
		//features={"@target/rerun.txt"}
				glue="StepDefinition",
				plugin= {"pretty", "html:reports/myreport.html",
						  "rerun:target/rerun.txt",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
						
				dryRun=false,    // checks mapping between scenario steps and step definition methods
				monochrome=true,    // to avoid junk characters in output
				publish=true   // to publish report in cucumber server
		)
public class runnerClass extends AbstractTestNGCucumberTests{
    
}
