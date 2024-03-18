      Feature: Login
      
 Background:

      Given  User launch browser 
      When User opens URL "https://samar1.thinkexam.com/admin"
      And  User enters email address "samar@thinkexam.com" and password "Sam@12345"
      And  click on login button 
     
     
      @sanity
      
      Scenario:
Successful Login of the thinkexam with valid creddentials
      
      Then Page tittle should be "Think Exam"
      When click on logout link/button
       And close browser  
      
      @regression
      
 Scenario Outline:

Successful Login of the thinkexam with valid creddentials
      
      And  User enters email address <email> and password <password>
      And  click on login button 
      Then Page tittle should be "Think Exam"
      When click on logout link/button
      Then page title should be "Think Exam"
      And close browser  
      
      Examples:
|email|password|
|samar@thinkexam.com|Sam@12345|
|samar@thinkexam.com|Sam@1234|
|samar1@thinkexam.com|Sam@12345|
     