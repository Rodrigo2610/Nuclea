package Pages;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementosLogin { 

    private static WebElement element = null;
    
    public static WebElement UserName (WebDriver driver){
   	  
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
 	
 	 element = driver.findElement(By.id("username"));  
        return element;
}
    
    public static WebElement PassWord (WebDriver driver){
     	  
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
 	
 	 element = driver.findElement(By.id("password"));  
        return element;
}
    
    public static WebElement BtnLogin (WebDriver driver){
     	  
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kc-login")));
 	
 	 element = driver.findElement(By.id("kc-login"));  
        return element;
}
    
    public static WebElement Msg_LoginIvalido (WebDriver driver){
   	  
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
     	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-error")));
     	
     	 element = driver.findElement(By.id("input-error"));  
            return element;
    }
    
}
