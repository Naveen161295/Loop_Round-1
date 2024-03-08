package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass  extends TestContextSetup{
	
	public void getDriver(String browser)  {
		
		
			
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().clearDriverCache().setup();
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if (browser.equalsIgnoreCase("Firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else if (browser.equalsIgnoreCase("ie")) {
					WebDriverManager.iedriver().setup();
					driver=new InternetExplorerDriver();
				}
				else {
					System.out.println("Invalid browser. Unable to launch");
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
	}

	//To get URL
	public void getUrl() {
		try {
			driver.get("https://app.tryloop.ai/login/password");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//find element and locators
		public WebElement find_Element_Locators(String locators, String id) {
			WebElement find_Element=null;
			try {
				if (locators.equalsIgnoreCase("id")) {
					find_Element = driver.findElement(By.id(id));
				}
				else if (locators.equalsIgnoreCase("name")) {
					find_Element=driver.findElement(By.name(id));
				}
				else if (locators.equalsIgnoreCase("xpath")) {
					 find_Element = driver.findElement(By.xpath(id));
				}
				else if (locators.equalsIgnoreCase("tagName")) {
					find_Element = driver.findElement(By.tagName(id));
				}
				else if (locators.equalsIgnoreCase("className")) {
					find_Element = driver.findElement(By.className(id));
				}
				else if (locators.equalsIgnoreCase("cssSelector")) {
					find_Element = driver.findElement(By.cssSelector(id));
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			return find_Element;
		} 


//To pass the values (Send keys)
	public void send_Keys(WebElement element, String data) {
		try {
			element.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//To click the button (Click)	
	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void actions(WebElement element, String method) {
		Actions action=new Actions(driver);
		try {
			if (method.equalsIgnoreCase("movetoElement")) {
				action.moveToElement(element).perform();
			}
			else if (method.equalsIgnoreCase("darganddrop")) {
				action.dragAndDrop(element, element).perform();
			}
			else if (method.equalsIgnoreCase("context_click")) {
				action.contextClick(element).perform();
			}
			else if (method.equalsIgnoreCase("double_click")) {
				action.doubleClick(element).perform();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

//To get the text
	public String get_Text(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}

	public void wait(int time) throws InterruptedException {
		time=time*1000;
		Thread.sleep(time);
	}
		
//To get a data from excel
		public String getDataFromExcel(String pathName, String SheetName,int rowNo,int cellNo) {
			String value=null;
			try {
				File file=new File(pathName);
				FileInputStream inputStream=new FileInputStream(file);
				Workbook book=new XSSFWorkbook(inputStream);
				Sheet sheet = book.getSheet(SheetName);
				Row row = sheet.getRow(rowNo);
				Cell cell = row.getCell(cellNo);
				int cellType = cell.getCellType();
				if (cellType==1) {
					value = cell.getStringCellValue();
				}
				else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
					value=dateFormat.format(dateCellValue);
				}
				else {
					double numericCellValue = cell.getNumericCellValue();
					long l=(long)numericCellValue;
					value = String.valueOf(l);
				}
				FileOutputStream outputStream=new FileOutputStream(file);
				book.write(outputStream);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return value;
		}
	
	
//To create a new sheet in particular location.
	public String dataToExcel(String data,String location, String sheetName, int rowNo,int cellNo) {
		try {
			File file=new File(location);
			FileInputStream inputStream=new FileInputStream(file);
			Workbook workBook=new XSSFWorkbook(inputStream);
			Sheet sheet = workBook.createSheet(sheetName);
			Row row = sheet.createRow(rowNo);
			Cell cell = row.createCell(cellNo);
			cell.setCellValue(data);
			FileOutputStream outputStream =new FileOutputStream(file);
			workBook.write(outputStream);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheetName;
	}
	
	
	//To set a data to excel
		public String getDataToExcel(String pathName, String sheetName,int rowNo,int cellNo,String method) {
			String text=null;
			try {
				File file=new File(pathName);
				FileInputStream inputStream=new FileInputStream(file);
				Workbook workBook=new XSSFWorkbook(inputStream);
				Sheet sheet = workBook.createSheet(sheetName);
				Row row = sheet.createRow(rowNo);
				row.createCell(cellNo);
				List<WebElement> tRows = driver.findElements(By.tagName("tr"));
				for (int i = 0; i < tRows.size(); i++) {
					WebElement rows = tRows.get(i);
					List<WebElement> tDatas = rows.findElements(By.tagName("td"));
					for (int j = 0; j < tDatas.size(); j++) {
						WebElement datas = tDatas.get(j);
						 text = datas.getText();
						if (method.equalsIgnoreCase("order_no")) {
							System.out.println(text);
						}
					}
					
				}
				FileOutputStream outputStream=new FileOutputStream(file);
				workBook.write(outputStream);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return text;
		}	
		public WebElement getToDataToExcel(String data, String pathName, String sheetName,int rowNo,int cellNo,WebElement element) {
			
			try {
				File file=new File(pathName);
				FileInputStream inputStream=new FileInputStream(file);
				Workbook workBook=new XSSFWorkbook(inputStream);
				Sheet sheet = workBook.createSheet(sheetName);
				Row row = sheet.createRow(rowNo);
				Cell cell = row.createCell(cellNo);
				String attribute = element.getAttribute("value");
				cell.setCellValue(attribute);
				FileOutputStream outputStream=new FileOutputStream(file);
				workBook.write(outputStream);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return element;
			
		}
		
		
		
}
