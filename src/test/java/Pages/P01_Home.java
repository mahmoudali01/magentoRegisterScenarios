package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDef.Hook;

public class P01_Home {

  public  WebElement search(){
       // return Hook.driver.findElement(By.id("search"));
      return Hook.driver.findElement(By.xpath("//button[@title='Search']"));
  }
    public WebElement accountICon(){
       //  return Hook.driver.findElement(By.className("skip-account"));
//        return Hook.driver.findElement(By.xpath("//a[contains(@class,'skip-link skip-account')]"));
       // return Hook.driver.findElement(By.cssSelector("header#header>div>div:nth-of-type(2)>a:nth-of-type(3)"));
        return Hook.driver.findElement(By.xpath("//a[@href='#header-account']//span[1]"));

    }
    public  WebElement registerBTN(){
        return Hook.driver.findElement(By.linkText("Register"));
    }
    public void clickAccount(){
        accountICon().click();
    }
    public void clickRegister(){
        registerBTN().click();
    }
}
