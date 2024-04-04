package pagepackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage {
	WebDriver driver;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[2]/div[1]/div[2]/div[2]/ul[1]/li[2]/div[1]/div[2]/div[1]/h3[1]/a[1]")
	WebElement product;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/button[1]")
	WebElement addtocart;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement viewcart;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement checkout;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/a[1]")
	WebElement codelink;
	@FindBy(xpath="//a[contains(text(),'Click here to enter your code')]")
	WebElement code;
	@FindBy(xpath="//a[contains(text(),'Click here to login')]")
	WebElement login;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/input[1]")
	WebElement un;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/input[1]")
	WebElement pw;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[5]/input[3]")
	WebElement loginbutton;
	@FindBy(xpath="//input[@id='billing_first_name']")
	WebElement fn;
	@FindBy(xpath="//input[@id='billing_last_name']")
	WebElement ln;
	@FindBy(xpath="//input[@id='billing_company']")
	WebElement companyn;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[5]/span[1]/input[1]")
	WebElement streetadd;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[6]/span[1]/input[1]")
	WebElement apartn;
	@FindBy(xpath="//input[@id='billing_city']")
	WebElement city;
	@FindBy(xpath="//input[@id='billing_postcode']")
	WebElement postcode;
	@FindBy(xpath="//input[@id='billing_phone']")
	WebElement phno;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[11]/span[1]/input[1]")
	WebElement alterph;
	@FindBy(xpath="//input[@id='billing_email']")
	WebElement email;
	@FindBy(xpath="//textarea[@id='order_comments']")
	WebElement notes;
	@FindBy(xpath="//span[contains(text(),'Ship to a different address?')]")
	WebElement radiobutton;
	@FindBy(xpath="//button[@id='place_order']")
	WebElement proceedb;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
	WebElement text;
	public Checkoutpage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void checkoutloading() throws InterruptedException 
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		//Thread.sleep(2000);
		product.click();
		addtocart.click();
		viewcart.click();
		checkout.click();

	}
	public void coupon()
	{
		codelink.click();
		code.sendKeys("ABC100",Keys.ENTER);
		
	}
	public void loginfield()
	{
		login.click();
	}
	public void setvalues(String username,String password)
	{
		un.sendKeys(username);
		pw.sendKeys(password);
	}
	public void login()
	{
		loginbutton.click();
	}
	public void trueLogin()
	{
		un.sendKeys("anitha.sasi15@gmail.com");
		pw.sendKeys("Anitha@123");
		loginbutton.click();
	}
	public void billingDetails() throws InterruptedException
	{
		fn.sendKeys("anitha");
		ln.sendKeys("sasi");
		companyn.sendKeys("luminar");
		streetadd.sendKeys("abc lane");
		apartn.sendKeys("abc home");
		city.sendKeys("ekm");
		postcode.sendKeys("123456");
		phno.sendKeys("123456789123456");
		alterph.sendKeys("456789123456789123");
		email.sendKeys("jn@dnk.ncjk");
		notes.sendKeys("this is a automated site");
		
		
	}
	public void shipToanother()
	{
		if(radiobutton.isSelected())
		{
			System.out.println("Radio button is enabled");
		}
		else
		{
			System.out.println("Radio button not enabled");
			radiobutton.click();
		}
	}
	public void proceed() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(text).perform();
		Thread.sleep(2000);
		proceedb.click();
	}

}
