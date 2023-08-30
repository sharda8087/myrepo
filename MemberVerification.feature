@FeatureMemberPage
Feature: Member verification with member ID and member type

  Background: Launch the browser and navigate to Member search page
    Given Launch Browser and Navigate to website
    When User enter username and valid password
    
    | username              | password    |
    | shardha.sharma@ust.com| Sharda1234# |
    #| amala.ravichandran@ust.com.coadev | Salesforce@123 |
    
    And click on signin button
    Then Navigate to Home page
    When clicks on the navigate icons
    And clicks on member search menu

  @ScenarioMemberType
  Scenario Outline: Validate member with member type
    Given user enter the "<memberID>"
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

    Examples:
   | memberID|
    |200004221-01|
   
   
   
   @ScenarioNonMemberType
  Scenario Outline: Validate member with non member type
     Given user enter the "<memberID>"
    And click on Search button
    When Clicks on validate Member button
    And Validate member verification popup is displayed
    Then Select case origin and select Inbound Phonecall
    And select non member type
    And Verify member verification pop
    When Select 4 member options
    Then Clicks on Verify button
      | memberType |
      | Member |

     Examples:
       | memberID|
      |200004221-01|
    

