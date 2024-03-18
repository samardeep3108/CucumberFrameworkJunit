package StepDefinition;

import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.PageObjectAddCandidate;
import PageObject.PageObjectLoginPage;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public ReadConfig rd ;
	public WebDriver driver;
	public PageObjectLoginPage PageObjectLoginPage ; 
	public PageObjectAddCandidate PageObjectAddCandidate ;
	public static Logger log ;
	
public String generateemailid() {
	return(RandomStringUtils.randomAlphanumeric(7));
}



}


