package risefairsketch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;

public class TasksPage extends AbstractPage {
	WebDriver driver;

	public TasksPage(WebDriver driver_) {
		driver = driver_;
	}

	public void clickAddTask() {
		clickToElement(driver, TasksPageInterfaces.BTN_ADDTASK);
	}

	public void selectValueInDropdownlist(String combobox, String value) {
		clickToElement(driver, String.format(TasksPageInterfaces.DROPDOWNLISTS, combobox));
		clickToElement(driver, String.format(TasksPageInterfaces.OPTIONS, value));
	}

	public void selectValueInCombobox(String combobox, String value) {
		clickToElement(driver, String.format(TasksPageInterfaces.COMBOBOX, combobox));
		clickToElement(driver, String.format(TasksPageInterfaces.OPTIONS, value));
	}

	public void inputAllInformation(String title) {

		WebElement txbTitle = findAnElement(driver, TasksPageInterfaces.TXB_TITLE);
		WebElement description = findAnElement(driver, TasksPageInterfaces.TXA_DESCRIPTION);
		WebElement startdate = findAnElement(driver, TasksPageInterfaces.TXB_STARTDATE);
		WebElement deadline = findAnElement(driver, TasksPageInterfaces.TXB_DEADLINE);
		WebElement save = findAnElement(driver, TasksPageInterfaces.BTN_SAVE);

		System.out.println("Input Title data");
		txbTitle.sendKeys(title);

		System.out.println("Input Description data");
		description.sendKeys("Description");

		System.out.println("Select Related to with value Project");
		selectValueInDropdownlist("Related to", "Project");

		System.out.println("Select Project with value Online Course Creation and Launch");
		selectValueInDropdownlist("Project", "Online Course Creation and Launch");

		System.out.println("Select Points with value 1 Point");
		selectValueInDropdownlist("Points", "1 Point");

		System.out.println("Select Milestone with value Release");
		selectValueInDropdownlist("Milestone", "Release");

		System.out.println("Select Assign to with value John Doe");
		selectValueInDropdownlist("Assign to", "John Doe");

		System.out.println("Select Collaborators with value John Doe");
		selectValueInCombobox("Collaborators", "John Doe");

		System.out.println("Select Status with value To do");
		selectValueInDropdownlist("Status", "To do");

		System.out.println("Select Priority with value Minor");
		selectValueInDropdownlist("Priority", "Minor");

		System.out.println("Select Labels with value Feedback");
		selectValueInCombobox("Labels", "Feedback");

		System.out.println("Enter Start date");
		startdate.sendKeys("12-12-2020");

		System.out.println("Enter Deadline");
		deadline.sendKeys("12-12-2021");

		System.out.println("Click Save");
		save.click();
	}
	
	public void verifyTaskIsAddedSuccessfully(){
		waitForElementInvisible(driver, TasksPageInterfaces.PUP_MODAL);
//		Assert.assertTrue(driver.findElements(By.xpath(TasksPageInterfaces.PUP_MODAL)).size() < 0);
	}
	
	public void searchWithKeyword(String keyword){
		sendkeyToElement(driver, TasksPageInterfaces.TXB_SEARCH, keyword);
	}
	
	public void clickTaskView(){
		clickToElement(driver, TasksPageInterfaces.LNK_VIEWTASK);
	}
	
	public void verifyInfoTaskPopupDisplays(){
		waitForElementVisible(driver, TasksPageInterfaces.PUP_INFOTASK);
		Assert.assertTrue(driver.findElement(By.xpath(TasksPageInterfaces.PUP_INFOTASK)).isDisplayed());
	}
	
	public void addComments(String comment){
		sendkeyToElement(driver, TasksPageInterfaces.TXA_COMMENT, comment);
		clickToElement(driver, TasksPageInterfaces.BTN_ADDCOMMENT);
	}
	
	public void verifyCommentIsAddedSuccessfully(){
		waitForElementVisible(driver, TasksPageInterfaces.MSG_POSTCOMMENTSUCCESSFULLY);
		Assert.assertTrue(driver.findElement(By.xpath(TasksPageInterfaces.MSG_POSTCOMMENTSUCCESSFULLY)).isDisplayed());
	}

}
