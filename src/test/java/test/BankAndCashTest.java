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


public class BankAndCashTest extends AddContactTest{
	
		WebDriver driver;
		String accountTitle = "Saving Account";
		String description = "This is where I keep my left over";
		String initialBalance ="$525000";
		//String accountNumber = "256485698";
		String contactPerson = "Bintu Camus";
		String phone = "215487548";
		//String internetBankingUrl = "https://techfios.com/billing/?ng=accounts/add/";
       @Test
		public void validUserShouldBeAbleToAddAccount() throws InterruptedException {
			
			driver = BrowserFactory.init();
			
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.insertUserName(userName);
			loginPage.insertPassword(password);
			loginPage.clikSigninButton();
			
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.validateDashboardPage(dashboardHeaderVerify);
			dashboardPage.clickBankAndCashMenuButton();
			dashboardPage.clickNewAccountButton();
			
			BankAndCashPage bankAndCashPage = PageFactory.initElements(driver, BankAndCashPage.class);
			bankAndCashPage.insertAccountTitle(accountTitle);
			bankAndCashPage.insertDescription(description);
			bankAndCashPage.insertInitialBalance(initialBalance);
			bankAndCashPage.insertAccountNumber(accountNumber);
			bankAndCashPage.insertContactPerson(contactPerson);
			bankAndCashPage.insertPhone(phone);
			bankAndCashPage.insertinternetyBankingUrl(internetBankingUrl);
			bankAndCashPage.clickOnSubmitButton();
			//bankAndCashPage.validateAccountCreatedSuccessfullyPage();
			bankAndCashPage.accountCreatedSuccessfullyMessage();
			


}
}

