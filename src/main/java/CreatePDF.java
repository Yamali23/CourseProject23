
import java.io.File;
import java.io.FileInputStream;

/*import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
//import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreatePDF 
{
	double[] price = new double[22];
	String[] coeff = new String[23];
    String[] quant = new String[22];
    double a,b;
    int x,y,z,d;
    
     public CreatePDF(double[] price, String[] coeff, double a,  double b, int z, int y, int d)
    {
    	this.price = price;
    	this.coeff = coeff;
    	this.a = a;
    	this.b = b;
    	this.y = y;
    	this.z = z;
    	this.d = d;
    	x = z - y;

    }
    
   public void create() throws IOException, InvalidFormatException 
   {
	   XWPFDocument document = new XWPFDocument();
	  
	   
	   
	    String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/";
		
	   FileOutputStream out = new FileOutputStream(new File (filepath + "myFile.docx"));
	   
	   //XWPFParagraph par = document.createParagraph();
	   //XWPFRun run = par.createRun();
	   //run.setText("cnncnerkcrmc");
	   //document.write(out);
	   //out.close();
	   
	   
	   
	      XWPFParagraph paragraph = document.createParagraph();
	      XWPFRun run=paragraph.createRun();   
	   
	     /////////таблица/////////////////////////////////////////
	      XWPFTable table = document.createTable();

	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("col один, row one");
	      tableRowOne.addNewTableCell().setText("col two, row one");
	      tableRowOne.addNewTableCell().setText("col three, row one");
			
	      
	      XWPFTableRow tableRowTwo = table.createRow();
	      tableRowTwo.getCell(0).setText("col one, row two");
	      tableRowTwo.getCell(1).setText("col two, row two");
	      tableRowTwo.getCell(2).setText("col three, row two");
			
	      
	      XWPFTableRow tableRowThree = table.createRow();
	      tableRowThree.getCell(0).setText("col one, row three");
	      tableRowThree.getCell(1).setText("col two, row three");
	      tableRowThree.getCell(2).setText("col three, row three");
	      
	    ///////////////////надпись //////////////////////////  
	       paragraph = document.createParagraph();
	       run=paragraph.createRun(); 
	       paragraph = document.createParagraph();
	       run=paragraph.createRun(); 
	        run.setText("Логотип УГАТУ");
	      
	      
		/////////////////загрузка картинки /////////////////////////////////////////////////
	      
	      
	      ClassLoader classLoader = getClass().getClassLoader();
		  InputStream image = classLoader.getResourceAsStream("logo.jpg");
		  
	      
	       paragraph = document.createParagraph();
	       run=paragraph.createRun(); 
	      
	       run.addPicture(image, XWPFDocument.PICTURE_TYPE_PNG, "logo.jpg", Units.toEMU(100), Units.toEMU(60));
	      
	 
	      document.write(out); 
	      document.close(); 
	      
	      
       }
 
}
