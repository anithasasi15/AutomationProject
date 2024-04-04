package baseclasspkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseurlclass {
	public static WebDriver driver;
	String baseurl="https://wayanadantouchgarden.com/";
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
