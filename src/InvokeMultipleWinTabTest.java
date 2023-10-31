import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWinTabTest {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		//.window for new window
		
		Set<String> handles = driver.getWindowHandles(); // will have all info related to all open windows
		// [PARENTID, CHILDID]
		
		Iterator<String> it = handles.iterator(); // it wi;; iterate through windows to get id
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		driver.get("https://www.rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		String courseName= driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
	//switch back to parent browser
		
		driver.switchTo().window(parentId);
		
	    WebElement name = 	driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys(courseName);
		//Screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
	//	above one is file object. If want to get physical file from file object we use FielUtils
		
		
	//	After adding apache commons fielutils maven jar
		 FileUtils.copyToDirectory(file, new File("logo.png")); //converts file object into physical file
	

		 //Get height and width
		 
	     System.out.println(name.getRect().getDimension().getHeight());
		 
	     System.out.println(name.getRect().getDimension().getWidth());
		 
		 
		 
	}

}
