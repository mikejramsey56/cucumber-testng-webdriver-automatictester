package automatictester.jwebfwk.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/Download_Copy.feature",
        glue = "automatictester.jwebfwk.steps",
        plugin = {"pretty"})

public class DownloadFeatureRunner_Copy extends AbstractTestNGCucumberTests {

}
