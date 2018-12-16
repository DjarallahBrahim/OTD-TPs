package test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import org.apache.commons.io.FileUtils;

import static org.junit.Assert.*;

import org.junit.*;

public class TestScript_without_alert {
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

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }
        new WebDriverWait(driver, 1000).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d) {
			   return d.findElement(By.id("res")).isDisplayed();
			}
        });

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_same_curr.png"));
	
		assertEquals(driver.findElement(By.id("res")).getText(),"Result : 44 (EUR)");
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

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
       
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

		assertEquals(driver.findElement(By.id("res")).getText(),"Result : 34 (EUR)");
		new File("/tmp/screenshot_add_equiv_curr.png").delete();
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

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Devises incompatibles : EUR vs DA");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
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

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Result : 20 (EUR)");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
    }

    @Test
    public void test_sub_diff_curr() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("25");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("5");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("DA");


        driver.findElement(By.xpath("//select/option[2]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Devises incompatibles : EUR vs DA");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
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

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Make sure that v1 > v2 : 5 - 10");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
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

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Result : 25 (EUR)");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
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
        element.sendKeys("DA");


        driver.findElement(By.xpath("//select/option[3]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getText(),"Devises incompatibles : EUR vs DA");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
    }


    /**
     * Test Colors
     * @throws java.io.IOException
     */
    @Test
    public void test_green_color() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("8");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("8");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("EUR");


        driver.findElement(By.xpath("//select/option[3]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getCssValue("color"),"rgb(13, 255, 88)");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
    }

    @Test
    public void test_red_color() throws java.io.IOException{
        driver.get("http://localhost:8080/src/index.html");

        WebElement element = driver.findElement(By.name("v1"));
        element.sendKeys("8");

        element = driver.findElement(By.name("c1"));
        element.sendKeys("EUR");

        element = driver.findElement(By.name("v2"));
        element.sendKeys("8");

        element = driver.findElement(By.name("c2"));
        element.sendKeys("DZ");


        driver.findElement(By.xpath("//select/option[3]")).click();
        //element.submit(); dans index.html on a utilisé inpute de type button
        element = driver.findElement(By.xpath("//input[@type='button']"));
        element.click();

        //We do not test here alert
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {

        }

        new WebDriverWait(driver, 3000).until(ExpectedConditions.presenceOfElementLocated(By.id("res")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/tmp/screenshot_add_equiv_curr.png"));

        assertEquals(driver.findElement(By.id("res")).getCssValue("color"),"rgb(255, 0, 0)");
        new File("/tmp/screenshot_add_equiv_curr.png").delete();
    }
}
