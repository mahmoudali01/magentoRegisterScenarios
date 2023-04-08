package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDef.Hook;

public class P02_Register {
    public WebElement fnameField(){
        return Hook.driver.findElement(By.id("firstname"));
    }
    public WebElement lnameField(){
        return Hook.driver.findElement(By.id("lastname"));
    }
    public WebElement emailField(){
        return Hook.driver.findElement(By.id("email_address"));
    }
    public WebElement passField(){
        return Hook.driver.findElement(By.id("password"));
    }
    public WebElement confirmPassField(){
        return Hook.driver.findElement(By.id("confirmation"));
    }
    public WebElement newsLetterCheckbox(){
        return Hook.driver.findElement(By.name("is_subscribed"));
    }
    public WebElement registerBTN(){
        return Hook.driver.findElement(By.xpath("//button[@title='Register']"));
    }
    public WebElement fnameRequired(){
        return Hook.driver.findElement(By.id("advice-required-entry-firstname"));
    }
    public WebElement lnameRequired(){
        return Hook.driver.findElement(By.id("advice-required-entry-lastname"));
    }
    public WebElement emailRequired(){
        return Hook.driver.findElement(By.id("advice-required-entry-email_address"));
    }
    public WebElement passwordRequired(){
        return Hook.driver.findElement(By.id("advice-required-entry-password"));
    }
    public WebElement confirmPasswordRequired(){
        return Hook.driver.findElement(By.id("advice-required-entry-confirmation"));
    }
    public WebElement alreadyRegistered(){
        return Hook.driver.findElement(By.xpath("//li[@class='error-msg']//li[1]"));
    }
    public WebElement passMin(){
        return Hook.driver.findElement(By.id("advice-validate-password-password"));
    }
    public WebElement passMatch(){
        return Hook.driver.findElement(By.id("advice-validate-cpassword-confirmation"));
    }
    public WebElement invalidEmailAddress(){
        return Hook.driver.findElement(By.id("advice-validate-email-email_address"));
    }
    public WebElement successRegister(){
        return Hook.driver.findElement(By.xpath("//li[@class='success-msg']//li[1]"));
        //return Hook.driver.findElement(By.xpath("//html[@id='top']/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]"));
    }
public void CheckNewsLetter(){
        newsLetterCheckbox().click();
}
public void submit(){
        registerBTN().click();
}
   public void register(String fname, String lname, String email,String password,String confirmPassword){
       fnameField().clear();
       fnameField().sendKeys(fname);
       lnameField().clear();
       lnameField().sendKeys(lname);
       emailField().clear();
       emailField().sendKeys(email);
       passField().clear();
       passField().sendKeys(password);
       confirmPassField().clear();
       confirmPassField().sendKeys(confirmPassword);
       newsLetterCheckbox().click();
       registerBTN().click();

   }


}
