package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjectAddCandidate {

	WebDriver ldriver ;
	public PageObjectAddCandidate(WebDriver rdriver) {
		ldriver = rdriver ;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath = "//a[normalize-space()='Add New Candidate']")
	WebElement Candidate ;
	@FindBy(id = "email")
	WebElement email ;
	@FindBy(id = "name")
	WebElement name ;
	@FindBy(id = "mobile")
	WebElement mobile ;
	@FindBy(id = "course")
	WebElement group ;
	@FindBy(name = "emailSend")
	WebElement sendemail ;
	@FindBy(id = "saveStudent")
	WebElement save ;

	public void AddCandidate() throws InterruptedException {
		Thread.sleep(3000);
		Candidate.click();
		
	}
	public void Addemail(String eml) throws InterruptedException {
		Thread.sleep(3000);
		email.click();
		email.sendKeys(eml);
	}
	public void AddName(String naam) throws InterruptedException {
		Thread.sleep(2000);
		name.click();
		name.sendKeys(naam);
		}
public void AddMobile(long number) {
mobile.click();
mobile.sendKeys(String.valueOf(number));
}
public void AddGroup(String course) {
group.click();
Select sc = new Select(group);
sc.selectByVisibleText(course);
}
public void SendEmail() {
sendemail.click();	
}
public void SaveInput() {
save.click();
}
}



