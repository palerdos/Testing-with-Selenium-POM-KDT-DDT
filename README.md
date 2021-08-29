# Testing the browser
This project was created to learn how to build robust and maintainable automation solutions. The task was to create all test cases in with Selenium Webdriver and the implementation of POM, KDT and DDT

![title](seleniumtest.png)

Test cases were created for the following features in both POM and KDT

- Navigation
- Single field & Button
- Two fields & Output
- Checkbox
- Select List
- Radio Buttons

## Running the test suite

You can run the tests from the terminal by navigating to the project directory and running the following command:  
```commandline
mvn clean test
```

## Technical Information and requirements
The tests were run using the following versions:
```text
Project SDK: java 11 version 11.09
Google Chrome: Version 91.0.4472.77 (64-bit)
ChromeDriver: Version 91.0.4472.101
```

If you are using a different version of Google Chrome you need to download the matching ChromeDriver version from https://chromedriver.chromium.org/downloads and replace the ChromeDriver in the project directory.