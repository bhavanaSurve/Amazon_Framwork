package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	static String  data;
//int sonal branch change;
	String "new";
	
// for take screen shot
	public static void captureScreenShot(String testId,WebDriver driver) throws IOException
	{
		// this is predifine class in java import from java.text in constructor pass our formate
			SimpleDateFormat mydate =new SimpleDateFormat("dd MM yyyy HH mm ss");//here we provide our formate so in which date will show
		//need to create object of date class this class provide the current date. import java.util
			Date date = new Date();
		//so current date we print in our formate in below using formate method 
			String d = mydate.format(date);
		 // System.out.println(d);
		
		TakesScreenshot take = (TakesScreenshot)driver;
		File src             = take.getScreenshotAs(OutputType.FILE);
		File dest            = new File("C:\\Users\\Admin\\Documents\\Amazone\\screenShot\\Test_"+testId+""+d+".png");
		FileHandler.copy(src, dest);// this line  copy src image and past dest location
	}
	

	public static String getDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String path = "C:\\Users\\Admin\\Documents\\Amazone\\excell\\Amazon.xlsx";
		FileInputStream file = new FileInputStream(path);
		Cell cellNum = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell);
		try 
		{
			 data = cellNum.getStringCellValue();
		}
		catch(Exception e)
		{
			int a  = (int)cellNum.getNumericCellValue();//upcast double to int
			String str=Integer.toString(a);//covert int to string
			//String str = (int) Double.parseDouble(String.valueOf(a)) + "";//both work		
			data = str;
			
		}
		return data;
	}
}
