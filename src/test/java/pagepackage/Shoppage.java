package pagepackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Shoppage {
	WebDriver driver;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/span[1]")
	WebElement sorting;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[4]/a[1]")
	WebElement sortDate;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]")
	WebElement sortLh;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]")
	WebElement twoGrid;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
	WebElement fourGrid;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
	WebElement bulletGrid;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[2]/div[1]/h3[1]/a[1]")
	WebElement product;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/button[1]")
	WebElement plusbutton;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/button[2]")
	WebElement minusbutton;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/button[1]")
	WebElement addtoCart;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/button[1]")
	WebElement wishlistb;
	@FindBy(xpath="//body[1]/div[9]/div[1]/div[1]/div[1]/span[3]")
	WebElement wishlistClose;
	@FindBy(xpath="//body[1]/div[9]/div[1]/div[1]/div[3]/div[1]/a[1]")
	WebElement wishlistOpen;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[2]/div[1]/a[1]")
	WebElement addtocartwl;
	@FindBy(xpath="//body[1]/div[1]/header[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement cartremove;
	@FindBy(xpath="//body[1]/div[1]/header[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[3]/a[1]")
	WebElement remove;
	@FindBy(xpath="//body[1]/div[1]/header[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a[2]")
	WebElement viewCart;
	
	public Shoppage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void sortBy()
	{
		
		sorting.click();
		sortDate.click();
	}
	public void gridChanging()
	{
		twoGrid.click();
		fourGrid.click();
		bulletGrid.click();
	}
	public void addingtoCart() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(5000);
		product.click();
		
		plusbutton.click();
		minusbutton.click();
		addtoCart.click();
		String actual=driver.getPageSource();
		String exp="has been added to your cart";
		if(actual.contains(exp))
		{
			System.out.println("product added to the cart successfully");
		}
		else
		{
			System.out.println("The product does not added to the cart");
		}
		driver.navigate().back();
		
	}
	public void addtoWishlist()
	{
		wishlistb.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[9]/div[1]/div[1]/div[1]/span[3]")));
		wishlistOpen.click();
		
	}
	public void wishlisttoCart() 
	{
		addtocartwl.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/header[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")));
		remove.click();
		viewCart.click();
		driver.navigate().back();
	}
	

}
