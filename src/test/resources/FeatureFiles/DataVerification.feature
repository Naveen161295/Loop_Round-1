Feature: Loop Data Verification and Validation

Background:
Given User should enter the login details using "qa-engineer-assignment@test.com" and "QApassword123$"
And User should click the login button
When User should click the 3P Chargebacks

Scenario: Data Verification in Website
When User should click the History By Store path
When User should select the "Reversals" in the dropdown button
Then User should check the Grand Total is the sum of values of each location of each month




Scenario: Data Extraction and Validation
When User should click the Transactions path
And User should filter the location as Artisan Alchemy, Blissful Buffet 
And User should filter the marketplace as Grubhub
Then User should the click the Download button to extract the CSV file.
