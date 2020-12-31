package com.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json", "pretty",
                "html:target/cucumber-html-report.html",
                "junit:target/cucumber-junit-report.xml",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        features = {"src/test/resources/features/"},
        tags = "(@UI or @API) and not @Manual",
        glue = {"com.testing"})
public class RunCucumberTest {

}
