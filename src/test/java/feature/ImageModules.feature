Feature: Test Corde Image modules


Background:
Given Launch the Application 


Scenario: Test Image Text Module

Then Click on Menu Nav to go to the Image text page
Then Check Image is displayed 
Then Check Heading,summary and CTA are displayed


Scenario: Test Large Image Module

Then Click on Menu Nav to go to the Large Image page
Then Check Large Image is displayed 
Then Check Large Image Heading,summary and CTA are displayed


Scenario: Test Logo Rotator Module

Then Click on Menu Nav to go to the Logo Rotator page
Then Check Logo Rotator Images are displayed 
Then Check Logo Rotator Heading,summary and CTA are displayed


Scenario: Test Gallery Thumbnail Module

Then Click on Menu Nav to go to the Gallery Thumbnail page
Then Check Gallery Thumbnail Images and click expand and click arrows to navigate the images
Then Click expand on image and check its expanded

Scenario: Test Grid Layout Module

Then Click on Menu Nav to go to the Grid Layout page
Then Check Grid Child pages 
Then Check Grid Manual pages
Then Check Grid Picker pages


Scenario: Test Image Gallery Module

Then Click on Menu Nav to go to the Image Gallery page
Then Check Images,summary and pagination 

@imgs
Scenario: Test Header and Footer section

Then Check the header logo is displayed and clickable
Then Click the child items of the menu
Then Check the footer logo is displayed and clickable
Then Check all footer links are working
Then Check footer social are working
Then Check the footer has corprate message with link



Scenario: Test Map Module

Then Click on Menu Nav to go to the Map page
Then Check Map frame is displayed
Then Click Map location 
Then Check the pop up content and close it

