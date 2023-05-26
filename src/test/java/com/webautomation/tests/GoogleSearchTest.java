package com.webautomation.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/chromedriver/chromedriver.exe";
	private String URL = "https://www.google.com/";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Buscar en Google la palabra automatización.");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	
	@Before
	public void setUpBefore(){
		
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@Test
	public void testSearch() {
		String txtIngresado = "Automatización";
		WebElement txtSearch = driver.findElement(By.name("q"));
		txtSearch.sendKeys(txtIngresado);
		txtSearch.submit();
		
		String titulo = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if (titulo.contains(txtIngresado)) {
            System.out.println("La palabra “automatización” fue encontrada.");
        } else {
            System.out.println("La palabra “automatización” no fue encontrada.");
        }
	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
	
	
	
}
