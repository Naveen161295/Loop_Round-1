package org.textcontext;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.UtilityClass;

public class WithInPage extends UtilityClass {

	public WithInPage() {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//p[text()='Reversals']")
	private WebElement reversals;
	
	@FindBy(id="drilldown-options")
	private WebElement drilldownOptions;

	public WebElement getReversals() {
		return reversals;
	}

	public WebElement getDrilldownOptions() {
		return drilldownOptions;
	}
	
public void reversalsCheck() {
		String text = getReversals().getText();
		if (text.equalsIgnoreCase("Reversals")) {
			System.out.println("The String is Reversals");
		} 
		else {
			System.out.println("The String is not Reversals");
			click(getDrilldownOptions());
			List<WebElement> trows = driver.findElements(By.tagName("li"));
			for (int i = 0; i < trows.size(); i++) {
				WebElement data = trows.get(i);
				String text2 = data.getText();
				if (text2.equalsIgnoreCase("Reversals")) {
					data.click();
				}
			}
		}

	}
	
public void DataVerification() {
		WebElement table = driver.findElement(By.tagName("tbody"));
		boolean displayed = table.isDisplayed();
		System.out.println(displayed);
		List<WebElement> trows = table.findElements(By.tagName("tr"));
		int rowNum = trows.size();
		
		System.out.println("row Size"+ rowNum);
		int colNum = 0;
        if (!trows.isEmpty()) {
            List<WebElement> columns = trows.get(1).findElements(By.tagName("td"));
            colNum = columns.size();
        }
		
		System.out.println("column Size"+ colNum);
		extractCellData(table, rowNum, colNum);
	}
private static void extractCellData(WebElement table, int rowNum, int colNum) {
		
	for (int col = 2; col<=colNum-1; col++) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int row = 1; row <= rowNum-1; row++) {				
			WebElement rowsize = rows.get(row-1);						
			List<WebElement> cells = rowsize.findElements(By.tagName("td"));
			if (cells.size() >=col) {
				String value = cells.get(col-1).getText();
				String subString = value.substring(1);
				float val = Float.parseFloat(subString);
				
				if (col==2) { col1 = col1+ val;}
				else if (col==3) {  col2 = col2+ val;}
				else if (col==4) {	col3 = col3+ val;}
				else if (col==5) {	col4 = col4+ val;}
				else if (col==6) {	col5 = col5+ val;}
				else if (col==7) {	col6 = col6+ val;}
				else if (col==8) {	col7 = col7+ val;}					
			}				
		}	
	}
	System.out.println("===============================");
	System.out.println("Sum of Col1 "+col1);
	System.out.println("Sum of Col2 "+col2);
	System.out.println("Sum of Col3 "+col3);
	System.out.println("Sum of Col4 "+col4);
	System.out.println("Sum of Col5 "+col5);
	System.out.println("Sum of Col6 "+col6);
	System.out.println("Sum of Col7 "+col7);
	
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	WebElement lastRow = rows.get(rows.size()-1);
	List<WebElement> columns= lastRow.findElements(By.tagName("td"));
	for (int i = 1; i < columns.size(); i++) {
        WebElement column = columns.get(i);
        String columnValue = column.getText().trim().replace("$","").replace(",", "");
        if (!columnValue.isEmpty()) {
        float val = Float.parseFloat(columnValue);
        switch (i) {
            case 0: GTcol = val;  break;
            case 1: GTcol1 = val; break;
            case 2: GTcol2 = val; break;
            case 3:	GTcol3 = val; break;
            case 4: GTcol4 = val; break;
            case 5: GTcol5 = val; break;
            case 6: GTcol6 = val; break;
            case 7: GTcol7 = val; break;
        }
        }
    }
	
	System.out.println("==================================");
	System.out.println("Grand Total Col1 "+GTcol1);
	System.out.println("Grand Total Col2 "+GTcol2);
	System.out.println("Grand Total Col3 "+GTcol3);
	System.out.println("Grand Total Col4 "+GTcol4);
	System.out.println("Grand Total Col5 "+GTcol5);
	System.out.println("Grand Total Col6 "+GTcol6);
	System.out.println("Grand Total Col7 "+GTcol7);
	System.out.println("==================================");
	
	try { assertEquals(GTcol1, col1, "The values of Sum of Col1: "+col1+ " is not matched with Grand Total col1: "+GTcol1); }
	catch (AssertionError e) {	System.out.println("Assertion failed: "+ e.getMessage()); }
	
	try { assertEquals(GTcol2, col2, "The values of Sum of Col2: "+col2+ " is not matched with Grand Total col2: "+GTcol2); }
	catch (AssertionError e) {	System.out.println("Assertion failed: "+ e.getMessage()); }
	
	try { assertEquals(GTcol3, col3, "The values of Sum of Col3: "+col3+ " is not matched with Grand Total col3: "+GTcol3); }
	catch (AssertionError e) {	System.out.println("Assertion failed: "+ e.getMessage()); }
	
	try { assertEquals(GTcol4, col4, "The values of Sum of Col4: "+col4+ " is not matched with Grand Total col4: "+GTcol4); } 
	catch (AssertionError e) {  System.out.println("Assertion failed: "+ e.getMessage()); }
	
	try { assertEquals(GTcol5, col5, "The values of Sum of Col5: "+col5+ " is not matched with Grand Total col5: "+GTcol5); }
	catch (AssertionError e) {	System.out.println("Assertion failed: "+ e.getMessage()); }
	
	try { assertEquals(GTcol6, col6, "The values of Sum of Col6: "+col6+ " is not matched with Grand Total col6: "+GTcol6); }
	catch (AssertionError e) {	System.out.println("Assertion failed: "+ e.getMessage()); }
	
	try { assertEquals(GTcol7, col7, "The values of Sum of Col7: "+col7+ " is not matched with Grand Total col7: "+GTcol7); }
	catch (AssertionError e) {	System.out.println("Assertion failed: "+ e.getMessage());	}
	}
		
}
