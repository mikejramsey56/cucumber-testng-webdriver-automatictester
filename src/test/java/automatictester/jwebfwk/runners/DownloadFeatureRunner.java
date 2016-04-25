package automatictester.jwebfwk.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:features/Download.feature",
	glue = "classpath:automatictester.jwebfwk.steps",
	plugin = {"pretty"})
public class DownloadFeatureRunner extends AbstractTestNGCucumberTests {
}