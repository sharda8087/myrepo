@A&GInquiryFeature
Feature: A&G Inquiry form
  #Ctrl + Alt + L ==== Formatting for feature file or right click on file go to Reformat code

  Background: Launch the browser and navigate to Member search page
    Given Launch Browser and Navigate to website
    When User enter username and valid password
      | username               | password     |
     | shardha.sharma@ust.com | Sharda1234# |
     # | amala.ravichandran@ust.com.coadev | Salesforce@123 |
    And click on signin button
    Then Navigate to Home page
    When clicks on the navigate icons
    And clicks on member search menu

  @scenario1
  Scenario Outline: Navigate A&G inquiry page and fill the details
    Given user enter the memberID "<memberID>"
    And click on Search button
    When Clicks on validate Member button
    And Validate member verification popup is displayed
    Then Select case origin and select Inbound Phonecall
    And select member type
    And Verify member verification pop
    When Select 4 member options
    Then Clicks on Verify button "<memberType>"
    Given Clicks on A&G Inquiry button
    When Validate whether A&G inquiry page is open
    Then Validate Member Name
    When Enter value on Appeals_Grievances ID
    Then Validate Primary Reason
    And Select Secondary Reason value from "<secondaryReason>" dropdown
    When Select Tertiary Reason value from "<tertiaryReason>" dropdown
    And Validate Route to Department text
    And Click Mark as Complaint?
    And Select Value from Mark as Complaint "<markAsComplaint>"?
    And Select Priority
      | priority |
      | High     |
    And Enter value in Subject
      | Subject |
      | Dummy   |
    And Enter value in Description
      | Description               |
      | This is Description value |
    And Click on Save Button
    Then Print Case Id

    @AuthorizationIssue
    Examples: Grv Resolve with Authorization Issue
      | memberID     | memberType | secondaryReason | tertiaryReason      | markAsComplaint |
      | 200004221-01 | Member     | Grv Resolve     | Authorization Issue | No              |

    @DentalbenefitIssue
    Examples: Grv Resolve with Dental benefit Issue
      | memberID     | memberType | secondaryReason | tertiaryReason       | markAsComplaint |
      | 200004221-01 | Member     | Grv Resolve     | Dental benefit Issue | No              |

    @EligibilityIssue
    Examples: Grv Resolve with Eligibility Issue
      | memberID     | memberType | secondaryReason | tertiaryReason    | markAsComplaint |
      | 200004221-01 | Member     | Grv Resolve     | Eligibility Issue | No              |

    @IssueWithProviderOffice
    Examples: Grv Resolve with Issue with Provider Office
      | memberID     | memberType | secondaryReason | tertiaryReason             | markAsComplaint |
      | 200004221-01 | Member     | Grv Resolve     | Issue with Provider Office | No              |

    @MedicalBenefitIssue
    Examples: Grv Resolve with Medical Benefit Issue
      | memberID     | memberType | secondaryReason | tertiaryReason        | markAsComplaint |
      | 200004221-01 | Member     | Grv Resolve     | Medical Benefit Issue | No              |

    @HealthBenefitIssue
    Examples: Grv Resolve with Mental Health Benefit issue
      | memberID     | memberType | secondaryReason | tertiaryReason              | markAsComplaint |
      | 200004221-01 | Member     | Grv Resolve     | Mental Health Benefit issue | No              |


