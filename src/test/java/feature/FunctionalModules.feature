Feature: Test Corde Functional modules

Background:
Given Launch the Application 

@self
Scenario: Test Selfhelp Module

#Given Launch the Application to test Selfhelp module
Then Click on Menu Nav to go to the Selfhelp page
Then Click all three tabs  
Then Click all the topics, catgeory and options 


Scenario: Test DocumentListing Module

#Given Launch the Application to test DocumentListing module
Then Click on Menu Nav to go to the DocumentListing page
Then Check Documents heading, paragrapg and size is displayed  
Then Click the download button and check the file is downloaded
Then Click view online and verify file is opened in new tab

@Form
Scenario Outline: Test Form Module

#Given Launch the Application to test Form module
Then Click on Menu Nav to go to the Form page
Then Check the form RTE content is prersent on page1
Then Check Form Heading is displayed
Then Check Page Heading is displayed
Then Enter "<Shortanswer>" values
Then Enter "<Longanswer>" value
Then Select date "<Day>"and "<Month>" and "<Year>" from date picker
Then Click ALL the Multi choice question
Then Check hidden onput field is displayed and enter the "<HiddenInput>" value
Then Select first value from drop down
Then Check the hidden field is displayed after selecting the first dropdown option
Then Click the consent question
Then Click the checkbox
Then Click next button to navigate to next page
Then Check the form RTE content is prersent on page2
Then Upload the PDF file "<file>"
Then Check the title and description is displayed
Then Click previous button to check page navigates to page1
Then Click next button from page1 to navigate to next page2
Then Click Submit to compelete form
Then Check the Form submission message is displayed

Examples:
|Shortanswer|Longanswer|Day|Month|Year|HiddenInput|file|
|Abc|Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.|1|August|2023|HiddenInput|C:\\Users\\rajalakshmiganesan\\Desktop\\Check.xml|

#Negative scenario
@imgs
Scenario: Test Form Module - Negative scenario
#Given Launch the Application to test Neagtive sceanrio Form module
Then Click on Menu Nav to go to the page
Then Click Next button
Then Check the error messages are displayed for mandatory field
Then Check the upload only allow PDF file


Scenario: Test Latest News Module
#Given Launch the Application to test Latest News Module
Then Click on Menu Nav to go to the Latest News Module Page
Then Check the featured article is displayed
Then Check First four articles pulled from news section
Then Check Tags and date are displayed for the article
Then Check Article buttons are displayed
Then Click Article button to check it navigates to new article page

@prop
Scenario: Test Property listing Module
#Given Launch the Application to test Property listing Module
Then Click on Menu Nav to go to the Property listing Module Page
Then Check the Properties are displayed
Then Check image is displayed
Then Check promotion labels,property headings and property details are displayed
Then Click view button to navigate to property page

@imge
Scenario: Test Raw HTML Module

Then Click on Menu Nav to go to the Raw HTML Module Page
Then Check the Raw Html frame is displayed

@New
Scenario: Test News Module

Then Click the news from the menu
Then Check the News listing page is displayed
Then Select the tag and category and Click search
Then Check selected tag article is displayed
Then Check the featured article is displayed
Then Check the article tag,date and CTA are working fine
Then Check Images are displayed on each news article
Then Check Pagination is present on page

@News
Scenario: Test Featured News Module

Then Click the news item from the menu
Then Check the News page is displayed
Then Check Featured article is displayed
Then Check Featured article tag,date and CTA are displayed

