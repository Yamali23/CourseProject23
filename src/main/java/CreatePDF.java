
import java.io.IOException;

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
    
   
 
}
