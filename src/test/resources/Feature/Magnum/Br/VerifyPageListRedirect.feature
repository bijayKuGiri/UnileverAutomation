Feature: Verifying PageList  redirection

  @P0
  @imageNavigation
  @brazil
  @magnum
  Scenario: Verifying PageList redirection
    Given The site is Up and Running
    When i try to click on article image
    Then the page should redirect to Article page