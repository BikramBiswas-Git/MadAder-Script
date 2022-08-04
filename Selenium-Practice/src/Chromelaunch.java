import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chromelaunch {
	

	public static void main(String[] args) throws InterruptedException {
		int j=1;
		System.out.println("(//*[contains(@class, 'confirm')])["+j+"]\")");
		ChromeOptions opt =new ChromeOptions();
		opt.addExtensions(new File("app.crx"));
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("bikram.biswas@tier5.in");
		driver.findElement(By.id("pass")).sendKeys("Test@1234");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.get("chrome-extension://pedfpcoomdincjgknooboacfaihaacpn/login.html");
		driver.findElement(By.id("email")).sendKeys("bikram.biswas@tier5.in");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		int i;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,15000)", "");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		for(i=1;i<=3;i++) {
			driver.findElement(By.xpath("(//*[contains(@class, 'confirm')])["+i+"]")).click();
			driver.findElement(By.xpath("(//button[contains(@id, 'confirmBtn')])")).click();
			driver.findElement(By.xpath("(//button[contains(@id, 'subBtn')])["+1+"]")).click();                      

 			js.executeScript("window.scrollBy(0,20000)", "");

			js.executeScript("window.scrollBy(0,20000)", "");
			int k=i+1;
			System.out.println("(//*[contains(@class, 'confirm')])["+k+"]");
  			WebElement el=driver.findElement(By.xpath("(//*[contains(@class, 'confirm')])["+k+"]"));
 			System.out.println(el.isDisplayed());
			
 			
 	  	if(el.isDisplayed()==false) {
			js.executeScript("window.scrollBy(0,15000)", "");
			
			}
 		
 	  	if(el.isDisplayed()==false) {
			js.executeScript("window.scrollBy(0,15000)", "");
			
			}
 			
		}
		driver.get("chrome-extension://pedfpcoomdincjgknooboacfaihaacpn/dashboard.html");
		String adCount =driver.findElement(By.id("listCount")).getText();
		String exp="5";
		if(adCount.equals(exp)) {
		System.out.println("Succesfully added 5 ads ");
		}
		
		//delete	
		driver.findElement(By.xpath("(//*[@class=\"checkmark newClass\"])[1]")).click(); //Selecting one ad
		String adName =driver.findElement(By.xpath("//*[@id=\"ul0\"]/li[1]/label/a[1]")).getText(); 
		System.out.println("Selected  and deleted ad name is "+ adName);
		driver.findElement(By.xpath("//*[@class='deleteBtn']")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Yes')]")).click(); //deleting one ad
		String latestAd=driver.findElement(By.xpath("//*[@id=\"ul0\"]/li[1]/label/a[1]")).getText();
		System.out.println("After deleting new add name is " +latestAd);
		if(adName.equals(latestAd)) {      // verifying ad got deleted or not 
			System.out.println("Not deleted");
		}
		else
		{
			System.out.println("Succesfullty deleeted");
		}
	//Search 
		driver.findElement(By.id("search")).sendKeys(latestAd);
		driver.findElement(By.cssSelector("#searchAds > button")).click();
		String afterSearch= driver.findElement(By.cssSelector("#ul0 > li.checkBoxs > label > a")).getText();
		System.out.println(latestAd);
		System.out.println(afterSearch);
		if(latestAd.equals(afterSearch)) {
			System.out.println("Search worked ");
		}
		else {
			System.out.println("search did not worked");
		}
		
		
	
	}
	
	

}
