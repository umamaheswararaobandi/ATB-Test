Feature: ContactAgileTrailblzerFeature
  This feature deals with contact form with AgileTrailblazer feature of the application

  Scenario: Verify the fields available in the form for Contact ATB
    Given Navigate to AgileTrailblzer page
    And Validate the form has the specified fields
    And Validate Name required field
    And Close the AgileTrailblazer page

    Given Navigate to AgileTrailblzer page
    And Validate Email address required field
    And Close the AgileTrailblazer page

    Given Navigate to AgileTrailblzer page
    And Validate Message field
    And Close the AgileTrailblazer page

    Given Navigate to AgileTrailblzer page
    And Validate Mobile Phone as optional field
    And Close the AgileTrailblazer page

    Given Navigate to AgileTrailblzer page
    And Validate Office Phone as optional field
    And Close the AgileTrailblazer page

   Scenario: Verify the Search functionality

     Given Navigate to AgileTrailblzer page
     And Verify the Search results
     And Close the AgileTrailblazer page



