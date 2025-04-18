package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PageObjects.HomePage;

public class TC_001 {

	public WebDriver wd;

	@BeforeClass
	public void setup() throws InterruptedException {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=9021025829148701210&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062122&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		Thread.sleep(10000);
	}

	@Test
	public void product() throws InterruptedException {
		try {
			HomePage hp = new HomePage(wd);
			hp.SearchBox("laptop");
			hp.Enter();
			Thread.sleep(3000);
			hp.SelectBrand();
			Thread.sleep(2000);
			hp.PNameandPPrice();
			hp.SelectProduct();
			Thread.sleep(2000);
			hp.Cart();
			Thread.sleep(2000);
			boolean status = hp.Verification();
			if(status==true) {
				System.out.println("Product is successfully added to cart");
				Assert.assertTrue(true);
			}
			else {
				System.out.println("Product is NOT added to cart");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		wd.close();

	}

}
