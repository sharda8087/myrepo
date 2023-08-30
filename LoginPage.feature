@FeatureLoginPage
Feature: Login functionlity

  Scenario Outline: SignIn with with valid credentials
    Given Launch Browser and Navigate to website
    When User enter username "<username>" and valid password "<password>"
    And click on signin button
    Then Navigate to Home page

    Examples: 
      | username               | password     |
      | shardha.sharma@ust.com | Sharda1234# |
     # | amala.ravichandran@ust.com.coadev | Salesforce@123 |
    
