import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

// GlobalVariable : https://docs.katalon.com/display/KD/Variable+Types
// Execution Profile : https://docs.katalon.com/pages/viewpage.action?pageId=13697476
WebUI.navigateToUrl("http://${GlobalVariable.Hostname}/")

// Call test case : https://docs.katalon.com/display/KD/Call+test+case
WebUI.callTestCase(findTestCase('Common/Login'),
	[
		'Username': GlobalVariable.Username,
		'Password': GlobalVariable.Password
	],
	FailureHandling.STOP_ON_FAILURE)

// do some stuff here

WebUI.closeBrowser()