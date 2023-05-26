package com.webautomation.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomatedProcessSearchTest {
	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/chromedriver/chromedriver.exe";
	private String URL = "https://www.example.com";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Comprobar en qué año se hizo el primer proceso automático.");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	
	@Before
	public void setUpBefore(){
		
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@Test
	public void testSearch() {
		WebElement link = driver.findElement(By.linkText("More information..."));
        link.click();
             
        WebElement yearElement = driver.findElement(By.xpath("//span[@class='year']"));
        String year = yearElement.getText();
        
        System.out.println("El primer proceso automático se hizo en el año: " + year);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
}
