Feature: Test Corde Page

@Stat
Scenario: Test Accordion Module

Given Launch the Application corde
Then Click on Menu Nav to go to the accordion page
Then Check the accordion list
Then Check Tab lists

@Stat
Scenario: Test Quick Links Module

Given Launch the corde
Then Click on Menu Nav to go to the Quick Links page
Then Check quick link image and text
Then Check quick link items

@Stat
Scenario: Test Text Snippet Module

Given Launch the corde App
Then Click on Menu Nav to go to the Text Snippet page
Then Check Heading and summary items

@Stat
Scenario: Test Rich Text Editor  Module

Given Launch the Application
Then Click on Menu Nav to go to the RTE page
Then Check RTE Heading items

@Stat
Scenario: Test Quote  Module

Given Launch the Application to test Quote module
Then Click on Menu Nav to go to the Quote page
Then Check Quote items

@Stat
Scenario: Test Statistics Module

Given Launch the Application to test Statistics module
Then Click on Menu Nav to go to the Statistics page
Then Check  Statistics number heading and link

@Video
Scenario: Test Video Module

Given Launch the Application to test video module
Then Click on Menu Nav to go to the video page
Then Click  Video play button and check if its playing
Then close the video

@Stat
Scenario: Test Features Module

Given Launch the Application to test Features module
Then Click on Menu Nav to go to the Features page
Then Check all the icons are displayed
Then Check Features CTAs working fine

@Social
Scenario: Test Social Module

Given Launch the Application to test Social module
Then Click on Menu Nav to go to the Social page
Then Check all the Socialicons are displayed
Then Check Social CTAs working fine

@List
Scenario: Test Listing Module

Given Launch the Application to test Listing module
Then Click on Menu Nav to go to the Listing page
Then Check all the Listings are displayed
Then Check Listing pagination working fine

@Grid
Scenario: Test Grid Module

Given Launch the Application to test Grid module
Then Click on Menu Nav to go to the Grid page
Then Check primary grid items  are displayed
Then Check secondary grid items  are displayed
Then Check the grid with link and without links in















