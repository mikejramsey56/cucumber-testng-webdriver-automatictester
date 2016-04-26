##About#

This project is based on a *Basic Cucumber-JVM + Selenium WebDriver test automation framework* [posted](https://automatictester.co.uk/2015/06/11/basic-cucumberjvm-selenium-webdriver-test-automation-framework/) by *automatictester* on June 11, 2015. for integrating *cucumber-jvm* and *Testng*.  The goal of this project is to learn more about the technology so that it can be used on a commercial project.

I created the project as described by *automatictester* and then did an import (Maven) into Eclipse (Java and M2e plugins installed).

Out of the box, the automatictester framework runs two test runner classes in parallel. These are TestNG test runners, not JUnit test runners. Each TestNG test runner has their own @CucumberOptions annotation and each is tied to a specific feature file.

###Use cucumber tags to control execution###
The first goal is to have test execution controlled by cucumber tags.  There are two feature files. I assigned tag *@orig* to the first and tag *@copy* to the second feature. In the *testng.xml* file, I reduced the *thread-count* to one.  

    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
    <suite name="Test runner" parallel="classes" thread-count="1">
        <test name="Package with subpackages">
            <packages>
                <package name="automatictester.jwebfwk.runners.*"/>
            </packages>
        </test>
    </suite>

I renamed the first TestNG test runner to **TestNGRunnerTest.java**.  The **Test** name suffix is the default that the Maven Surefire-plugin looks to execute when the **Test** goal is specified. In the runners folder, I deleted the second TestNG test runner and changed the remaining TestNG test runner thusly:

    package automatictester.jwebfwk.runners;
    
    import cucumber.api.CucumberOptions;
    import cucumber.api.testng.AbstractTestNGCucumberTests;
        
    @CucumberOptions(features = "classpath:features",
        glue = "classpath:automatictester.jwebfwk.steps",
        tags = "@orig,@copy",
        plugin = {"pretty"})
    public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
    }

I used an Eclipse Maven Build run configuration to execute the test by specifying

    Goal: clean test

 The above is equivalent to executing **mvn clean test** from the command line.  It worked, both tags were executed.  I removed first one and then the other tag and reran. Each time only the expected feature file was executed.

Next, I moved the tags from above the *Feature:* statement to above the *Scenario* statement. and repeated the above tests. Again, the scenarios were executed as expected. 

I then added a second scenario to each feature file, moved the tags from the first scenario to the second in each feature file then repeated the tests.  Again, only the second scenario matching the tag(s) in the TestNG test runner executed. I would say success.

###Overriding cucumber options from the command line###
The second goal is to override cucumber options without changing the cucumber TestNG test runner file. The test runner specifies which tags to run in the **@CumberOptions** annotation.  Annotations are compile time so they cannot be overridden during execution.  However, *cucumber-jvm* supports an override via the **-Dcucumber.options** command line parameter. So I modified the Maven Build run configuration I have been using to execute the tests to look like:

    Goals: clean test -Dcucumber.options="--tags @orig,@copy --glue classpath:automatictester.jwebfwk.steps classpath:features"

I executed the modified run configuration and it worked.  I ran just the *@orig* tag then only the *@copy* tag.  Each time it worked exactly as expected.

Notice that you specify the cucumber options differently in *-Dcucumber.options* then when using the *@CucumberOptions* annotation.  The syntax required in *-Dcucumber.options* is explained [here](https://github.com/cucumber/cucumber-jvm/blob/0aecc4d3e4c15fc34b63f848043deba2c230e35f/core/src/main/resources/cucumber/api/cli/USAGE.txt).

###Reporting###
The TestNG runner is in control and expects a static **@Test** annotation before each test.  Cucumber is invoking the tests dynamically so only the first test registers, and the names come form the testng.xml file.  Conclusion: the reporting is abysmal.  TO-DO: Do dynamically what TestNG is doing statically.