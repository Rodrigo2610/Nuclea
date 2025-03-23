package Pages;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementosPesquisa { 

    private static WebElement element = null;
    
    public static WebElement BarraPesquisa (WebDriver driver){
   	  
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'twotabsearchtextbox') or contains(@id,'nav-search-keywords')]")));
 	
 	 element = driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox') or contains(@id,'nav-search-keywords')]"));  
        return element;
}
    
    public static WebElement LupaPesquisa (WebDriver driver){
     	  
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@type,'submit') or contains(@id,'nav-search-submit-button')]")));
 	
 	 element = driver.findElement(By.xpath("//input[contains(@type,'submit') or contains(@id,'nav-search-submit-button')]"));  
        return element;
}
    
    public static WebElement LabelPesquisaProduto (WebDriver driver){
     	  
 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[3]")));
 	
 	 element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/span/div/h1/div/div[1]/div/h2/span[3]"));  
        return element;
}
    

    
}
