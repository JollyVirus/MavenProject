package Example;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.objectweb.asm.util.Textifier;

import java.awt.datatransfer.*;

import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import org.openqa.selenium.support.ui.Select;



public class NewTest


{
 
	public String driverPath = ("C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\chromedriver.exe");
	public String driverPathFirefox = ("C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\geckodriver.exe");

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
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ppias\\OneDrive\\Desktop\\\\Selenium\\Drivers\\geckodriver.exe"); 	
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
		  
		// Create object of SimpleDateFormat class and decide the format

          DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

          //get current date time with Date()

          Date date = new Date();

        // Now format the date

          String date1= dateFormat.format(date);

        // Print the Date

          System.out.println("Current date and time is " +date1);
		  
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
		 
		 AssertJUnit.assertEquals(CartQuantity, Quantity);
		 AssertJUnit.assertEquals(CartDescription, Description);
		 AssertJUnit.assertEquals(CartPrice, Price, 0.01);
		 Thread.sleep(2000);
		 
		// Create object of SimpleDateFormat class and decide the format

         DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

         //get current date time with Date()

         Date dateA1 = new Date();

       // Now format the date

         String date2= dateFormat1.format(dateA1);

       // Print the Date

         System.out.println("Current date and time is " +date2);
         
         
		 driver.close();
		 
    }
	
    @Test (priority = 1)
    
    public void SwagLabsRobot() throws AWTException, InterruptedException, IOException
    
    {
    	
    	// Using robot and clipboard to log into SWAGLABS
    	
    	driver = new ChromeDriver();
    	driver.get("https://www.saucedemo.com/");
    	driver.manage().window().maximize();
    	
    	try
    	{
    		
    		
    		System.out.println("Using Java robot to log into SWAGLabs");
    		
    		Robot robot = new Robot();
    		Thread.sleep(3000);
    		
    		 robot.keyPress(KeyEvent.VK_TAB); 
             robot.keyRelease(KeyEvent.VK_TAB);
             
             // Add string to clipboard, then paste into username
             String text = "standard_user";
            
             StringSelection User = new StringSelection(text);
             Clipboard username = Toolkit.getDefaultToolkit().getSystemClipboard();
             username.setContents(User,  User);
             
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             
             robot.keyPress(KeyEvent.VK_TAB); 
             robot.keyRelease(KeyEvent.VK_TAB);
             
    	}
             
             finally
         	{
         		
         		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         	}
             
             try
         	{
         		
        		
         		Robot robot = new Robot();
         		Thread.sleep(3000);
              
             String textpass = "secret_sauce";
             StringSelection passcode = new StringSelection(textpass);
             Clipboard pass = Toolkit.getDefaultToolkit().getSystemClipboard();
             pass.setContents(passcode,  passcode);
             
            
             
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             
             Thread.sleep(2000);
             
             robot.keyPress(KeyEvent.VK_TAB); 
             robot.keyRelease(KeyEvent.VK_TAB);
             
             robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyRelease(KeyEvent.VK_ENTER);
             
         	}
    		
    	
    	
    	finally
    	{
    		
    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	}
    	
            System.out.println("User changes sorting order from A-Z to Z-A using dropdown, then changes it back to A-Z ");
            
            // Changing sorting order
            
            Select drop = new Select(driver.findElement(By.className("product_sort_container")));

            
            drop.selectByValue("za");
            screenShot("Screenshot z-a selected");
            Thread.sleep(2000);
            drop.selectByValue("az");
            
            Thread.sleep(2000);
            screenShot("Screenshot a-z selected");
            Thread.sleep(1000);
            driver.close();
    	
    }
    
    @Test (priority = 2)
    
    public void TabChanges() throws InterruptedException, AWTException
    
    {
    	
    	
    	driver = new ChromeDriver();
    	driver.get("https://www.saucedemo.com/");
    	driver.manage().window().maximize();
    	
    	String FirstTab = driver.getWindowHandle();
    	Thread.sleep(3000);
    	String title = driver.getTitle(); 
    	System.out.println("Title of web page is " +title);
    	try
    	{
    		
    		
    		Robot robot = new Robot();
    		Thread.sleep(3000);
    		
    		 robot.keyPress(KeyEvent.VK_CONTROL); 
             robot.keyPress(KeyEvent.VK_T);
             
             robot.keyRelease(KeyEvent.VK_CONTROL); 
             robot.keyRelease(KeyEvent.VK_T);
             
    	}
    	
    	finally
    	{
    		
    		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	}
    	
    	ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
    	newTab.remove(FirstTab);
    	driver.switchTo().window(newTab.get(0));     
        Thread.sleep(2000);
        driver.get("http://bing.com");
        Thread.sleep(2000);
        String title2 = driver.getTitle(); 
    	System.out.println("Title of web page is " +title2);
        
        driver.switchTo().window(FirstTab);
        driver.get("https://slickdeals.net/?utm_source=slickdeals_com&utm_medium=redirect&utm_campaign=redirect");
        String title3 = driver.getTitle(); 
    	System.out.println("Title of web page is " +title3);
        
        
     	
    }

}
