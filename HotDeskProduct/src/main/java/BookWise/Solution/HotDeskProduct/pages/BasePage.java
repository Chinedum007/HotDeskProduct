package BookWise.Solution.HotDeskProduct.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
	WebDriver driver;
	BookWise.Solution.HotDeskProduct.generic.WebActionUtil webActionUtil;
	public BasePage(WebDriver driver, BookWise.Solution.HotDeskProduct.generic.WebActionUtil webActionUtil) {
		this.driver=driver;
		this.webActionUtil=webActionUtil;
		PageFactory.initElements(driver, this);
	}
}
