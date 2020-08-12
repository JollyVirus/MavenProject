package Example;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest 


{
 
	public String driverPath = ("C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\chromedriver.exe");
	public WebDriver driver;
	
	
	 // Taking a screenshot method

    public void screenShot(String filename) throws IOException, InterruptedException
    
    {

        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\ppias\\OneDrive\\Desktop\\Screenshots\\CPractice\\" + filename+".png");
        FileUtils.copyFile(scr, dest);

    }
	
    
    @BeforeTest
    
    public void Set()
    
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\chromedriver.exe");
    	   	
    }
    
    
    
    @Test (priority = 0)
    
    public void SwaglabsTest() throws InterruptedException, IOException
    
    {
    	driver = new ChromeDriver();
    	driver.get("https://www.saucedemo.com/");
    	
    	// browser resize
    	 Dimension d = new Dimension(800,480);
         driver.manage().window().setSize(d);
         
         // browser maximize
         driver.manage().window().maximize();
         
		  Thread.sleep(2000);
		  System.out.println("1. User goes to SwagLabs homepage: See Screenshot 1 - Home page");
		  screenShot("Screenshot 1 Home page");
		  driver.findElement(By.id("user-name")).sendKeys("standard_user");
		  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
		  driver.findElement(By.id("login-button")).click();
		  Thread.sleep(2000);
		  System.out.println("2. User logs in arrives at product page: See Screenshot 2 - Product page");
		  screenShot("Screenshot 2 Product page");
		  
		 driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[3]/button")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
		 Thread.sleep(2000);
		 System.out.println("3. User Adds a backpack to the cart and goes to Checkout: See Screenshot 3 - Checkout");
		 screenShot("Screenshot 3 Checkout");
		 
		 String Quantity ="QTY";
		 String Description = "DESCRIPTION";
		 double Price = 29.99;
		 
		 String CartQuantity = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[1]")).getText();
		 String CartDescription = driver.findElement(By.xpath("//*[@id=\'cart_contents_container\']/div/div[1]/div[2]")).getText();
		 String CartPriceX = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
		 double CartPrice = Double.valueOf(CartPriceX);
		 
		 System.out.println("4. System compares actual values with expected values at Checkout page");
		 
		 Assert.assertEquals(CartQuantity, Quantity);
		 Assert.assertEquals(CartDescription, Description);
		 Assert.assertEquals(CartPrice, Price, 0.01);
		 
    }
	
    @Test (priority = 1)
    
    public void SwagLabsRobot()
    
    {
    	
    	driver = new ChromeDriver();
    	driver.get("https://www.saucedemo.com/");
    	driver.manage().window().maximize();
    	
    	
    	
    }
    
    @Test (priority = 2)
    
    public void TabChanges()
    
    {
    	
    	
    }

}
