package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {

    @After
    public void teardown(Scenario scenario) {
        System.out.println("Scenario = " + scenario.getName() + "\nStatus = " + scenario.getStatus());
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                        .getScreenshotAs(OutputType.BYTES);

                scenario.embed(screenshot, "image/png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Driver.quitDriver();
        }
    }
}
