import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "ru.sberbank",
        plugin = {"pretty", "html:results.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true)
public class petTest {
}
