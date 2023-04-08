package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDef.Hook;

import java.security.PublicKey;
import java.util.WeakHashMap;

public class P03_Dashboard {
    public WebElement helloUser(){
        return Hook.driver.findElement(By.xpath("//p[@class='hello']//strong[1]"));
    }
    public WebElement successRegister(){
        return Hook.driver.findElement(By.xpath("//html[@id='top']/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]"));
    }
}
