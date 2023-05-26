package com.webautomation.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaSearchTest {
	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/chromedriver/chromedriver.exe";
	private String URLWikipedia = "https://www.wikipedia.org";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Buscar el link de la Wikipedia resultante.");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	
	@Before
	public void setUpBefore(){
		
		driver = new ChromeDriver();
		driver.get(URLWikipedia);
	}
	
	@Test
	public void testSearch() {
		WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();		
      
        WebElement searchResultLink = driver.findElement(By.xpath("//a[@href='/wiki/Selenium']"));
        if (searchResultLink.isDisplayed()) {
            System.out.println("El enlace de Wikipedia fue encontrado.");
        } else {
            System.out.println("El enlace de Wikipedia no fue encontrado.");
        }
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
}
