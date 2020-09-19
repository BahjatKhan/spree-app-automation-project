package BDD;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (
     dryRun = true,
    features="src/test/resources/feature/SpreeFunctLogin.feature"
      //  glue={"BDD.Steps"}

)
public class BDDRunner {
}
