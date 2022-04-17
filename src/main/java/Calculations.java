

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calculations", urlPatterns="/JavaCalc")

public class Calculations extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Stash stash = Stash.fromRequestParameters(request);
		
		stash.reader();
		stash.converter();
		stash.calculator();
		
		stash.setAsRequestAttributesAndCalculate(request);
		request.getRequestDispatcher("/ResultCost.jsp").forward(request, response);
	}
	
	private static class Stash
	{
		String [] coeff = new String[23];
		String a_s;
		String b_s;
		String z_s;
		String y_s;
		String d_s;
		String pdf_s;
		String s_s;
		
		double a;
		double b;
		int z;
		int y;
		int d;
		int x;
		
		double finalcost = 0;
		
		private Stash  (String height, String width, String NumStvor, String NumFuncStvor, String TypeStvor, String PDF) 
		{
			this.a_s = height;
			this.b_s = width;
			this.z_s = NumStvor;
			this.y_s = NumFuncStvor;
			this.d_s = TypeStvor;
			this.pdf_s = PDF;
			//this.x = (Integer.parseInt(z)-Integer.parseInt(y));
			//s_s = z_s;
		}
		
			public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			
			request.setAttribute("height", a);
			request.setAttribute("width", b);
			request.setAttribute("NumStvor", z);
			request.setAttribute("NumFuncStvor", y);
			request.setAttribute("TypeWind", d);
			request.setAttribute("FinalCost", finalcost);
		}
		
		public static Stash fromRequestParameters(HttpServletRequest request) 
		{
			return new Stash(
			request.getParameter("height"),
			request.getParameter("width"),
			request.getParameter("NumStvor"),
			request.getParameter("NumFuncStvor"),
			request.getParameter("TypeWind"),
			request.getParameter("PDF"));
		}
		
		 public void reader() {
		 ClassLoader classLoader = getClass().getClassLoader();
		    InputStream myFile = classLoader.getResourceAsStream("coeffs");
		    Scanner scanner = new Scanner(myFile);
		   
			int f = 1;		  
		    while (scanner.hasNext())
		    {       
		       coeff[f] = scanner.nextLine();
		       f++;
		    }
	}
		 
		 public void converter() {
			 	a = Double.parseDouble(a_s);
				b = Double.parseDouble(b_s);
				z = Integer.parseInt(z_s);
				y = Integer.parseInt(y_s);
				d = Integer.parseInt(d_s);
				x = z-y;
				s_s = Integer.toString(x);
		 }
		 public void calculator() throws IOException {
			 double[] price = new double[22];
			 price[1] = 2*(a+b)*Double.parseDouble(coeff[1]);
			 price[2] = (z-1)*(a-0.1)*Double.parseDouble(coeff[2]);
			 price[3] = 2*y*(b/z+a-0.1)*Double.parseDouble(coeff[3]);
			 price[4] = Double.parseDouble(coeff[4])*4*(a+b-0.2)+Double.parseDouble(coeff[4])*4*(z-1)*(a-0.1)+Double.parseDouble(coeff[4])*4*y*(b/z+a-0.2);
			 price[5] = Double.parseDouble(coeff[5])*2*(a+b)+Double.parseDouble(coeff[5])*(z-1)*(a-0.1)+Double.parseDouble(coeff[5])*2*y*(b/z+a-0.1);
			 price[6] = Double.parseDouble(coeff[6])*4*x*(b/z+a-0.1)+Double.parseDouble(coeff[6])*4*y*(b/z+a-0.2);
			 price[7] = 0.15*z*Double.parseDouble(coeff[7]);
			 price[8] = Double.parseDouble(coeff[8])*2*x*(b/z+a-0.1)+Double.parseDouble(coeff[8])*2*y*(b/z+a-0.2);
			 price[9] = 0.25*z*Double.parseDouble(coeff[9]);
			 price[10] = 2*(a+b)*Double.parseDouble(coeff[10]);
			 price[11] = Double.parseDouble(coeff[11])*(d+1)*x*(b/z-0.05)*(a-0.05)+Double.parseDouble(coeff[11])*(d+1)*y*(b/z-0.1)*(a-0.1);
			 price[12] = Double.parseDouble(coeff[12])*y;
			 price[13] = (z-1)*2*Double.parseDouble(coeff[13]);
			 price[14] = (z-1)*2*Double.parseDouble(coeff[14]);
			 price[15] = 15*z*Double.parseDouble(coeff[15]);
			 price[16] = 0.5*z*Double.parseDouble(coeff[16]);
			 price[17] = 4*z*Double.parseDouble(coeff[17]);
			 price[18] = 12*z*Double.parseDouble(coeff[18]);
			 price[19] = (Double.parseDouble(coeff[19])*b/z*a*x+Double.parseDouble(coeff[20])*b/z*a*y)*0.1;
			 price[20] = Double.parseDouble(coeff[21]);
			 price[21] = Double.parseDouble(coeff[22]);
			 
			 for (int i=1;i<22;i++) {
				finalcost += price[i]; 
			 }
			 finalcost = Math.round(finalcost);
			 
			 if(pdf_s.equals("yes"))
			 {
				 CreatePDF create = new CreatePDF(price, coeff, a, b, z, y, d);
				 create.create();
				
			 }
		 }
		 
		 
	}		 

}
