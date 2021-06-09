package uipages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.CommonEvents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class StaysPage {

    WebDriver driver = CommonEvents.getDriver();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    String newDay;
    String toDate;


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
    public String newDate(){
    DateFormat dateFormat = new SimpleDateFormat("dd");
    Date currentDate = new Date();
    System.out.println(dateFormat.format(currentDate));
    Calendar c1 = Calendar.getInstance();
    c1.setTime(currentDate);
    c1.add(Calendar.DAY_OF_YEAR, 1);
    String newDate = dateFormat.format(c1.getTime());
    System.out.println("from date is "+ newDate);
    return newDate;
    }

    public String futureDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date currentDate = new Date();
        System.out.println(dateFormat.format(currentDate));
        Calendar c1 = Calendar.getInstance();
        c1.setTime(currentDate);
        c1.add(Calendar.DAY_OF_YEAR, 3);
        String futureDate = dateFormat.format(c1.getTime());
        System.out.println("To date is "+ futureDate);
        return futureDate;
    }

    public  void datepicker(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(fromDate))).click();

        newDay = newDate();
        toDate = futureDate();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label, '"+newDay+" Apr. 2021')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@aria-label, '"+toDate+" Apr. 2021')]"))).click();
        driver.findElement(By.xpath("//button[contains(@class,'uitk-button uitk-button-small uitk-button-has-text uitk-button-primary uitk-flex-align-self-flex-end uitk-flex-item uitk-flex-shrink-0 dialog-done')]")).click();

        //div[@id='c20660']//div[2]//ul[1]//li[1]//a[1]

        //div[@id='c19846']//div[@class='news-list-view']//ul[@class='list_style_1']//li[2]//div[1]//div[2]//div[1]//a//span
        // div[@id='c19846']//div[@class='news-list-view']//ul[1]//li[1]//div[1]//div[2]//div[1]//a//span

    }

    public void getElementsByColor(){
        String expectedBlue = "";
        String eleColor = driver.findElement(By.xpath("")).getCssValue("color");
        String eleHexColor = Color.fromString(eleColor).asHex();
        Assert.assertEquals(expectedBlue, eleHexColor);
    }

    public void scrollByfunc(){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollIntoView(){
        WebElement ele = driver.findElement(By.xpath(""));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);
        ele.getText();
    }

   public void setWindow(){
        Dimension dm = new Dimension(1020, 780);
        driver.manage().window().setSize(dm);
   }


   //login page - w0, page A - w1, page B - w2, pageC - w3
    public  void multipleWindows(Integer tab_index){
        String parentWindow = driver.getWindowHandle();
        WebElement submit = driver.findElement(By.xpath(""));
        submit.click();
        Set<String> pageAwindow = driver.getWindowHandles();
        driver.switchTo().window((String) pageAwindow.toArray()[1]);
        WebElement pageAbutton = driver.findElement(By.xpath(""));
        pageAbutton.click();
        Set<String> pageBwindow = driver.getWindowHandles();
        driver.switchTo().window((String)pageBwindow.toArray()[2]);
        WebElement pageBbutton = driver.findElement(By.xpath(""));
        pageBbutton.click();
        Set<String> pageCwindow = driver.getWindowHandles();
        driver.switchTo().window((String)pageCwindow.toArray()[3]);
        driver.switchTo().window(parentWindow);

    }

    public void multipleWindowsWithRemove(){
     String parentWindow = driver.getWindowHandle();
        WebElement submit = driver.findElement(By.xpath(""));
        submit.click();

        Set<String> pageA = driver.getWindowHandles();
        pageA.remove(parentWindow);
        driver.switchTo().window((String)pageA.toArray()[0]);
        WebElement pageAbutton = driver.findElement(By.xpath(""));
        pageAbutton.click();

        Set<String> pageB = driver.getWindowHandles();
        pageB.removeAll(pageA);
        driver.switchTo().window((String)pageB.toArray()[0]);
        WebElement pageBbutton = driver.findElement(By.xpath(""));
        pageBbutton.click();

        Set<String> pageC = driver.getWindowHandles();
        pageC.removeAll(pageB);
        driver.switchTo().window((String)pageC.toArray()[0]);
        WebElement pageCbutton = driver.findElement(By.xpath(""));
        pageCbutton.click();

    }

    public void tableRowCol(){

        WebElement table = driver.findElement(By.xpath("/table/tbody"));
        //get rows of table
        List<WebElement> table_rows = table.findElements(By.tagName("/tr"));
        //calculate rows in table
        int row_count = table_rows.size();
        for(int row =0; row<row_count; row++){
           List<WebElement> col_rows = table_rows.get(row).findElements(By.tagName("/td"));
           int col_count = col_rows.size();
           for(int col=0; col<col_count; col++){
               String celText = col_rows.get(col).getText();
               String cellItem = driver.findElement(By.xpath("")).getText();
               if(cellItem.contains("VALUE")){
                  String specificItem = driver.findElement(By.xpath("//table[@id=''table]/tbody/tr/td[1]")).getText();
                   System.out.println(specificItem);
                  break;

               }

           }
        }
    }

    public void specificTableValue(){

        //get table xpath
        WebElement myTable = driver.findElement(By.tagName("//table/tbody"));
        //get table rows
        List<WebElement> table_rows = myTable.findElements(By.tagName("/tr"));
        //get row count
        int row_count = table_rows.size();
        //iterate thru rows
        for(int row = 0; row<row_count; row++){
            //get columns from each row
            List<WebElement> table_columns = table_rows.get(row).findElements(By.tagName("/td"));
            //get columns count
            int col_count = table_columns.size();
            //print no:of columns in specific row
            System.out.println("number of cells in row" + row + "are" + col_count);
            //iterate thru columns
            for(int col=0; col<col_count; col++){
                String cellText = table_columns.get(col).getText();
                //print values of column
                System.out.println("cell number"+ table_columns + "cell text" + cellText );
            }
        }

    }
   /* List<WebElement> rows = driver.findElements(By.cssSelector("table.table_results tr"));
for (WebElement row: rows) {
        List<WebElement> cells = row.findElements(By.cssSelector("td.data"));
        for (WebElement cell: cells) {
            System.out.println(cell.getText());
        }
    }*/

}
