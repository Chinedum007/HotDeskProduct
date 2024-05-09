package BookWise.Solution.HotDeskProduct.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseTest implements BookWise.Solution.HotDeskProduct.generic.AutoConstants{
	public WebDriver driver;//chromeBrowser
	public BookWise.Solution.HotDeskProduct.generic.WebActionUtil webActionUtil;//Object is stored
	
	@Parameters({"browserName", "appUrl", "implicitTO","explicitTO"})
	@BeforeClass
	public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
						@Optional(DEFAULT_URL)String appUrl,
						@Optional(ITO)String implicitTO,
						@Optional(ETO)String explicitTO) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("Edge")) {
			System.setProperty(EDGE_KEY, EDGE_PATH);
			driver = new EdgeDriver();	
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver = new FirefoxDriver();	
		}
		else {
			throw new IllegalArgumentException();
		}
		
		driver.manage().window().maximize();
		long impTO=Long.parseLong(implicitTO);
		long expTO=Long.parseLong(explicitTO);
		driver.manage().timeouts().implicitlyWait(impTO, TimeUnit.SECONDS);
		driver.get(appUrl);
		webActionUtil = new BookWise.Solution.HotDeskProduct.generic.WebActionUtil(driver, expTO);
	}
	
	@Parameters({"userNameId","passwordId"})
	@BeforeMethod
	public void loginToApp(@Optional(DEFAULT_USER)String userNameId,
						   @Optional(DEFAULT_PWD)String passwordId) {
		BookWise.Solution.HotDeskProduct.pages.LoginPage Ip= new BookWise.Solution.HotDeskProduct.pages.LoginPage(driver, webActionUtil);
		Ip.login(userNameId, passwordId);
	}
		
	
	@AfterMethod
	public void logout(ITestResult result) throws Exception {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			BookWise.Solution.HotDeskProduct.generic.CaptureScreenshot.getImage(driver, result.getName());
		}
		Thread.sleep(5000);
		BookWise.Solution.HotDeskProduct.pages.SignOutPage sp= new BookWise.Solution.HotDeskProduct.pages.SignOutPage(driver, webActionUtil);
		sp.LogOut();
		Reporter.log("LogOut from page", true);
		//HomePage hp = new HomePage(driver, webActionUtil);
		//hp.signOut();
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
		Reporter.log("Close Browser", true);
	}


}
