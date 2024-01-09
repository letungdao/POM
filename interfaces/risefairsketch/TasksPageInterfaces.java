package risefairsketch;

public class TasksPageInterfaces {

	public static final String DROPDOWNLISTS = "//label[normalize-space(text())='%s']/following-sibling::div//a";
	public static final String COMBOBOX = "//label[normalize-space(text())='%s']/following-sibling::input";
	public static final String OPTIONS = "//div[@id='select2-drop']//li[contains(.,'%s')]";
	public static final String BTN_ADDTASK = "//div[@class='title-button-group']//a[@title='Add task']";
	public static final String TXB_TITLE = "//input[@name='title']";
	public static final String TXA_DESCRIPTION = "//textarea[@name='description']";
	public static final String TXB_STARTDATE = "//input[@name='start_date']";
	public static final String TXB_DEADLINE = "//input[@name='deadline']";
	public static final String BTN_SAVE = "//button[contains(@class,'btn-primary')]";
	public static final String PUP_MODAL = "//form[@id='task-form']";
	public static final String TXB_SEARCH = "//div[@id='task-table_filter']//input[@placeholder='Search']";
	public static final String LNK_VIEWTASK = "//table//tr[1]//a[contains(@title,'Task info')]";
	public static final String PUP_INFOTASK = "//div[@id='ajaxModal']//div[@class='modal-content']";

}
