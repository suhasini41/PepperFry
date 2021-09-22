package com.pepperfry.qa.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pepperfry.qa.base.Base;

public class SearchFieldTest extends Base
{
	@Test
	public void titleTest()
	{
		Assert.assertEquals(driver.getTitle(), "Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry");
	}
	
	@Test(priority=1)
	@Parameters("searchData")
	public void searchFieldTest(String searchData)
	{
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(searchData+Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='clip-crd-10x11 pf-white srch-rslt-bxwrpr']//div[@class='clip-dtl-ttl row']//a"));
		List<String> original = new ArrayList<>();
		for(WebElement e : list)
		{
			
			original.add(e.getText());
		}
		System.out.println("Ascending order");
		Reporter.log("Ascending order"+"\n");
		Reporter.log("***************************************************************"+"\n");
		System.out.println("***********************************************************");
		Collections.sort(original);
		for(String e : original)
		{
			System.out.println(e);
			Reporter.log(e+"\n");
		}
		System.out.println("\n");
		Reporter.log("****************************************************************"+"\n");
		System.out.println("***********************************************************");

		System.out.println("Descending order");
		Reporter.log("Descending order"+"\n");
		System.out.println("***********************************************************");
		Reporter.log("****************************************************************"+"\n");
		Collections.reverse(original);
		for(String e : original)
		{
			System.out.println(e);
			Reporter.log(e+"\n");
		}
		
		
	}

}
