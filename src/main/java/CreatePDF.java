
import java.io.File;
import java.io.FileInputStream;

import com.itextpdf.text.BadElementException;
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
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.stream.Stream;

/*import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;*/

public class CreatePDF 
{
	double[] price = new double[22]; //стоимость
	String[] coeff = new String[23]; //цена
    double[] quant = new double[22]; //количество
    String[] materials = new String[22]; //название материала
    String[] price_s = new String[22];
    String[] quant_s = new String[22];
    double a,b;
    int x,y,z,d;
    double finalprice;
     public CreatePDF(double[] price, String[] coeff,double a,  double b, int z, int y, int d, double finalprice)
    {
    	this.price = price;
    	this.coeff = coeff;
    	this.a = a;
    	this.b = b;
    	this.y = y;
    	this.z = z;
    	this.d = d;
    	this.finalprice = finalprice;
    	x = z - y;

    }
    
     public void pdf() throws IOException {
    	 Document document = new Document(); 
     	
    	 String filepath = new File("").getCanonicalPath();
 		String[] parsfilepath = filepath.split("/");
 		
 		int lengthpath = parsfilepath.length;
 		String abspath=""; 
 		for(int i=0;i<(lengthpath-1);i++) 
 		{
 			abspath=abspath+parsfilepath[i]+"/";
 		}
 		filepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/Check.pdf";
 		String imagepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/logo.jpg";
 		String fontpath =abspath+"webapps/WindowsCalculator/WEB-INF/classes/times.ttf";
     	
 		try {	
 			PdfWriter.getInstance(document, new FileOutputStream(filepath));
 		} catch (FileNotFoundException | DocumentException e) {
 			e.printStackTrace();
 		}
 					
 		document.open(); 
 		
 		BaseFont times = null;
 		try {
 			times = BaseFont.createFont(fontpath, "cp1251", BaseFont.EMBEDDED);
 		} catch (DocumentException | IOException e) {
 			e.printStackTrace();
 		}
 
 /////////////просто строка////////////////////////////////////
 		String string_pdf = "Итоги расчёта стоимости оконной конструкции";
 		Paragraph paragraph = new Paragraph();
 	    paragraph.add(new Paragraph(string_pdf, new Font(times,18)));
 	    
 	   String string_pdf2 = "Таблица стоимости материалов";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
 	   
	    String string_pdf9 = " ";
	    paragraph.add(new Paragraph(string_pdf9, new Font(times,14)));
	    
 	    try {
 			document.add(paragraph);
 		} catch (DocumentException e1) {
 			e1.printStackTrace();
 		}

 	      paragraph.clear();
 ///////////////////пустая строка//////////////////////////////////////////////	      
		 /*String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,16)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			} */
  	
 ///////////////////картинка/////////////////////////////	    
 	    Image img = null;
 		try {
 			img = Image.getInstance(imagepath);
 			
 			
 		} catch (BadElementException e2) {
 			
 			e2.printStackTrace();
 		} catch (MalformedURLException e2) {
 			
 			e2.printStackTrace();
 		} catch (IOException e2) {
 			
 			e2.printStackTrace();
 		}
 		
 		img.setAbsolutePosition(417, 45); 
 		
 		try {
 				document.add(img);
 			} catch (DocumentException e) {
 				e.printStackTrace();
 			}
 	
 		paragraph.clear();
 ////////////////////пустая строка /////////////////////////////////////////////////////////////
		 //paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));//
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
 		  
 		 try {
 				document.add(paragraph);
 			} catch (DocumentException e1) {
 				e1.printStackTrace();
 			}
 /////////////////////////таблица////////////////////////////////////////////////////		

 		 PdfPTable table = new PdfPTable(4); 
 		 nameMaterials();
 		 quantity();
 		 table.addCell(new Phrase("Материал", new Font(times,16)));
 		 table.addCell(new Phrase("Количество", new Font(times,16)));
 		 table.addCell(new Phrase("Цена", new Font(times,16)));
 		 table.addCell(new Phrase("Стоимость", new Font(times,16)));
 		 
 		for (int i = 1; i <= 18; i ++) {
 			table.addCell(new Phrase(materials[i], new Font(times,16)));
 	 		 table.addCell(new Phrase(quant_s[i], new Font(times,16)));
 	 		 table.addCell(new Phrase(coeff[i], new Font(times,16)));
 	 		 table.addCell(new Phrase(price_s[i], new Font(times,16)));
 		}
 		double materialscost = finalprice - price[19] - price[20] - price[21];
 		String materialscost_s = Double.toString(materialscost);
 	 		 table.addCell(new Phrase("Итого", new Font(times,16)));
	 		 table.addCell(new Phrase("", new Font(times,16)));
	 		 table.addCell(new Phrase("", new Font(times,16)));
	 		 table.addCell(new Phrase(materialscost_s, new Font(times,16)));
 		
 		 try {
 			document.add(table);
 		} catch (DocumentException e) {
 			e.printStackTrace();
 		}
 		 	
 		String string_pdf4 = "Стоимость сборочных работ " + price[19];
	    paragraph.add(new Paragraph(string_pdf4, new Font(times,14)));
	    
	    String string_pdf5 = "Стоимость аренды " + price[20];
	    paragraph.add(new Paragraph(string_pdf5, new Font(times,14)));
	    
	    String string_pdf6 = "Стоимость электроэнергии " + price[21];
	    paragraph.add(new Paragraph(string_pdf6, new Font(times,14)));
 		 
	    try {
 			document.add(paragraph);
 		} catch (DocumentException e1) {
 			e1.printStackTrace();
 		}

 	      paragraph.clear();
 	      
 	     String string_pdf7 = "Итоговая стоимость оконных конструкций = " + finalprice;
 	    paragraph.add(new Paragraph(string_pdf7, new Font(times,16)));
 	    
  	    try {
  			document.add(paragraph);
  		} catch (DocumentException e1) {
  			e1.printStackTrace();
  		}
  	    
 	    document.close(); 
     }
     
     public void nameMaterials() {
    	materials[1] = "Рамный профиль"; 
    	materials[2] = "Импост";
    	materials[3] = "Створчатый профиль";
    	materials[4] = "Штапик";
    	materials[5] = "Армирование";
    	materials[6] = "Дист. рамка";
    	materials[7] = "Селикогель";
    	materials[8] = "Резиновый уплотнитель";
    	materials[9] = "Герметик";
    	materials[10] = "Бутиловая лента";
    	materials[11] = "Стекло";
    	materials[12] = "Поворотно-откидная конструцкия";
    	materials[13] = "Лапы крепления импоста";
    	materials[14] = "Соединители импоста";
    	materials[15] = "Крепежи (саморезы)";
    	materials[16] = "Монтажная пена";
    	materials[17] = "Анкера";
    	materials[18] = "Подкладка под стеклопакет";
    	
     }
     
     public void quantity() {
    	for (int i = 1; i <= 18; i ++) {
    		quant[i] = price[i] / Double.parseDouble(coeff[i]); 
    		//quant [i] = Math.round(quant[i]);
    		double shkala = Math.pow(10,2);
    		quant[i] = Math.ceil(shkala * quant[i]) / shkala;
    		quant_s[i] = Double.toString(quant[i]);
    		price_s[i] = Double.toString(price[i]);
    		
    	} 
     }	 
     
     
     private void addRows(PdfPTable table) {
 		 
    	 
        table.addCell("Матриал sdvddfcfe");
 	    table.addCell("Количество dgdrg");
 	    table.addCell("Цена dgfrg");
 	    table.addCell("Стоимость sgeg");
 	    
 	   table.addCell(coeff[1]);
 	   table.addCell(Double.toString(price[1]));
 	   table.addCell("789");
 	   table.addCell("357");
  
 	}
}


















   /*public void create() throws IOException, InvalidFormatException 
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
		
	   FileOutputStream out = new FileOutputStream(new File (filepath + "filePDF"));
	   
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
	      
	      
       }*/
 

