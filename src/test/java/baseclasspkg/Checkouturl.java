package baseclasspkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Checkouturl {
	public static WebDriver driver;
	String checkurl="https://wayanadantouchgarden.com/shop";
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(checkurl);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void closing()
	{
		driver.quit();
	}

}
