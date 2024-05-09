package BookWise.Solution.HotDeskProduct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BookWise.Solution.HotDeskProduct.generic.WebActionUtil;

public class SignOutPage extends BasePage {

	public SignOutPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	
	}
	@FindBy(xpath="//a[@href='/HotDeskChin/Account/LogOff']")
	private WebElement logOffButton;
	
	public void LogOut() {
		webActionUtil.clickOnElement(logOffButton);
	}
}
