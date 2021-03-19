package com.lufthansa.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lufthansa.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public TestUtil() throws IOException {
		super();

		// TODO Auto-generated constructor stub
	}
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static Workbook workbook = null;
	public static Sheet sheet = null;
	public static Row row = null;
	public static Map<String, String> map = null;
	
	
	
	public void switchToNewTab()
	{
		 String currentwindow = driver.getWindowHandle();
		 Set<String> allWindows = driver.getWindowHandles();
	      Iterator<String> i = allWindows.iterator();
	      while(i.hasNext()){
	         String childwindow = i.next();
	         if(!childwindow.equalsIgnoreCase(currentwindow)){
	            driver.switchTo().window(childwindow);
	            System.out.println("The child window is "+childwindow);
	         } else {
	            System.out.println("There are no children");
	         }
	      }
		
	}
	
	
	

	public static Map<String,String> getLufthansaTestData() throws IOException {
		try {
			
			FileInputStream fileInputStream = new FileInputStream("D:\\eclipse workspace\\LufthansaAutomationTest\\src\\main\\java\\com\\lufthansa\\qa\\testdata\\LufthansaTestData.xlsx");
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheetAt(0);
			row = sheet.getRow(0);
			int colCount = row.getLastCellNum();
			
			map = new HashMap<String, String>();
			
			for(int i=0; i<colCount; i++) {
				map.put(sheet.getRow(0).getCell(i).toString().trim(), sheet.getRow(1).getCell(i).toString().trim());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
		return map;
	}
	
	
	public static void explicitWaitUntilElementClickable(WebElement element)
	{
		System.out.println("inside wait");
		    WebDriverWait wait = new WebDriverWait(driver,30);
		   wait.until(ExpectedConditions.elementToBeClickable(element));
		    
	}
	
	

}
