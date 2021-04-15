== WebUI tests with selenium webdriver  ==

# prerequisites
Java
apache maven installed
set java home and m2 home in system env variables


# run in cli
mvn clean test

# run specific scenario(by tag name)
mvn clean verify -Dcucumber.options="--tags @@hotels-search"

# reporting
using serenity BDD report. report will be generated after execution at below location
bdd-offers-service\target\site\serenity\index.html