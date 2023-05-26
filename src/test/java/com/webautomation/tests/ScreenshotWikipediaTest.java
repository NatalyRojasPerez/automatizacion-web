package com.webautomation.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;


public class ScreenshotWikipediaTest {
	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/chromedriver/chromedriver.exe";
	private String URL = "https://www.wikipedia.org";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Realizar un screenshot de la página de la Wikipedia.");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	
	@Before
	public void setUpBefore(){
		
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	@Test
	public void testSearch() {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		String outputPath = "C:\\Users\\NATALY\\Pictures/screenshot.png";
		
		try {
            Files.copy(screenshotFile,new File(outputPath));
            System.out.println("Screenshot guardado correctamente en: " + outputPath); 
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el screenshot.");
        }

	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
}
