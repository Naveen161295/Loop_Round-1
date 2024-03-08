package org.textcontext;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.UtilityClass;

public class MenuBarPage extends UtilityClass {
	public MenuBarPage() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//span[text()='currency_exchange']")
private WebElement curExchange;

@FindBy(xpath="//span[text()='History by Store']")
private WebElement historyByStore;

@FindBy(xpath="//span[text()='Transactions']")
private WebElement transactions;

@FindBy(xpath="(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-bn3d1m'])[1]")
private WebElement slideMenu;

public WebElement getCurExchange() {
	return curExchange;
}

public WebElement getHistoryByStore() {
	return historyByStore;
}

public WebElement getTransactions() {
	return transactions;
}

public WebElement getSlideMenu() {
	return slideMenu;
}

public void chargebacks3P() {
	click(getCurExchange());
}
public void HistoryByStore() {
	click(getHistoryByStore());
}

public void Transactions() {
	click(getTransactions());
}

public void slideMenu() throws InterruptedException {
	click(getSlideMenu());
	wait(30);

}





















}
