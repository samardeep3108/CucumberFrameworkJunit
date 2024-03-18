package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObjectLoginPage {

	WebDriver ldriver ;
	public PageObjectLoginPage(WebDriver rdriver){
		ldriver = rdriver ;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(id="loginId")
	WebElement email ;

	@FindBy(id = "password")
	WebElement password ;
	@FindBy(id="loginSubmit2")
	WebElement login ;
	@FindBy(xpath ="//a[@class=\\\"lgout\\\"]")
	WebElement Admin ;
	@FindBy(xpath="//span[@class=\"flatibtn lgot\"]")
	WebElement logout ;
	public void enterEmail(String em) {
		email.clear();
		email.sendKeys(em);
	}

	public void enterpassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);

	}	
	public void loginbutton() {
		login.click();
	}
	public void homepage() throws InterruptedException {
		Thread.sleep(3000);
		Admin.click();
	}
	public void logOut() throws InterruptedException {
		Thread.sleep(3000);
		logout.click();
	}
}






