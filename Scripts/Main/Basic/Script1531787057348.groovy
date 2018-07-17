import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

WebUI.openBrowser('')

// GlobalVariable : https://docs.katalon.com/display/KD/Variable+Types
// Execution Profile : https://docs.katalon.com/pages/viewpage.action?pageId=13697476
WebUI.navigateToUrl("http://${GlobalVariable.Hostname}/")

WebUI.callTestCase(findTestCase('Common/Login'),
	[
		'Username': GlobalVariable.Username,
		'Password': GlobalVariable.Password	
	],
	FailureHandling.STOP_ON_FAILURE)

//
WebUI.selectOptionByValue(findTestObject('Page_CuraAppointment/select_Tokyo CURA Healthcare C'),
	'Hongkong CURA Healthcare Center', 
    true)

WebUI.click(findTestObject('Page_CuraAppointment/input_hospital_readmission'))

WebUI.click(findTestObject('Page_CuraAppointment/input_programs'))

// reserve the day one week later than today
def visitDate = LocalDateTime.now().plusWeeks(1)
def visitDateStr = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(visitDate)
WebUI.setText(findTestObject('Page_CuraAppointment/input_visit_date'), visitDateStr)

WebUI.setText(findTestObject('Page_CuraAppointment/textarea_comment'), 'This is a comment')

WebUI.click(findTestObject('Page_CuraAppointment/button_Book Appointment'))

// page transition to Confirmation page
WebUI.verifyElementPresent(findTestObject('Page_AppointmentConfirmation/a_Go to Homepage'),
	10, FailureHandling.STOP_ON_FAILURE)

// do verifications you want
// ...

WebUI.click(findTestObject('Page_AppointmentConfirmation/a_Go to Homepage'))

// make sure page transition to Homepage
WebUI.verifyElementPresent(findTestObject('Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

// bye
WebUI.closeBrowser()

