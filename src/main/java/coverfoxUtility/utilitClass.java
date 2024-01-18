package coverfoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class utilitClass 
{
	public static String readDataExcell(int row,int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Getting data from excell", true);
		Reporter.log("reading data from excell", true);
		FileInputStream mfile=new FileInputStream("D:\\SOFTWARE TESTING\\Automation\\Selenium\\ExcellSheet\\plant materials.xlsx");
		Sheet msheet = WorkbookFactory.create(mfile).getSheet("Sheet2");
		String data=msheet.getRow(row).getCell(cell).getStringCellValue();
		
		return data;
			}
	
	public static void screenShot(WebDriver driver,String tcid) throws IOException
	{	
		Reporter.log("taking ScreenShot", true);
		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\SOFTWARE TESTING\\Automation\\Selenium\\TestNg"+tcid+"_"+Timestamp+".png");
		Reporter.log("saved screenshot at"+dest, true);
		FileHandler.copy(src, dest);
	}
	}
