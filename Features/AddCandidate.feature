Feature: Add Candidate

Background:
      Given  User launch browser 
      When User opens URL "https://samar1.thinkexam.com/admin"
      And  User enters email address "samar@thinkexam.com" and password "Sam@12345"
      And  click on login button 

@sanity

Scenario: To add caniddate in the panel while providing all the inputs

      Then Page tittle should be "Think Exam"
      When Clicked on Add new candidate
      Then Page title should be "Think Exam"
      When Provide candidate details 
      And Select send email check box
      And click on save button 
      Then Page title should be similar to the "Think Exam"
      When click on logout link/button
      Then page ttitle should be "Think Exam"
      And  close browser 
                 

           
