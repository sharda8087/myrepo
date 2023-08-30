@A&GInquiryWithExcel
Feature: A&G Inquiry form

  Background: Launch the browser and navigate to Member search page
    Given Launch Browser and Navigate to website
    When User enter username and valid password
      | username               | password     |
      | shardha.sharma@ust.com | Sharda1234# |
      
    And click on signin button
    Then Navigate to Home page
    When clicks on the navigate icons
    And clicks on member search menu

  @A&GInquiryScenarioExternal
  Scenario Outline: Navigate A&G inquiry page and fill the details
    Given Collect the details from sheet "<sheetName>" and  rowNum <rowNum>
    Given user enter the member id
    And click on Search button
    When Clicks on validate Member button
    And Validate member verification popup is displayed
    Then Select case origin and select Inbound Phonecall
    And select member type
    And Verify member verification pop
    When Select 4 member options
    Then Clicks on Verify button
      | memberType |
      | Member     |
    When Clicks on A&G Inquiry button
    When Validate whether A&G inquiry page is open
    Then Validate Member Name
    When Enter value on Appeals_Grievances ID
    Then Validate Primary Reason
    And Select Secondary Reason value
    When Select Tertiary Reason value
    And Validate Route to Department text
    And Click Mark as Complaint?
    And Select Value from Mark as Complaint
    And Select member Priority
    And Enter value in member Subject
    And Enter value in member Description
    And Click on Save Button
    Then Print Case Id rowNum <rowNum>
    #Then Write Case Id in Excel

    Examples:
      | sheetName      | rowNum |
      | A&G Inquiry    | 0      |
      | A&G Inquiry    | 1      |
     # | A&G Inquiry    | 2      |
      #| A&G Inquiry    | 3      |
      #| A&G Inquiry    | 4      |
      #| A&G Inquiry    | 5      |
      #| A&G Inquiry    | 6      |
      #| A&G Inquiry    | 7      |
      #| A&G Inquiry    | 8      |
      #| A&G Inquiry    | 9      |
      #| A&G Inquiry    | 10     |
      #| A&G Inquiry    | 11     |
      #| A&G Inquiry    | 12     |
      #| A&G Inquiry    | 13     |
      