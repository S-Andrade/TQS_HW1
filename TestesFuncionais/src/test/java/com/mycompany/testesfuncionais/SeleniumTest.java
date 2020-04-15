
package com.mycompany.testesfuncionais;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTest {
    
    private WebDriver driver;
    private String baseUrl;
    //private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/sandra/TQS_HW1/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    
    @Test
    public void test() throws Exception {
        driver.get("http://localhost:8080/");
        
        try {
            assertEquals("AirQuality", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        
        Select countries = new Select(driver.findElement(By.id("selected_country")));
        countries.selectByVisibleText("Portugal");
        
        try {
           String URLCountry = driver.getCurrentUrl();
           Assert.assertEquals(URLCountry, "http://localhost:8080/states/Portugal" ); 
        } catch (Error e) {
           verificationErrors.append(e.toString());
        }
        
        Select states = new Select(driver.findElement(By.id("selected_state")));
        states.selectByVisibleText("Aveiro");
        
        try {
           String URLState = driver.getCurrentUrl();
           Assert.assertEquals(URLState, "http://localhost:8080/cities/Portugal/Aveiro" ); 
        } catch (Error e) {
           verificationErrors.append(e.toString());
        }
        
        Select cities = new Select(driver.findElement(By.id("selected_city")));
        cities.selectByVisibleText("Oliveirinha");
        
        try {
           String URLCity = driver.getCurrentUrl();
           Assert.assertEquals(URLCity, "http://localhost:8080/currentAirQuality/Portugal/Aveiro/Oliveirinha" ); 
        } catch (Error e) {
           verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("wtp")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("wpr")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("whu")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("wws")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("wwd")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("wic")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("paqius")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("pmainus")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("paqicn")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
        
        try{
           Assert.assertNotNull(driver.findElement(By.id("pmaincn")));
        } catch (Error e){
            verificationErrors.append(e.toString());
        }
    }
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    
}
