package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.BankAndCashPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardHeaderVerify = exlRead.getCellData("Dashboard", "Varify Header", 2);
	String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	//Add Account

	String accountTitle = "Saving Account";
	String description = "This is where I keep my left over";
	String initialBalance ="$525000";
	String accountNumber = "256485698";
	String contactPerson = "Bintu Camus";
	String internetBankingUrl = "https://techfios.com/billing/?ng=accounts/add/";
	
	@Test(priority=1)
	public void validUserShouldBeAbleToAddCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clikSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderVerify);
		
		
		
		
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.validateAddContactPage("Customers"); //Add Contact
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();
		
		dashboardPage.clickListCustomerMenuButton();
		
		addContactPage.varifyInsertedNameAndDelete();
		addContactPage.clickOkayButton();
		//addContactPage.clickSaveButton();
		
		
	}
	//@Test(priority=2)
	public void validUserShouldBeAbleToAddAccount() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clikSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(dashboardHeaderVerify);
		dashboardPage.clickBankAndCashMenuButton();
		dashboardPage.clickBankAndCashMenuButton();
		
		BankAndCashPage bankAndCashPage = PageFactory.initElements(driver, BankAndCashPage.class);
		bankAndCashPage.insertAccountTitle(accountTitle);
		bankAndCashPage.insertDescription(description);
		bankAndCashPage.insertInitialBalance(initialBalance);
		bankAndCashPage.insertAccountNumber(accountNumber);
		bankAndCashPage.insertContactPerson(contactPerson);
		bankAndCashPage.insertPhone(phone);
		bankAndCashPage.insertinternetyBankingUrl(internetBankingUrl);
		bankAndCashPage.clickOnSubmitButton();
		//bankAndCashPage.validateAccountCreatedSuccessfullyPage(accountBalance);
		bankAndCashPage.accountCreatedSuccessfullyMessage();
		


}


}
