package com.ias.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ias.Base;

public class ExecutionReport extends Base{

	public static String[] Screenshotnames = new String[100];
	public static int array_increment =0;
	public static String fileLocation;
	 public static void main(String[] args) {
		 try {
			 int i;
			 for (i=1;1<=12;i+=2) {
				 if(i==8)
				System.out.println(i);
				
			}
			/*
			 * try { launchBrowser("chrome"); getUrl("https://outlook.office.com/mail/");
			 * captureScreenShot(driver, Screenshotnames[array_increment++]="SS1");
			 * Thread.sleep(5000); captureScreenShot(driver,
			 * Screenshotnames[array_increment++]="SS2"); quitBrowser();
			 * saveScreenshotToWord("doc1",Screenshotnames);
			 * 
			 */			 /*
			 FileOutputStream out = new FileOutputStream("C:\\Users\\50171\\Desktop\\Report\\doc1.docx");

	            for (int counter = 1; counter <= 5; counter++) {
	                captureScreenShot(Base.driver, "doc");
	                TimeUnit.SECONDS.sleep(1);
	            }

	            docx.write(out);
	            out.flush();
	            out.close();
	            docx.close();

	      */  } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	 public static void saveScreenshotToWord(String name, String[] screenshotnames) throws IOException {

		 System.out.println(screenshotnames[0]);
		 System.out.println(screenshotnames[1]);
		 System.out.println(name);
		 
		 XWPFDocument doc = new XWPFDocument();
		 

		 XWPFTable table = doc.createTable();
			table.setTableAlignment(TableRowAlign.CENTER);
			table.setWidth("100%");;
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("Testcase Name");
	      tableRowOne.addNewTableCell().setText("Test Case 1");
			
	      //create second row
	      XWPFTableRow tableRowTwo = table.createRow();
	      tableRowTwo.getCell(0).setText("Execution status");
	      tableRowTwo.getCell(1).setText("Passed");
	      XWPFParagraph para = doc.createParagraph();
			 XWPFRun run = para.createRun();
	      run.addBreak();
	      run.addBreak();
	      
		 //Title
		 para.setAlignment(ParagraphAlignment.CENTER);
		 run.setBold(true);
		 run.setFontFamily("Verdana");
		 run.setText(name);
		 run.addBreak();

		 BufferedImage bimg;
		 
		 for(String file : Screenshotnames) {
			 try {
			 File dest = new File("C:\\Users\\50171\\Desktop\\Report\\"+file+".jpg");
			 bimg= ImageIO.read(dest);
			 int h=280, w=500;
			 String imgName = dest.getName();
			 int imgFormat = XWPFDocument.PICTURE_TYPE_JPEG;
			 
			 run.addBreak();
			 run.addBreak();
			 run.setText(file);
			
				run.addPicture(new FileInputStream(dest), imgFormat, imgName, Units.toEMU(w), Units.toEMU(h));
			} catch (Exception e) {
				continue;
			} 
			 fileLocation="C:\\Users\\50171\\Desktop\\Report\\"+name+".doc";
			 FileOutputStream out = new FileOutputStream(fileLocation);
			 doc.write(out);
			 out.close();
			 
		 }
	}
	public static void captureScreenShot(WebDriver driver, String SSName) throws Exception {

			
		 TakesScreenshot scrShot =((TakesScreenshot)driver);

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	                File DestFile=new File("C:\\Users\\50171\\Desktop\\Report\\"+SSName+".jpg");

	                FileUtils.copyFile(SrcFile, DestFile);


		 
		 
		 
		 
			/*
			 * String screenshot_name = System.currentTimeMillis() + ".png"; BufferedImage
			 * image = new Robot() .createScreenCapture(new
			 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); File file = new
			 * File("C:\\Users\\50171\\Desktop\\Report\\" + screenshot_name);
			 * ImageIO.write(image, "png", file); InputStream pic = new
			 * FileInputStream("C:\\Users\\50171\\Desktop\\Report\\" + screenshot_name);
			 * run.addBreak(); run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG,
			 * screenshot_name, Units.toEMU(350), Units.toEMU(350)); pic.close();
			 * file.delete();
			 */   }
}
