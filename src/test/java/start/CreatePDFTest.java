package start;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

public class CreatePDFTest {

	@Test
	public void test() throws IOException {
	//double[] price, String[] coeff,double a,  double b, int z, int y, int d, double finalprice
		
		
		CreatePDF create = new CreatePDF();
		
		double[] price = new double[19];
		String[] coeff = new String[19];
		double[] quant = new double[19];
		

		String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		int lengthpath = parsfilepath.length;
		String abspath = "";
		for (int ii = 0; ii < (lengthpath - 1); ii++) {
			abspath = abspath + parsfilepath[ii] + "/";
		}
		filepath = abspath + "webapps/WindowsCalculator/coeffs";
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
	   for (int i = 1; i  <=18; i ++)
	    {
		   coeff[i] = br.readLine();
		   price[i] = Math.random() * (500 - 1) + 1;
	    }
		       
		quant = create.quantity(price, coeff);
		
		for (int i = 1; i  <=18; i ++)
	    {
			assertTrue(quant[i] > 0);
			
	    }
		
	}

}
