import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.CommonEvents;

@Test

@CucumberOptions(

        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        glue = "stepdefs",
        tags = {"~@ignore", "@run"},

        features = "src/test/resources/features/")

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterClass(alwaysRun = true)
    protected void tearDown() {
        CommonEvents.closeDriver();

    }
}
