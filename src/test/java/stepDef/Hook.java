package stepDef;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class Hook {
    public static WebDriver driver ;
    @Before
    public void openBrowser(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterStep
    public void TakeScreen( Scenario scenario){
        String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

        byte[] decodeScreenshot = Base64.decodeBase64(screenshot);
        scenario.attach(decodeScreenshot ,"img/png",scenario.getName());

        if(scenario.getStatus().toString().equalsIgnoreCase("PASSED")){
            ExtentCucumberAdapter.getCurrentStep().log(Status.PASS,"Step Screen" , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        }
        else if (scenario.getStatus().toString().equalsIgnoreCase("SKIPPED")){
            ExtentCucumberAdapter.getCurrentStep().log(Status.SKIP,"Step Screen" , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        }
        else if(scenario.isFailed()) {
            ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,"Step Screen" , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        }

    }

    @After
    public  void TearDown() throws IOException {
        driver.quit();
    }
}
