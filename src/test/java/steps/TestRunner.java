package steps;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.AllTests;

import io.cucumber.junit.CucumberOptions;
import pages.SearchPage;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/BusinessHoursSearch.feature", 
glue= {"steps"},
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports"}
		)


public class TestRunner {
	static JUnitCore junit;
	public static void main(String[] args) throws Throwable {
		final String[] arguments = new String[] {
				"--glue","steps",
				"src/test/resources/Features/BusinessHoursSearch.feature"
		};
		cucumber.api.cli.Main.main(arguments);
	}
}
