package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class BankAndCashPage extends AddContactPage {
	WebDriver driver;

	public BankAndCashPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	WebElement BANK_AND_CASH_HEADER_ELEMENT;// (By.partialLinkText("Bank & Cash"))
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Account']") //// *[@id="side-menu"]/li[10]/ul/li[1]/a
	WebElement NEWACCOUNT_ELEMENT;// By.partialLinkText("New Account"))
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/div[2]/div/h2")
	WebElement ACCOUNTS_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account']") // "//input[@id='account']"
	WebElement ACCOUNT_TITLE_ELEMENT;
	@FindBy(how = How.ID, using = "description")
	WebElement DESCRIPTION_ELEMENT;

	@FindBy(how = How.ID, using = "balance")
	WebElement INITIAL_BALANCE_ELEMENT;
	@FindBy(how = How.ID, using = "account_number")
	WebElement ACCOUNT_NUMBER_ELEMENT;

	@FindBy(how = How.ID, using = "contact_person")
	WebElement CONTACT_PERSON_ELEMENT;

	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement PHONE_ELEMENT;

	@FindBy(how = How.ID, using = "ib_url")
	WebElement INTERNET_BANKING_URL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Submit']")
	WebElement SUBMIT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement ACCOUNT_CREATED_SUCCESSFULLY_ELEMENT;

	public void clickOnBankAndCashMenu() {
		BANK_AND_CASH_HEADER_ELEMENT.click();
	}

	public void clickOnNewAccountMenu() {
		NEWACCOUNT_ELEMENT.click();

	}

	public void insertAccountTitle(String accountTitle) {
		ACCOUNT_TITLE_ELEMENT.sendKeys(accountTitle + generateRandomNo(999));
	}

	public void insertDescription(String description) {
		DESCRIPTION_ELEMENT.sendKeys(description + generateRandomNo(999));
	}

	public void insertInitialBalance(String initialBalance) {
		INITIAL_BALANCE_ELEMENT.sendKeys(initialBalance + generateRandomNo(999));
	}

	public void insertAccountNumber(String accountNumber) {
		ACCOUNT_NUMBER_ELEMENT.sendKeys(accountNumber + generateRandomNo(999));
	}

	public void insertContactPerson(String contactPerson) {
		CONTACT_PERSON_ELEMENT.sendKeys(contactPerson + generateRandomNo(999));
	}

	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(999));
	}

	public void insertinternetyBankingUrl(String internetBankingUrl) {
		INTERNET_BANKING_URL_ELEMENT.sendKeys(internetBankingUrl + generateRandomNo(999));
	}

	public void clickOnSubmitButton() {
		SUBMIT_ELEMENT.click();
	}

	public void validateAccountCreatedSuccessfullyPage(String accountCreatedSuccessfully) throws InterruptedException {
		Thread.sleep(2000);

		Assert.assertEquals(ACCOUNT_CREATED_SUCCESSFULLY_ELEMENT.getText(), accountCreatedSuccessfully, "Wrong Page!!");
	}

	public void accountCreatedSuccessfullyMessage() {
		System.out.println("Account Created successfully, Thank Author @Sidiki");
	}

}
