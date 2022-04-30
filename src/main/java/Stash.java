import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

/**
 * Класс Stash для расчета итоговой стоимости .
 */

public class Stash {

	/**
	 * Поля для хранение значения цен матриалов,
	 * размеров окна, количества створок, количества
	 * откидных створок, тип стелопакета,
	 * информации об ошибках
	 */
	String [] coeff = new String[23];
	String a_s;
	String b_s;
	String z_s;
	String y_s;
	String d_s;
	String pdf_s;
	String s_s;
	String err1, err2, err3, err4, err5;
	double[] s;
	double a;
	double b;
	int z;
	int y;
	int d;
	int x;
	int pdf = 0;
	
	/**
	 * переменная для хранение итоговой стоимости производства
	 */
	double finalcost = 0;
	
	/**
	 * Конструктор 
	 * @param height - высота
	 * @param width - ширина 
	 * @param NumStvor - количество створок
	 * @param NumFuncStvor - количество откидных створок
	 * @param TypeStvor - тип стеклопакета
	 * @param PDF - необходимость генерации PDF
	 */
	Stash  (String height, String width, String NumStvor, String NumFuncStvor, String TypeStvor, String PDF) 
	{
		this.a_s = height;
		this.b_s = width;
		this.z_s = NumStvor;
		this.y_s = NumFuncStvor;
		this.d_s = TypeStvor;
		this.pdf_s = PDF;
		
		reader();
		//this.x = (Integer.parseInt(z)-Integer.parseInt(y));
		//s_s = z_s;
	}
	/**
	 * Метод для передачи за=начений на форму вывода результатов
	 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
		
		request.setAttribute("height", a);
		request.setAttribute("width", b);
		request.setAttribute("NumStvor", z);
		request.setAttribute("NumFuncStvor", y);
		request.setAttribute("TypeWind", d);
		request.setAttribute("FinalCost", finalcost);
		request.setAttribute("Error1", err1);
		request.setAttribute("Error2", err2);
		request.setAttribute("Error3", err3);
		request.setAttribute("Error4", err4);
		request.setAttribute("Error5", err5);
	}
		/**
		 * Метод, возвращающий высоту окна
		 * @return a_s
		 */
	public String getA() {
		return a_s;
	}
	/**
	 * Метод, возвращющий ширину окна
	 * @return b_s
	 */
	public String getB() {
		return b_s;
	}
	/**
	 * Метод, возвращающий количество створок
	 * @return z_s
	 */
	public String getZ() {
		return z_s;
	}
	/**
	 * Метод, возвращающий количество откидных створок
	 * @return y_s
	 */
	public String getY() {
		return y_s;
	}
	/**
	 * Метод, возвращающий тип стелопакета 
	 * @return d_s
	 */
	public String getD() {
		return d_s;
	}
	/**
	 * Метод, считывабщий введенные параметры окна с формы
	 */
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
	
	/*public Stash() {
		reader();
	}*/
	/**
	 * Метод, считывающий коэфиициенты
	 * стоимости материалов и услуг с файла
	 */
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
	/**
	 * Метод, проверяющий введенные данный на корректность 
	 * @param a_s - высота
	 * @param b_s - ширина 
	 * @param z_s - количество створок
	 * @param y_s - количетво откидных створок
	 * @param d_s - тип стелопакета
	 * @return с - количество ошибок
	 */
	 public int converter(String a_s,String b_s,String z_s,String y_s,String d_s) throws IOException {
		 int c = 0;
		 try {
			 	a = Double.parseDouble(a_s);
				b = Double.parseDouble(b_s);
				}
				catch (NumberFormatException e) {
					a=0;
					b=0;
					finalcost=0;
					err1="Некорректные значения ширины или высоты";
					c = c + 1;
					
					
				}
		 	
			z = Integer.parseInt(z_s);
			y = Integer.parseInt(y_s);
			d = Integer.parseInt(d_s);
			x = z-y;
			s_s = Integer.toString(x);

			
			if (((a < 0.5) || (b < 0.5)) && (c == 0)){
				err2="Значения ширины и высоты не могут быть меньше 0.5";
				c = c + 1;
			}
			
			
			if (((a / z) < 0.5) && (c == 0)) {
				err3="Ширина створки не может быть меньше, чем 0.5";
				c = c + 1;
			}
			
			if (z < y) {
				err4="Количество откидных створок не может быть больше общего количества створок";
				c = c + 1;
			}
			
			if ((a > 2.5) || (b > 2.5)){
				err5="Значения ширины и высоты не могут быть больше 2.5";
				c = c + 1;
			}
			
			if (c == 0) {
			calculator(a,b,z,x,y,d);
			}
			
		return c;	
	 }
	 /**
	  * Метод, вычисляющий стоимость производства
	  * @param a - высота
	  * @param b - ширина 
	  * @param z - количество створок
	  * @param x - количество глухих створок
	  * @param y - количество откидных створок
	  * @param d- тип стеклопакета
	  * @return finalcost
	  */
	 public double calculator(double a, double b, int z, int x, int y, int d) throws IOException{
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
		 
		
		 Sum lambda = () ->
		{
			double res = 0;
			for (int i=1;i<22;i++) 
			{
				res += price[i]; 
				
			 }
			return res;
		};
		
		finalcost = lambda.getResult();
		
		finalcost = Math.round(finalcost);
		 
			
		 if(pdf_s.equals("yes"))
		 {
			 pdf = 1;
			 CreatePDF create = new CreatePDF(price, coeff, a, b, z, y, d, finalcost);
			 create.create();
			 
		 }
		 
		 return finalcost;
	 }
	 
	 public int getPDF()
	 {
		 return pdf;
	 }
	
}
