Feature: Test Corde Content modules
Background:
Given Launch the Application 

Scenario: Test Accordion Module

Then Click on Menu Nav to go to the accordion page
Then Check the accordion list
Then Check Tab lists

@Content
Scenario: Test Quick Links Module

Then Click on Menu Nav to go to the Quick Links page
Then Check quick link image and text
Then Check quick link items

@Content
Scenario: Test Text Snippet Module

Then Click on Menu Nav to go to the Text Snippet page
Then Check Heading and summary items


Scenario: Test Rich Text Editor  Module
Then Click on Menu Nav to go to the RTE page
Then Check RTE Heading items

@Content
Scenario: Test Quote  Module

Then Click on Menu Nav to go to the Quote page
Then Check Quote items

@stat
Scenario: Test Statistics Module

Then Click on Menu Nav to go to the Statistics page
Then Check  Statistics number heading and link

@video
Scenario: Test Video Module

Then Click on Menu Nav to go to the video page
Then Click  Video play button and check if its playing
Then close the video

@Content
Scenario: Test Features Module

Then Click on Menu Nav to go to the Features page
Then Check all the icons are displayed
Then Check Features CTAs working fine

@Content
Scenario: Test Social Module

Then Click on Menu Nav to go to the Social page
Then Check all the Socialicons are displayed
Then Check Social CTAs working fine

@Listing
Scenario: Test Listing Module

Then Click on Menu Nav to go to the Listing page
Then Check all the Listings are displayed
Then Check Listing pagination working fine

@img2
Scenario: Test Grid Module

Then Click on Menu Nav to go to the Grid page
Then Check primary grid items  are displayed
Then Check secondary grid items  are displayed
Then Check the grid with link and without links in















