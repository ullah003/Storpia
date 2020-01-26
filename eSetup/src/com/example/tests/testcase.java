package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testcase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.1.9:9000/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCase() throws Exception {
    driver.get("http://192.168.1.9:9000");
    driver.findElement(By.id("login_userid")).clear();
    driver.findElement(By.id("login_userid")).sendKeys("admin");
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys("admin");
    driver.findElement(By.cssSelector("input.btn_login")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("icon_esetup"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    
    driver.findElement(By.name("icon_esetup")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//ul[@id='ext-gen121']/li/div/a/span"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//ul[@id='ext-gen121']/li/div/a/span")).click();
    // ERROR: Caught exception [unknown command [for]]
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("button:contains(\"Add\")"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("button:contains(\"Add\")")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("button:contains(\"Next\")"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//input[@id='cuserid']")).clear();
    driver.findElement(By.xpath("//input[@id='cuserid']")).sendKeys("user${i}");
    driver.findElement(By.xpath("//input[@id='cuname']")).clear();
    driver.findElement(By.xpath("//input[@id='cuname']")).sendKeys("user_name${i}");
    driver.findElement(By.xpath("//input[@id='cemail']")).clear();
    driver.findElement(By.xpath("//input[@id='cemail']")).sendKeys("user${i}@gluesys.com");
    driver.findElement(By.xpath("//input[@id='cpassword']")).clear();
    driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("user${i}");
    driver.findElement(By.xpath("//input[@id='cpassword1']")).clear();
    driver.findElement(By.xpath("//input[@id='cpassword1']")).sendKeys("user${i}");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("button:contains(\"Next\")"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("button:contains(\"Next\")")).click();
    driver.findElement(By.cssSelector("button:contains(\"Next\")")).click();
    driver.findElement(By.cssSelector("button:contains(\"Confirm\")")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("button:contains(\"OK\")"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.cssSelector("button:contains(\"OK\")")).click();
    // ERROR: Caught exception [unknown command [endFor]]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
