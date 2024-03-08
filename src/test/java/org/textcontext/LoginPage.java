package org.textcontext;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.UtilityClass;

public class LoginPage extends UtilityClass{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id=":r1:")
	private WebElement username;
	
	@FindBy(id=":r2:")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement Loginbtn;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}

	public void Login(String username, String password) {
		send_Keys(getUsername(), username);
		send_Keys(getPassword(), password);
	}
	public void loginClick() {
		click(getLoginbtn());

	}
}
