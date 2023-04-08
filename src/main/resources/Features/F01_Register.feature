@regression
Feature: Register user into magento Website
   Background: User is in Magento home page
     Given User Navigate to home page

  Scenario Outline: User registration scenarios
    When User Click on Account icon
    And Click on Register from dropdown displayed
    And Enter "<fname>" "<lname>" "<email>" "<password>" "<re_password>"
    And Check NewsLetter
    And Click on Register button
    Then "<Message>"
    Examples:
      |    fname      |   lname |             email         |   password  |    re_password    |                                                                   Message                                                                                  |
      |               |         |                           |             |                   |                                                           This is a required field.                                                                        |
      |   mahmoud     |   ali   |           m@m.m           |   P@ssow0rd |      P@ssow0rd    |                              Please enter a valid email address. For example johndoe@domain.com.                                                           |
      |   mahmoud     |   ali   | mahmoudali2911@icloud.com |   P@ssow0rd | different Pssow0rd|                                                   Please make sure your passwords match.                                                                   |
      |   mahmoud     |   ali   | mahmoudali2911@icloud.com |      min    |         min       |                                  Please enter 6 or more characters. Leading or trailing spaces will be ignored.                                            |
      |   mahmoud     |   ali   |     test@icloud.com   |   P@ssw0rd  |    P@ssw0rd       |                                           Thank you for registering with Madison Island.                                                                   |
      |   mahmoud     |   ali   | mahmoudali2911@icloud.com |   P@ssw0rd  |    P@ssw0rd       |There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.|

#Scenario: User register successfully
#  When User Click on Account icon
#  And Click on Register from dropdown displayed
#  And Enter "mahmoud" "ali" "mahmoudali2911@icloud.com" "P@ssw0rd" "P@ssw0rd"
#  And Check NewsLetter
#  And Click on Register button
#  Then Success message: "Thank you for registering with Madison Island."
#
#
#
#Scenario: Register with already Existing email
#  When User Click on Account icon
#  And Click on Register from dropdown displayed
#  And Enter "mahmoud" "ali" "mahmoudali2911@icloud.com" "P@ssw0rd" "P@ssw0rd"
#  And Check NewsLetter
#  And Click on Register button
#  Then Fail: "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."