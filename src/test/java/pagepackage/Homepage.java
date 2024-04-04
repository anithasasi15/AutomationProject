package pagepackage;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	WebDriver driver;
	
	@FindBy(xpath="//header/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/img[1]")
	WebElement logopic;
	@FindBy(xpath="//header/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/span[1]")
	WebElement wishlistCount;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]")
	WebElement product;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[2]/div[1]/h3[1]/a[1]")
	WebElement product1;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]")
	WebElement cart;
	@FindBy(xpath="//body[1]/div[1]/header[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement cartClose;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]")
	WebElement wishlist;
	@FindBy(xpath="//body[1]/div[9]/div[1]/div[1]/div[1]/span[3]")
	WebElement wishlistClose;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/span[1]")
	WebElement featuredproduct;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/article[1]/div[1]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/span[1]/a[1]")
	WebElement qvb;
	@FindBy(xpath="//body/div[3]/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement qvclose;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void titleVerification()
	{
		String exp="Wayanadan touch garden";
		String actual=driver.getTitle();
		if(actual.equals(exp))
		{
			System.out.println("The title is verified!!");
		}
		else
		{
			System.out.println("The title is not verified!!");
			System.out.println("The actual tile is "+actual);
		}
	}
	public void linkResponse()
	{
		List<WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in home page: "+l.size());
		for(WebElement ele:l)
		{
			String link=ele.getAttribute("href");
			try
			{
				URL u=new URL(link);
				HttpURLConnection con=(HttpURLConnection)u.openConnection();
				if(con.getResponseCode()==200)
				{
					System.out.println("The connection is sucessful!! Response code=200");
				}
				else if(con.getResponseCode()==404)
				{
					System.out.println("The connection is broken!! Response code is 404");
				}
				else
				{
					System.out.println("The response code is unexpected!!");
				}
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public void logoChecking()
	{
		if(logopic.isDisplayed())
		{
			System.out.println("The logo is present");
		}
		else
		{
			System.out.println("The logo is not present");
		}
	}
	public void wishlistCount()
	{
		String count= wishlistCount.getText();
		System.out.println("Initial wishlist count is :"+count);
		if(count.equals("0"))
		{
			System.out.println("Initial wishlist count is zero. No error");
		}
		else
		{
			System.out.println("Initial wishlist count is not zero, an error has occured");
		}
	}
	

	public void shoppingCart() throws Throwable 
	{	
		 Actions act=new Actions(driver);
		 act.moveToElement(product).perform();
		 act.moveToElement(product1).perform();
		 Thread.sleep(2000);
		 cart.click();
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/header[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")));
		 cartClose.click();
	}
	public void addingtowishlist()
	{
		Actions act=new Actions(driver);
		act.moveToElement(product).perform();
		act.moveToElement(product1).perform();
		wishlist.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[9]/div[1]/div[1]/div[1]/span[3]")));
		wishlistClose.click();
	}
	public void featuredProduct() throws IOException, InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(1400,2300)");
		featuredproduct.click();
		Thread.sleep(2000);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshots/featuredproducts.png"));
		
	}
	public void productalignment() throws IOException
	{
		Actions act=new Actions(driver);
		act.moveToElement(product).perform();
		act.moveToElement(product1).perform();

		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshots/productalignment.png"));

		
		
	}
	

	

}
