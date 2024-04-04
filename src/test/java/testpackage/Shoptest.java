package testpackage;

import org.testng.annotations.Test;

import baseclasspkg.Shopurl;
import pagepackage.Shoppage;

public class Shoptest extends Shopurl {
	@Test
	public void shoptesting() throws InterruptedException
	{
		Shoppage ob=new Shoppage(driver);
		ob.sortBy();
		ob.gridChanging();
		
		ob.addingtoCart();
		ob.addtoWishlist();
		ob.wishlisttoCart();
	}

}
