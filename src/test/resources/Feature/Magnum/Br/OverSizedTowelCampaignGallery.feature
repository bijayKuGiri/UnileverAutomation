Feature: Validate the Campaign Gallery
  @Gallery
  @P0
  @brazil
  @magnum
  @All
  Scenario: Verifying load more for gallery
    Given The site is Up and Running
    And navigate to the video contain tab
    When i click on load more
    Then the more images should load to the page