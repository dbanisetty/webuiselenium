== WebUI tests with selenium webdriver  ==

# prerequisites
Java
apache maven installed
set java home and m2 home in system env variables


# run in cli
mvn clean test

# run specific scenario(by tag name)
mvn clean verify -Dcucumber.options="--tags @@hotels-search"

# run from IDE
simple click on run icon or right click on "TestRunner" class and select run option

# reporting
used plain cucumber html reports

# Test summary
Framework tests the ability of selecting flights and hotels with destinations being parameterised
can run for multiple destinations by simply extending cucumber scenarios into "Scenario Outline" data tables
utilised page object model with getters, setters and methods to invoke step definitions



#Limitations
- noticed chromedriver and chrome browser version mismatch could end up in not loading browser until chromedriver version is matched
  . brew cask upgrade chromedriver - this command will upgrade chromedriver
- Occasionally tests fails with NoClassDefFoundError
  . please re-run the tests if you see failure in first trail
  . this can be addresses with robust selectors( tried to use xpath) and utilising implicit waits, which requires multiple iterations of test runs
