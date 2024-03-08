This README file provides an overview and guidelines for setting up and using Cucumber integrated with TestNG along with the Page Object Model (POM) framework for automated testing.

Table of Contents
=> Introduction
=> Prerequisites
=> Folder Structure
=> Conclusion

Introduction:
==============
Cucumber is a popular tool for Behavior Driven Development (BDD) which allows us to write acceptance tests in a natural language style. TestNG is a testing framework that can be integrated with Cucumber to manage test cases, execute them in a specific order, and generate reports. The Page Object Model (POM) is a design pattern that helps in creating maintainable and scalable test automation frameworks.
This project combines the power of Cucumber, TestNG, and the Page Object Model to create a robust testing framework for automated testing.

Prerequisites:
==============
=> Java Development Kit (JDK) installed
=> Maven installed
=> Eclipse
=> Basic understanding of Java, Cucumber, TestNG, and Page Object Model
=> Install required dependencies using Maven (pom.xml).

Folder Structure:
=================

src
├── main
│   └── java
│     
└── test
    ├── java
    │   └── StepDefinition File
    │   └── TestRunner File
    │   └── TextContext File
    │   └── Utility File
    ├── resources
        └── features
            └── DataVerification.feature

'src/test/java': Contains source code files and test files including Step Defintion and Test Runner files
          1.) Step Definition File:
                => Step definitions are written in Java and map the steps defined in feature files to executable code.
                => In this step Definition file, the test cases are converted into methods and the methods are placed in this file. The methods are organized as per the page wise setup for our convinence.
                => Hooks Class have Before and after annotations which have launching the browser and URL and quit the browser after the execution is done.
                => Other classes like loginstepdef, withinpagestepdef etc., have an methods that are relatable to the classes for execution.
          2.) Test Runner File:
                => Test Runner File is used for execution. For executing this testNG framework cucumber options tag is used. In cucumber options, we have feature, monochrome, dryRun, glue keywords are used.
                => AbstractTestNGCucumberTests is a predefined class used to execute the TestNG framework.
          3.) Text Context file:
                => This package is used to maintain our locators for each page using page Object Model (POM). Once the execution starts from test Runner Class, moved into stepdefinition class.
                => In this step definition class, a method created in the text context file is called using object which was created in the step definition class.
                => Page Object Model (POM) is implemented to represent web pages as Java classes. Each page class contains locators and methods to interact with elements on that page.
                => Page Object Model is used to maintain the locators for that particular page by using the private webelement which prevents the overriding of same locators in the another page.
                => By using POM with Page factory concepts, we can initialize all the elements present in that page anywhere by using driver. "this" keyword is used as chain link constructor.
          4.) Utility File:
                => Utility class have reusable predefined methods. A predefined methods have been reused again and again. This will reduce the line of code and we can use this reusable code whenever we want.
                => TestContextSetup class have variable initialization. A variable is declared as public static, because the variable can be called by any method and it can be used anywhere. Example: the value of variable col1 is taken from 
                textContext file is stored in this textcontextsetup and this value compared/used in step definition file say assert condition.
  'src/test/resources': Contains feature files written in Gherkin syntax.
          1.)DataVerification.feature:
                => The feature file have 2 scenarios such as data verification and data validation.
                => Features are written in Gherkin syntax in .feature files. These files describe the behavior of the application in simple, human-readable language.

Conclusion:
===========
  => Cucumber integrated with TestNG along with the Page Object Model provides a powerful framework for automated testing. 
  => It enables collaboration between technical and non-technical team members, ensures test reusability, and maintains code readability. 
  => With proper setup and organization, this framework can greatly enhance the efficiency and reliability of your testing process.
