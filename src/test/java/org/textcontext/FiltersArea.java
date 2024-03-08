package org.textcontext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.UtilityClass;

public class FiltersArea extends UtilityClass{
public FiltersArea() {
	PageFactory.initElements(driver, this);
}


@FindBy(xpath="//span[text()='Locations']")
private WebElement locations;

@FindBy(xpath="//button[text()='Clear']")
private WebElement clearbtn;


@FindBy(xpath="//button[text()='Apply (']")
private WebElement applyFilterbtn;

@FindBy(xpath="//span[text()='Marketplaces']")
private WebElement MarketPlaces;

@FindBy(xpath="//button[text()='Download']")
private WebElement downloadbtn;



public WebElement getLocations() {
	return locations;
}

public WebElement getClearbtn() {
	return clearbtn;
}

public WebElement getApplyFilterbtn() {
	return applyFilterbtn;
}

public WebElement getMarketPlaces() {
	return MarketPlaces;
}

public WebElement getDownloadbtn() {
	return downloadbtn;
}

public void locationsmenu() {
	click(getLocations());
	actions(getClearbtn(), "movetoElement");
	click(getClearbtn());
	for (int i =0; i < location.length; i++) {
		WebElement loc = driver.findElement(By.xpath("//div[@aria-label='"+location[i]+"']"));
		actions(loc, "movetoElement");
		click(loc);
	
	}
	actions(getApplyFilterbtn(), "movetoElement");
	click(getApplyFilterbtn());
}
public void marketPlacemenu() {
	click(getMarketPlaces());
	actions(getClearbtn(), "movetoElement");
	click(getClearbtn());	
	for (int i = 0; i < Mrktplcs.length; i++) {
		WebElement marketPlaces = driver.findElement(By.xpath("//p[text()='"+Mrktplcs[i]+"']"));
		actions(marketPlaces, "movetoElement");
		click(marketPlaces);
	}
	actions(getApplyFilterbtn(), "movetoElement");
	click(getApplyFilterbtn());
}
public void downloadCSVbtn() throws InterruptedException {
	wait(5);
	actions(getDownloadbtn(), "movetoElement");
	click(getDownloadbtn());
	wait(10);

}

}
