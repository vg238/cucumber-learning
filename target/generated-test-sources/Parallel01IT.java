import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/devl/workspace/VijayGanji/ecashAutomation/src/test/resources/features/login.feature"},
        plugin = {"json:C:/devl/workspace/VijayGanji/ecashAutomation/target/cucumber-parallel/1.json", "html:C:/devl/workspace/VijayGanji/ecashAutomation/target/cucumber-parallel/1"},
        monochrome = false,
        tags = {"@run", "~@ignored"},
        glue = {"com.ccfi.ecash.ecashAutomation.steps_definitions"})
public class Parallel01IT {
}
