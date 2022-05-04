package start;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreatePDFTest {

	@Test
	public void test() {
	//double[] price, String[] coeff,double a, double b, int z, int y, int d, double finalprice


	CreatePDF create = new CreatePDF();

	double[] price = new double[19];
	String[] coeff = new String[19];
	double[] quant = new double[19];

	for(int i = 1; i <=18; i++)
	{
		price[i] = Math.random() * (2000 - 100) + 100;
		coeff[i] = Double.toString(Math.random() * (1000 - 10) + 10);
	}

	quant = create.quantity(price, coeff);

	for (int i = 1; i <=18; i ++)
	{
	assertTrue(quant[i] > 0);

	}
	
}

}
