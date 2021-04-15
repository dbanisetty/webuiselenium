package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import uipages.FlightsPage;
import uipages.StaysPage;
import utilities.CommonEvents;

import java.util.concurrent.TimeUnit;


public class UiStepDefinitions {
     private StaysPage hotel = new StaysPage();
     private FlightsPage flights = new FlightsPage();
     private CommonEvents com = new CommonEvents();
    WebDriver driver = CommonEvents.getDriver();


    @Given("^user navigates to expedia site and selects hotels option$")
    public void i_navigate_to_expedia_site() {
        driver.get("https://www.expedia.com.au/");
        hotel.selectStays();
    }

    @When("^enters destination as \"([^\"]*)\"$")
    public void enters_destination_as(String destination) {
        hotel.enterGoingTo(destination);

    }

    @When("^selects checkin and checkout dates$")
    public void i_select_checkin_and_checkout_dates() {
        hotel.datepicker();

    }

    @Then("^clicks on search button$")
    public void hit_search_button() {
       hotel.searchButton();
    }


    @Then("^selects first option from results list$")
    public void select_first_hotel_from_results_list() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String getFirsthotelName = hotel.getFirstHotel();
        System.out.println("first result::" + getFirsthotelName);
        hotel.selectHotelResult();
        com.windowHandles(1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String selectedFirstHotel = hotel.selectedFirstHotel();
        System.out.println("selected result::" + selectedFirstHotel);
        Assert.assertTrue(getFirsthotelName.equals(selectedFirstHotel));
    }

    @Given("^user navigates to expedia site and selects flights option$")
    public void user_navigates_to_expedia_site_and_selects_flights_option() {
        driver.get("https://www.expedia.com.au/");
        flights.setTravelOptions();
        flights.setFlightsLink();
    }
    @Given("^enters leavingFrom and GoingTo$")
    public void enters_leavingFrom_and_GoingTo()  {
        flights.enterOrigin();
        flights.enterDestinatin();
    }

    @Given("^selects departing and returning dates$")
    public void selects_departing_and_returning_dates() {
        hotel.datepicker();

    }
    @Then("^selects departure and return flights from results list$")
    public void select_return_flight() {
        String departureFlightDescription = flights.getDepartureFlightText();
        System.out.println("departure text::" + departureFlightDescription);
        Assert.assertTrue(departureFlightDescription.contains("Select your departure to Melbourne"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        flights.selectDepartureFlight();
        String returnFlightDescription = flights.getReturnFlightText();
        System.out.println("return text::" + returnFlightDescription);
        Assert.assertTrue(returnFlightDescription.contains("Select your return to Sydney"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        flights.selectReturnFlight();
    }
}
