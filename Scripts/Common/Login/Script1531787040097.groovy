import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.verifyElementPresent(findTestObject('Page_CuraHomepage/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_CuraHomepage/a_Make Appointment'))

// Call test case : https://docs.katalon.com/display/KD/Call+test+case
// 'Username' and 'Password' are defined as Variables of the Login test case.
WebUI.setText(findTestObject('Page_Login/input_username'), Username)

WebUI.setText(findTestObject('Page_Login/input_password'), Password)

WebUI.click(findTestObject('Page_Login/button_Login'))

// make sure transition to Page_CuraAppointment succeeded
WebUI.verifyElementPresent(findTestObject('Page_CuraAppointment/button_Book Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)