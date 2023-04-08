package stepDef;

import Pages.P01_Home;
import Pages.P02_Register;
import Pages.P03_Dashboard;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D01_Register {
    P01_Home homePage = new P01_Home();
    P02_Register registerPage = new P02_Register();
    P03_Dashboard dashboardPage = new P03_Dashboard();
    @Given("User Navigate to home page")
    public void navigateToMagentoHome(){
        Hook.driver.get("http://magento-demo.lexiconn.com");
    }
    @When("User Click on Account icon")
    public void clickAccount(){
        homePage.clickAccount();
    }
    @And("Click on Register from dropdown displayed")
    public void clickRegisterFromDropDown() throws InterruptedException {
        homePage.clickRegister();
    }
    @And("^Enter \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void fillRegistrationForm(String fname, String lname, String email,String password,String confirmPassword){
        registerPage.register(fname, lname, email, password, confirmPassword);
    }
    @And("Check NewsLetter")
    public void checkNews(){
        registerPage.CheckNewsLetter();
    }

    @And("Click on Register button")
    public void submit(){
        registerPage.submit();

    }
    @Then("^\"(.*)\"$")
    public void validation(String message){
        if(message.equals("This is a required field.")){
            String fnameRequired = registerPage.fnameRequired().getText();
            Assert.assertEquals(fnameRequired.equals(message),true);
            String lnameRequired = registerPage.lnameRequired().getText();
            Assert.assertEquals(lnameRequired.equals(message),true);
            String emailRequired = registerPage.emailRequired().getText();
            Assert.assertEquals(emailRequired.equals(message),true);
            String passRequired = registerPage.passwordRequired().getText();
            Assert.assertEquals(passRequired.equals(message),true);
            String confirmPassRequired = registerPage.confirmPasswordRequired().getText();
            Assert.assertEquals(confirmPassRequired.equals(message),true);
        }
        else if(message.equals("Please enter a valid email address. For example johndoe@domain.com.")){
            String ar = registerPage.invalidEmailAddress().getText();
            Assert.assertEquals(ar.equals(message),true);

        }
        else if(message.equals("Please make sure your passwords match. ")){
            String ar = registerPage.passMatch().getText();
            Assert.assertEquals(ar.equals(message),true);

        }
        else if(message.equals("Please enter 6 or more characters. Leading or trailing spaces will be ignored.")){
            String ar = registerPage.passMin().getText();
            Assert.assertEquals(ar.equals(message),true);

        }
        else if(message.equals("Thank you for registering with Madison Island.")){
            String url = "http://magento-demo.lexiconn.com/customer/account/index/";
            Assert.assertEquals(url.equals(Hook.driver.getCurrentUrl()),true);

            String ar = dashboardPage.successRegister().getText();
            Assert.assertEquals(ar.equals(message),true);

        }
        else if(message.equals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.")){
            String ar = registerPage.alreadyRegistered().getText();
            Assert.assertEquals(ar.equals(message),true);

        }
    }
}
