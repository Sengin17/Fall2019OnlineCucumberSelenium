package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//@RunWith => comes from Junit. It allows to have custom test configuration
//cucumber has it's own flow to run test - during runtime turns into executable test
//@CucumberOptions => stands for parameterization for test execution
//glue => trigger of cucumber test. Runner class needs to know where are step definition and feature file
//path to step definition, right click on step_definitions - copy from source root
//features => specifies path to the feature files right click on features - copy from content root

//step definitions class is not inherits any class or not supposed to be inherited
//we just create page classes objects, and use their methods in StepDefinitions class
@RunWith(Cucumber.class)
@CucumberOptions(

        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",

        // method olusturmk icin true
        // test etmek icin, methodu olusturduktan sonra false yapman gerek
        dryRun = true,
        strict = false,
        //tags = "@driver"
       // tags = "@dashboard or @driver"
        //tags = "@dashboard and @driver"
        //tags = "@login_with_params",
       //tags = "@activities",
      //  tags = "@create_calendar_event_2",
        // tag is a feature file's tag
        tags = "scenario_outline",
        // //command + shift + f => to deep search where tags (activities) is used
        plugin = {
                "html:target/default-report",
                "json:target/cucumber1.json"
        }
)
class CucumberRunnerEx {


}

/*
  //our framework creates json file, some plugin takes jason file and generates a nice HTML report
//json looks like plain text, has "properties,values" , arrays,Strings,integers,
//json object vs java object
//json object has only properties no method; java object has both properties and methods
//We add json plugin => "json:target/cucumber.json" => to let it generate by our framework
 */
/*
To generate reports :
From maven click : verfiy
Terminal command => mvn verify / mvn test
To clean target file and run => mvn clean verify / mvn clean test
*It does not generate report when you run from cucumberRunner
 */

/*
Gherkin Language - is used to write BDD Scenarios
Keywords: Given. When, Then, And, But
Background, Scenario, Scenario Outline, Examples
Test DATA - is stored in feature files. We use parameters, data tables, examples, t
able to store test data in feature files.
Who provides test data?
	1. Yourself
	2. If you are responsible only for automation, and test case are written by manual testers,
	 then they give you ready test with all steps and test data.
	3. Developers can give you too
Background: we use to reduce number of same steps.
If all scenarios in some feature file have common beginning steps, we can put them under background.
 */

/*
<configuration>
    <!-- for parallel running Cucumber-->
    <parallel>classes</parallel>
    <threadCount>2</threadCount>
    <perCoreThreadCount>false</perCoreThreadCount>
    <forkCount>2C</forkCount>
    <includes>
        <!-- for  run class or classes-->
        <include>**//*Runner.java</include>
</includes>
<testFailureIgnore>true</testFailureIgnore>
</configuration>

 */

/*
There are 3 parameters in junit, we can run :
1. Classes
2. Feature files
3. Classes and feature files
Technically 2; both is old, use either feature files or calsses
 */

/*
When new build is deployed => smoke test must be triggered immediately.
It is first step of verification that build was success.
 */