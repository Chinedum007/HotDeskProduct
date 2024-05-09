package generic;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil {

	Actions actions;
	WebDriverWait wait;
	WebDriver driver;
	JavascriptExecutor js;

	
	public WebActionUtil(WebDriver driver, long eto) {
		this.driver=driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver,eto);
		js = (JavascriptExecutor)driver;
		
	}
	
	public void enterData(WebElement target, String textToEnter) {
		target.clear();
		target.sendKeys(textToEnter);
	}
	
	public void clickOnElement(WebElement target) {
		
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	
	public void clickOnImage(WebElement target) {
		wait.until(ExpectedConditions.visibilityOf(target));
		target.click();
	}
	
	public void moveToElement(WebElement target) {	
		actions.moveToElement(target).perform();
	}
	public void moveSlider(WebElement target, int x, int y) {
     actions.dragAndDropBy(target, x, y).release().build().perform();
		actions.click();
	}
	
	public void dragAndDrop(WebElement target, WebElement source) {
		actions.dragAndDrop(source, target).release().build().perform();

	}
	public void rightClickOnElement(WebElement target) {
		actions.contextClick(target).perform();
	}
	
	public void doubleClick(WebElement target) {
		actions.doubleClick(target).perform();
	}
	
	public void jsClick(WebElement target) {
		js.executeScript("arguments[0].click();", target);
	}
	public void jsScroll(WebElement target, int x, int y) {
		js.executeScript("window.scrollBy(x,y);");
}

	public void enterDataUsingJs(WebElement target, String text) {
		js.executeScript("arguments[0].value='"+text+"';", target);
	}
	
	public void switchToFrameAndClick(String indexNameOrId, WebElement target) {
		
		try {
			int index=Integer.parseInt(indexNameOrId);
			driver.switchTo().frame(index);
		} catch (NumberFormatException e) {
			driver.switchTo().frame(indexNameOrId);
		}
		
		target.click();
	}
	
	public void selectByTextInListBox(WebElement target, String text) {
		Select select = new Select(target);
		select.selectByVisibleText(text);
		
	}
	
	public void selectByValueInListBox(WebElement target, String value) {
		Select select=new Select(target);
		select.selectByValue(value);
	}
	public void alertAcceptOrDismiss(boolean accept) {
		if(accept) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}
	
	public boolean verifyAlertText(String expectedAlertText) {
		return driver.switchTo().alert().getText().equals(expectedAlertText);
	}
	
	public void downloadFileUsingAutoIt() {
		try {
			Runtime.getRuntime().exec("./resources/fileDownloadPopUp.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void uploadSampleDocUsingFile() {
		try {
			Runtime.getRuntime().exec("./resources/FileUploadPopUp.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

