package uipages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonEvents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class StaysPage {

    WebDriver driver = CommonEvents.getDriver();

    JavascriptExecutor js = (JavascriptExecutor) driver;


    //locator for going to
    By destination = By.xpath("//button[@aria-label='Going to']");
    //locator for stays
    By stay = By.xpath("//li[contains(@class,'active')]//a[@role='tab']");
    //locator for check-in
    By fromDate = By.xpath("//div[contains(@class,'uitk-flex uitk-flex-row uitk-flex-gap-three uitk-flex-item uitk-date-fields uitk-flex-grow-1')]//div[1]//div[1]//div[1]");
    //locator for search button
    By searchButton = By.xpath("//button[normalize-space()='Search']");
    //locator for serachtext
    By searchText = By.xpath("//button[@aria-label='e.g. Best Western']");
    //locator for first search result
    By firstSearchResult = By.xpath("//*[@id=\"app-layer-base\"]/div/div/div/div[1]/main/div[2]/div/div[2]/section[2]/ol/li[1]");
    //locator for first search result text
    By getFirstSearchResultText = By.xpath("//*[@id=\"app-layer-base\"]/div/div/div/div[1]/main/div[2]/div/div[2]/section[2]/ol/li[1]/h3");
    //locator for first search result text in new tab after selecting
    By selectedFirstSearchResultText = By.xpath("//*[@id=\"app-layer-base\"]/div/div/div/div[1]/main/div[1]/div[3]/div/div[1]/div[1]/h1");
    //locator for hotelResult
    By hotelResult = By.xpath("//h3[@class='truncate-lines-2 all-b-padding-half pwa-theme--grey-900 uitk-type-heading-500'][normalize-space()='Ibis Budget St Peters']");
    //locator for selected hotel name
    By selectedHotelName = By.xpath("//h1[normalize-space()='Ibis Budget St Peters']");



    //method to enter going to
    public void enterGoingTo(String goingTo){
        WebElement textbox = driver.findElement(destination);
        textbox.sendKeys(goingTo + "\n");
    }
    //method to select stays
    public void selectStays(){
        driver.findElement(stay).click();
    }
    //method to select checkinDate
    public void selectFromDate(){
        driver.findElement(fromDate).click();
    }
    //method to click search button
    public void searchButton(){
        driver.findElement(searchButton).click();
    }
    //method to enter search text
    public void enterSearchText(String text){
        driver.findElement(searchText).sendKeys(text + "\n");
    }
    //method for selecting first search result
    public void selectHotelResult(){
        driver.findElement(firstSearchResult).click();
    }
    //method for getting hotel result Name
    public String hotelName(){
        WebElement hotelName = driver.findElement(hotelResult);
        return String.valueOf(hotelName);
    }
    public String selectedHotelName(){
        WebElement selectHotelName = driver.findElement(selectedHotelName);
        return String.valueOf(selectHotelName);
    }
    //method for getting first hotel name
    public String getFirstHotel(){
        String getFirstHotelName = driver.findElement(getFirstSearchResultText).getText();
        return String.valueOf(getFirstHotelName);

    }
    //method for selected hotel name
    public String selectedFirstHotel(){
        String selectedFirstHotel = driver.findElement(selectedFirstSearchResultText).getText();
        return String.valueOf(selectedFirstHotel);
    }

    public  void datepicker(){
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));
        Calendar c1 = Calendar.getInstance();
        c1.setTime(currentDate);
        c1.add(Calendar.DAY_OF_YEAR, 2);
        String newDate = dateFormat.format(c1.getTime());
        System.out.println("todays date is "+ newDate);

        driver.findElement(fromDate).click();
        driver.findElement(By.xpath("//div[contains(@class,'uitk-date-picker date-picker-menu')]")).click();
        //driver.findElement(By.xpath("//td[contains(@class,'uitk-date-picker-day-number startSelected')]")).sendKeys(newDate);
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[contains(@aria-label,'16 Apr. 2021.')]")).click();
        driver.findElement(By.xpath("//button[contains(@aria-label,'19 Apr. 2021.')]")).click();
        driver.findElement(By.xpath("//button[contains(@class,'uitk-button uitk-button-small uitk-button-has-text uitk-button-primary uitk-flex-align-self-flex-end uitk-flex-item uitk-flex-shrink-0 dialog-done')]")).click();

    }


}
