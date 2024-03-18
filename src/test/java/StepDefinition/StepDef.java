package StepDefinition;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.PageObjectAddCandidate;
import PageObject.PageObjectLoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

//hooks : before ,  after hook for scenario , beforestep/afterstep hook for steps with in the scenario and conditional hook for the tags like @before("@regression") 
public class StepDef extends BaseClass {

	
	@Before
	public void launch_browser() {

		log = LogManager.getLogger("StepDef");
			 rd = new ReadConfig ();
		String browser = rd.getbrowser();

		switch(browser.toLowerCase()) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break ;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "default":
			driver = null ;
			break ;
		}				
		log.info("this is step 1 for launch browser");
	}
	@Given("User launch browser")
	public void user_launch_browser() {
		PageObjectLoginPage = new PageObjectLoginPage(driver);
		PageObjectAddCandidate = new PageObjectAddCandidate(driver);
		log.info("this is step 1 for launch browser");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
		driver.get(URL);
		log.info("this is step 1 for url open");
	}

	@When("User enters email address {string} and password {string}")
	public void user_enters_email_address_and_password(String em, String pwd) {
		PageObjectLoginPage.enterEmail(em);
		PageObjectLoginPage.enterpassword(pwd);
		log.info("this is object initialized");
	}

	@When("click on login button")
	public void click_on_login_button() {
		PageObjectLoginPage.loginbutton();
	}

	@Then("Page tittle should be {string}")
	public void page_tittle_should_be(String ExpectedTitle) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(ExpectedTitle)) {
			Assert.assertTrue(true);//Pass
		}else {
			Assert.assertTrue(false);//Fail
		}
	}

	@When("click on logout link\\/button")
	public void click_on_logout_link_button() throws InterruptedException {
		PageObjectLoginPage.homepage();
		PageObjectLoginPage.logOut();
	}


	@When("Clicked on Add new candidate")
	public void clicked_on_add_new_candidate() throws InterruptedException {

		PageObjectAddCandidate = new PageObjectAddCandidate(driver);
		PageObjectAddCandidate.AddCandidate();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String Expected) {
		String Actual = driver.getTitle();
		if (Actual.equals(Expected)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}


	@When("Select send email check box")
	public void select_send_email_check_box() {
		PageObjectAddCandidate.SendEmail();    	
	}

	@When("click on save button")
	public void click_on_save_button() {
		PageObjectAddCandidate.SaveInput();
	}
	@Then("page ttitle should be {string}")
	public void page_ttitle_should_be(String Expected) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(Expected)) {
			Assert.assertTrue(true);//Pass
		}else {
			Assert.assertTrue(false);//Fail
		}
	}
	@When("Provide candidate details")
	public void provide_candidate_details() throws InterruptedException {
		PageObjectAddCandidate.Addemail(generateemailid()+"@yopmail.com");
		PageObjectAddCandidate.AddName("Cucumber");
		PageObjectAddCandidate.AddMobile(99221198);
		PageObjectAddCandidate.AddGroup("5 march");    
	}

	@Then("Page title should be similar to the {string}")
	public void page_title_should_be_similar_to_the(String Expect) {
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(Expect)) {
			Assert.assertTrue(true);//Pass
		}else {
			Assert.assertTrue(false);//Fail
		}
	}



	@Then("close browser")
	public void close_browser() {
		//driver.quit();
	}
	@After
	public void teardown (Scenario sc) {
		if (sc.isFailed()==true) {


			String Filewithpath = ("C:\\Users\\91890\\eclipse-workspace\\CucumberFrame\\screenShot\\failedSceenshot1.png");
			TakesScreenshot scrnshot = ((TakesScreenshot)driver);
			File srcfile = scrnshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File(Filewithpath);
			try {
				FileUtils.copyFile(srcfile, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}


		driver.quit();
		System.out.println("tear down method");
	}





}
