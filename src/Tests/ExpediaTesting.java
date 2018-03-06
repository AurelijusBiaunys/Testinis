package Tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExpediaTesting {
	
	WebDriver driver;
	String city = "Texas, United States of America";
	String dateFrom ="19/01/2018";
	String dateTo = "05/02/2018";
	String roomNumber = "3";
	String adultNumber = "2";
	String childrenNumber = "1";
	String childAge= "1";
	//String starRating = "star3";
	//String searchResult = "2";
	
	@Test
	public void hotelReservation() {
		
		//Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(dateFrom);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(dateTo);
		new Select( driver.findElement(By.id("hotel-rooms-hp-hotel")) ).selectByValue(roomNumber);
		new Select( driver.findElement(By.id("hotel-1-adults-hp-hotel")) ).selectByValue(adultNumber);
		new Select( driver.findElement(By.id("hotel-1-children-hp-hotel")) ).selectByValue(childrenNumber);
		new Select( driver.findElement(By.id("hotel-1-age-select-1-hp-hotel")) ).selectByValue(childAge);
		//submit
		driver.findElement(By.cssSelector("button[class='btn-primary btn-action  gcw-submit']")).click();
		//===================================================================================================
		//Modify the search results on the new page
		
		//printing of a city name
		//String acctualCity = driver.findElement(By.id("hotelResultTitle")).getText();
		String acctualCity = driver.findElement(By.cssSelector("h1[class='section-header-main']")).getText();
		System.out.print("City: "+ acctualCity);
				
		//selecting star rating
		//new Select ( driver.findElement(By.id("star3"))).getFirstSelectedOption();
		driver.findElement(By.id("star3")).click();
		//driver.findElement(By.cssSelector("input[name='star'][id='star3']")).click();
		
		//analyze the results, make a selection
		//choosing the third element from the top
		//driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div[5]/div[2]/div[4]/section/section/article[5]/a")).click();	
		//driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[3]/div[2]/div/a")).click();
		driver.findElement(By.cssSelector("a[class='flex-link'][target='24199']")).click();
		//switch windows
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		System.out.println("Hotel name: "+ hotelName );
		String hotelRate = driver.findElement(By.cssSelector("span[class='rating-number']")).getText();
		System.out.println("Hotel rating: "+ hotelRate);
		//book the reservation
		
		//fill out billing
		
		//get confirmation
		
		
	}
	//===========================================================
	@BeforeClass
	public void setUp() {
		driver=Utilities.DriverFactory.open("Firefox");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	//manage page load timeout
		driver.get("https://www.expedia.co.uk");
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	//=============================================================
}
