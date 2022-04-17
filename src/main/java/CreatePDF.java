
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

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
    
   public void create() throws IOException 
   {
	   XWPFDocument document = new XWPFDocument();
	  
	   
	   
	    /*String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/";*/
		FileOutputStream out = new FileOutputStream(new File ( "myFile"));
	   
	   XWPFParagraph par = document.createParagraph();
	   XWPFRun run = par.createRun();
	   run.setText("cnncnerkcrmc");
	   document.write(out);
	   out.close();
	   
  }
 
}
