package uipages;

import org.openqa.selenium.*;
import utilities.CommonEvents;

import java.util.concurrent.TimeUnit;

public class FlightsPage {
    WebDriver driver = CommonEvents.getDriver();
    StaysPage sp = new StaysPage();
   String newDay = sp.newDate();



    //locator for get flights link
    private By getTravelOptions = By.xpath("//div[@id='gc-custom-header-tool-bar-shop-menu']");
    //locator for get flights
    private By getFlightslink = By.xpath("//a[@href='/Flights']");
    //locator for return option
    private By getReturnOption = By.xpath("//*[@id=\"uitk-tabs-button-container\"]/div[1]/li[1]");
    //locator for leaving from
    private By getOriginField = By.xpath("//button[@aria-label='Leaving from']");
    //locator for selecting Origin
    private By getOriginOption = By.xpath("//li[1]//button[1]");
    //div[@class='uitk-tabs-content']//li[1]
    //locator for going to
    private By getDestinationField = By.xpath("//button[@aria-label='Going to']");
    //locator for selecting going to option
    private By getDestinationOption = By.xpath("//*[@id=\"app-layer-location-field-leg1-destination-ta-dialog\"]/div[2]/div/div[2]/ul/li[1]/button");
    //locator for departure text
    private By getDepartureText = By.xpath("//span[@class='title-city-text']");
    //locator for return flight test
    private By getReturnText = By.xpath("//span[@class='title-city-text']");
    //locator for selecting departure flight
    private By getDepartureFlight = By.xpath("//*[contains(@id, '"+newDay+"')]//button[@type='button']");
    //locator for selecting return flight
    private By getReturnFlight = By.xpath("//*[contains(@id, '"+newDay+"')]//button[@type='button']");



    //method for get travel link
    public void setTravelOptions(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(getTravelOptions).click();
    }
    //method for get flights link
    public void setFlightsLink(){
        driver.findElement(getFlightslink).click();
    }
    //method for get return option
    public void setReturnOption(){
        driver.findElement(getReturnOption).click();
    }
    //method for selecting origin
    public WebElement setOrigin(){
        driver.findElement(getOriginField).click();
        return null;
    }
    //method for selecting origin
    public WebElement setOriginOption(){
        driver.findElement(getOriginOption);
        return null;
    }
    //method for selecting departure flight
    public void selectDepartureFlight(){
        System.out.println("flightDate::"+newDay);
        driver.findElement(getDepartureFlight).click();
    }
    //method for selecting return flight
    public void selectReturnFlight(){
        driver.findElement(getReturnFlight).click();
    }

    //method for getting departure flight text
    public String getDepartureFlightText(){
        String getDepartureFlightText = driver.findElement(getDepartureText).getText();
        return String.valueOf(getDepartureFlightText);

    }

    //method for getting return flight text
    public String getReturnFlightText(){
        String getReturnFlightText = driver.findElement(getReturnText).getText();
        return String.valueOf(getReturnFlightText);

    }

    public void enterOrigin(String origin){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement originButton = driver.findElement(getOriginField);
        originButton.sendKeys(origin);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement originOption =  driver.findElement(getOriginOption);
        originOption.click();

    }
    public void enterDestinatin(String dest){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement destinationButton = driver.findElement(getDestinationField);
        destinationButton.sendKeys(dest+ "\n");
        /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement destinationOption =  driver.findElement(getDestinationOption);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        destinationOption.click();*/
    }

}
