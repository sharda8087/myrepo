@AuthorizationInquiryWithExcel
Feature: Authorization Inquiry form

  Background: Launch the browser and navigate to Member search page
    Given Launch Browser and Navigate to website
    When User enter username and valid password
      | username               | password    |
      | shardha.sharma@ust.com | Sharda1234# |
    And click on signin button
    Then Navigate to Home page
    When clicks on the navigate icons
    And clicks on member search menu
    And user enter the member id
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

  @AuthInquiryScenarioExternal
  Scenario Outline: Navigate Authorization Inquiry page and fill the detail and create a case
    When Clicks on Authorization Inquiry button
    When Validate whether Authorization inquiry page is open
    Then Validate Member Name
    When Enter value on Authorization ID
    Then Validate Primary Reason
    And Select Secondary Reason values
    When Select Tertiary Reason values
    And Validate Route to Department texts
    And Click Mark as Complaints?
    And Select Value from Mark as Complaints
    And Select member Priorityss
    And Enter value in member Subjects
    And Enter value in member Descriptions
    And Click on Save Buttons
    Then Print Case Ids

    Examples: 
      | sheetName             | rowNum |
      | Authorization Inquiry |      0 |
      | Authorization Inquiry |      1 |
      | Authorization Inquiry |      2 |
      | Authorization Inquiry |      3 |
      | Authorization Inquiry |      4 |
      | Authorization Inquiry |      5 |
      | Authorization Inquiry |      6 |
      | Authorization Inquiry |      7 |
      | Authorization Inquiry |      8 |
      | Authorization Inquiry |      9 |
      | Authorization Inquiry |     10 |
      | Authorization Inquiry |     11 |
      | Authorization Inquiry |     12 |
      | Authorization Inquiry |     13 |
