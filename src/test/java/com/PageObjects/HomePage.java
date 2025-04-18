package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	
	public WebDriver wd;
	
	//Constructor
	public HomePage(WebDriver wd) {
		this.wd = wd;
	}
	
	//Locators
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	By enter = By.xpath("//input[@type='submit']");
	By selectBrand = By.xpath("//span[text()='ASUS']");
	
	By first = By.xpath("//button[@class='a-button-text']");
	
	By cart = By.xpath("//div[@id='nav-cart-text-container']");
	
	By msg = By.id("sc-active-items-header");
	
	//Action Methods
	public void SearchBox(String pName) {
		wd.findElement(searchBox).sendKeys(pName);
	}
	
	public void Enter() {
		wd.findElement(enter).click();
	}
	
	public void SelectBrand() {
		wd.findElement(selectBrand).click();
	}
	
	public void PNameandPPrice() {
		List<WebElement> name = wd.findElements(By.xpath("//div[@data-cy='title-recipe']"));
		List<WebElement> price = wd.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(int i=0; i<5; i++) {
			System.out.println("Product Name: "+name.get(i).getText()+"| Product Price: "+price.get(i).getText());
		}
	}
	
	public void SelectProduct() {
		wd.findElements(first).get(0).click();
	}
	
	public void Cart() {
		wd.findElement(cart).click();
	}
	
	public boolean Verification() {
		try {
		return(wd.findElement(msg).isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
		
	}

}
