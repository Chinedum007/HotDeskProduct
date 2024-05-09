package BookWise.Solution.HotDeskProduct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BookWise.Solution.HotDeskProduct.generic.WebActionUtil;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
		
	}
	@FindBy(id="Username")
	private WebElement userNameTextField;
	
	@FindBy(id="Password")
	private WebElement passwordTextField;
	
	@FindBy(id="LoginButton")
	private WebElement logOnButton;
	
	public void login(String userNameId, String passwordId) {
		webActionUtil.enterData(userNameTextField, userNameId);
		webActionUtil.enterData(passwordTextField, passwordId);
        webActionUtil.clickOnElement(logOnButton);
}
}