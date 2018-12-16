package test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestScript_with_alert {
    WebDriver driver;
    @Before
    public void createDriver() {
        System.setProperty("webdriver.gecko.driver", "/home/samlille/Documents/M2_S1/OTD/TP3/geckodriver");
        driver = new FirefoxDriver();
    }

    @After
    public void freeDriver() {
       driver.quit();
    }

    /**
     * Test ADD OPERATION SCRIPT
     * @throws java.io.IOException
     */
    @Test
    public void test_add_same_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");


        WebElement element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v1"));
        element.sendKeys("22");


        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("22");

        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        //We test here alert

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_same_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Result : 44 (EUR)");
            alert.accept();
        } catch (NoAlertPresentException e) {
            //TODO Log exception
        }



		new File("/tmp/test_add_same_curr.png").delete();
    }
    
    @Test
    public void test_add_equiv_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("12");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");
	
        element = driver.findElement(By.name("v2"));
        element.sendKeys("22");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");

        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_add_equiv_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Result : 34 (EUR)");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
		new File("/tmp/test_add_equiv_curr.png").delete();
    }

    @Test
    public void test_add_diff_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("10");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("22");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("DA");

        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_add_diff_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Devises incompatibles : EUR vs DA");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new File("/tmp/test_add_diff_curr.png").delete();

    }


    /**
     * TEST SUB OPERATION SCRIPT
     * @throws java.io.IOException
     */
    @Test
    public void test_sub_equiv_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("25");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");


        driver.findElement(By.xpath("//select/option[2]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_sub_equiv_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Result : 20 (EUR)");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new File("/tmp/test_sub_equiv_curr.png").delete();

    }

    @Test
    public void test_sub_diff_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("25");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("DOL");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("DA");


        driver.findElement(By.xpath("//select/option[2]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_sub_diff_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Devises incompatibles : DOL vs DA");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new File("/tmp/test_sub_diff_curr.png").delete();

    }

    @Test
    public void test_sub_value_error() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("10");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");


        driver.findElement(By.xpath("//select/option[2]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_sub_value_error.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Make sure that v1 > v2 : 5 - 10");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new File("/tmp/test_sub_value_error.png").delete();

    }

    /**
     * TEST MUL OPERATION SCRIPT
     * @throws java.io.IOException
     */
    @Test
    public void test_mul_equiv_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");


        driver.findElement(By.xpath("//select/option[3]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_mul_equiv_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Result : 25 (EUR)");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new File("/tmp/test_mul_equiv_curr.png").delete();


    }

    @Test
    public void test_mul_diff_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("DZ");


        driver.findElement(By.xpath("//select/option[3]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/test_mul_diff_curr.png"));
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            assertEquals(alert.getText(),"Devises incompatibles : EUR vs DZ");
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new File("/tmp/test_mul_diff_curr.png").delete();

    }
}
