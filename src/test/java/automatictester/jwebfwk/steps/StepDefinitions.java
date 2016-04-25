package automatictester.jwebfwk.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import automatictester.jwebfwk.framework.ParentScenario;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

public class StepDefinitions extends ParentScenario {

	@Before
    public void beforeScenario() {
        startBrowser();
    }

    @Given("^I am on the Selenium homepage$")
    public void I_am_on_the_Selenium_homepage() {
        navigateTo();
    }

    @When("^I click \"([^\"]*)\" tab$")
    public void I_click_tab_on(String tab) {
        mainPage.clickTab(tab);
    }

    @Then("^I should see \"([^\"]*)\" download link on Download page$")
    public void I_should_see_download_link_on_download_page(String linkText) {
        assertThat(downloadPage.hasDownloadLinkFor(linkText), is(true));
    }

    @After
    public void afterScenario() {
        closeBrowser();
    }
}
