package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
public DashboardPage(WebDriver driver) {
		this.driver =  driver;
	}
	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]") WebElement CUSTOMERS_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]") WebElement ADD_CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customers')]") WebElement LIST_CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	WebElement BANK_AND_CASH_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using ="//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement NEWACCOUNT_ELEMENT;//By.partialLinkText("New Account"))
	 @FindBy(how = How.XPATH, using ="//*[@id='page-wrapper']/div[2]/div/h2")
	  WebElement ACCOUNTS_HEADER_ELEMENT;
	
	public void validateDashboardPage(String dashboard) {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), dashboard, "Wrong Page!!!");
	}
	public void clickBankAndCashMenuButton() {
		BANK_AND_CASH_HEADER_ELEMENT.click();
	}
	public void clickNewAccountButton() {
		NEWACCOUNT_ELEMENT.click();
	}
	public void clickAccountHeaderButton() {
		ACCOUNTS_HEADER_ELEMENT.click();
	}
		
	public void clickCustomerMenuButton() {
		CUSTOMERS_MENU_ELEMENT.click();
	}
	
	public void clickAddCustomerMenuButton() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickListCustomerMenuButton() throws InterruptedException {
		Thread.sleep(3000);
		LIST_CUSTOMER_MENU_ELEMENT.click();
	}
	


}
