package testpackage;

import org.testng.annotations.Test;

import baseclasspkg.Baseurlclass;
import baseclasspkg.Checkouturl;
import baseclasspkg.Shopurl;
import excelutilspackage.Excelutilsclass;
import pagepackage.Checkoutpage;

public class Checkouttest extends Checkouturl{
	@Test
	public void operation() throws InterruptedException
	{
		Checkoutpage ob=new Checkoutpage(driver);
		ob.checkoutloading();
		ob.coupon();
		ob.loginfield();
		//data driven testing
		String xl="C:\\Users\\MITHUN\\Desktop\\wtg.xlsx";
		String sheet="Sheet1";
		int rowcount=Excelutilsclass.getRowcount(xl, sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String username=Excelutilsclass.getCellvalues(xl, sheet, i, 0);
			System.out.println("Username: "+username);
			String password=Excelutilsclass.getCellvalues(xl, sheet, i, 1);
			System.out.println("Password: "+password);
			ob.setvalues(username, password);
			ob.login();
			ob.loginfield();
			
		}
		ob.trueLogin();
		ob.billingDetails();
		ob.shipToanother();
		ob.proceed();
		
	}
}
