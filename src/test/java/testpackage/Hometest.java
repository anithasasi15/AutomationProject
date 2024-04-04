package testpackage;

import org.testng.annotations.Test;

import baseclasspkg.Baseurlclass;
import pagepackage.Homepage;

public class Hometest extends Baseurlclass
{
	@Test
	public void homepageTesting() throws Throwable 
	{
		Homepage ob=new Homepage(driver);
		ob.titleVerification();
		
		ob.logoChecking();
		ob.wishlistCount();
		ob.shoppingCart();
		ob.addingtowishlist();
		ob.featuredProduct();
		ob.productalignment();
		ob.linkResponse();
		
	}

}

