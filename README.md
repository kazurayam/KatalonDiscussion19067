Running a Katalon Test Case for different URLs: an running demo
=====

## What is this?

This is a simple Katalon Studio project for demonstration purpose.
You can clone this out on your PC and execute it with your Katalon Studio.

This project is developed to propose a solution for the following discussion
in the Katalon Forum:

- https://forum.katalon.com/discussion/comment/19067

Question raised there was:

> How can I run the same test case for different URLs?
> Hi, I have several identical web pages hosted on different URLs. Can I create one test case and run it for these pages (in automatic mode)? If possible, the test case should be stored on the server and the scan must be performed on the server on a schedule.

I developed this demo using Katalon Studion version 5.4.2

## How to run the demo

1. clone the project `KatalonDiscussion19067` to your PC
2. open the project with your Katalon Studio
3. select the test case `Main/Basic`
4. run the test case with your favirite openBrowser
5. the Main/Basic test case should run successfull.

## Description

In the Katalon test case, you will specify values of `Hostname`, `Username` and `Password` anyway. Specify the values as reference to GlobalVarialbes. The following snippet shows how:
```
WebUI.navigateToUrl("http://${GlobalVariable.Hostname}/")
```

You want to create multiple [Execution Profiles](https://docs.katalon.com/pages/viewpage.action?pageId=13697476): `default`, `production`, `development`.
In each Profile you want to define GlobalVariables. The GlobalVariables are used to specify values for Hostname, Username and Password variables :

| Execution Profile | GlobalVariable name | value               |
| default      | Hostname            | demoaut.katalon.com |
|              | Username            | John Doe            |
|              | Password            | ThisIsNotAPassword  |

| Execution Profile | GlobalVariable name | value               |
| production   | Hostname            | demoaut.katalon.com |
|              | Username            | John Doe            |
|              | Password            | ThisIsNotAPassword  |

| Execution Profile | GlobalVariable name | value               |
| development  | Hostname            | demoaut-mimic.kazurayam.com |
|              | Username            | foo            |
|              | Password            | bar  |


Prior to running test cases, you need to select which Execution Profile to apply to the test case run. I explained the operation in the comment https://forum.katalon.com/discussion/comment/19067
