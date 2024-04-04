package baseclasspkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class Shopurl {
	public static WebDriver driver;
	String shopurl="https://wayanadantouchgarden.com/shop/";

	@BeforeTest
	public void loading()
	{
		driver=new ChromeDriver();
		driver.get(shopurl);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
