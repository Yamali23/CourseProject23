package start;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class CreatePDFTest {

	@Test
	public void test() {
	//double[] price, String[] coeff,double a,  double b, int z, int y, int d, double finalprice
		
		
		CreatePDF create = new CreatePDF();
		
		double[] price = new double[19];
		String[] coeff = new String[19];
		double[] quant = new double[19];
		

		ClassLoader classLoader = getClass().getClassLoader();
	    InputStream myFile = classLoader.getResourceAsStream("coeffs");
	    Scanner scanner = new Scanner(myFile);
	   
	  
	   for (int i = 1; i  <=18; i ++)
	    {
		   coeff[i] = scanner.nextLine();
		   price[i] = Math.random() * (500 - 1) + 1;
	    }
		       
		quant = create.quantity(price, coeff);
		
		for (int i = 1; i  <=18; i ++)
	    {
			assertTrue(quant[i] > 0);
			
	    }
		
	}

}
