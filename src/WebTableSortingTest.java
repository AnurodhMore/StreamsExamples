import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
// Sorting mechanism using Streams
public class WebTableSortingTest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anumore\\Documents\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the column - it gets sorted
	    driver.findElement(By.xpath("//tr/th[1]")).click();
	    
	 // Capture all the webelements into List 
	    List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
	 //capture text of all webelements into new(Original) list //.collect is top store it into a new list
	    List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
	  //apply sort on the original list of step 3 -->(Sorted list)
	    
	   List<String> sortedList =  originalList.stream().sorted().collect(Collectors.toList());
	   
	 //compare original list vs sorted list
	   Assert.assertTrue(originalList.equals(sortedList));
	    
	    
	   //scan the name column with getText() -> Rice -> print the price of the rice
 	   // we already have elements in a list called elementsList
	   List<String> price;
	   
	  do // using do while for pageination as there are more than one page and a possibility element can be on other page
	  { 
		  List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
	  price =  rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).
			 collect(Collectors.toList());
	   // it will filter out Rice from all elements and get its price
	 
	 price.forEach(a->System.out.println(a)); // to print all the elements in the list
	 // sibling xpath:  //tr/td[1]/following-sibling::td[1] eg. key value pair
	 
	 if(price.size()<1)
	 {
		 driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
	 }
	  }while(price.size()<1);
	 // eg. lets add discount price
	 
//	 List<String> disPrice = elementsList.stream().filter(s->s.getText().contains("Banana"))
//			 .map(s->getDisPrice(s)).collect(Collectors.toList());
	 
	   
	}
	
//	private static String getDisPrice(WebElement s) {
//		
//		String disPrice = s.findElement(By.xpath("following-sibling::td[2]")).getText();
//		return disPrice;
//	}

	private static String getPriceVeggie(WebElement s)

	{
    	String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); // using second half of xpath as first half
		// is present in elementsList(already defined)
		return priceValue;
	}
}
