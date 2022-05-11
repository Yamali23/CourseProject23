package start;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Класс Calculations, реализующий 
 * взаимодействие с jsp формами ввода данных
 * для расчета и выводом результатов.
 */

@WebServlet(name="Calculations", urlPatterns="/JavaCalc")

public class Calculations extends HttpServlet {
	
	
	
	/**
	 * Метод, создающий экземпляр класса Stash 
	 * для считывания данных с формы ввода, расчета
	 * итоговой суммы и вывода результаов 
	 * на форму вывода данных
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Stash stash = Stash.fromRequestParameters(request);
		
		stash.reader();
		
		
	    String a = stash.getA();
	    String b = stash.getB();
	    String z = stash.getZ();
	    String y = stash.getY();
	    String d = stash.getD();
		
		stash.converter(a,b,z,y,d);
	

		
		stash.setAsRequestAttributesAndCalculate(request);
		
		String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		int lengthpath = parsfilepath.length;
		String abspath = "";
		for (int ii = 0; ii < (lengthpath - 1); ii++) {
			abspath = abspath + parsfilepath[ii] + "/";
		}
		filepath = abspath + "webapps/CourseProject23/type.txt";
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		
	
		String type_s = br.readLine();
		
		int type = Integer.parseInt(type_s);	
		int p = stash.getPDF();
		if (p== 0)
		{
		    if(type == 2) 
		    {
		    	request.getRequestDispatcher("/ResultCostA.jsp").forward(request, response);
		    }
		    if (type == 1)
		    {
		    	request.getRequestDispatcher("/ResultCost.jsp").forward(request, response);
		    }
			
		}
		if(p==1)
		{
			if(type == 2)
			{
				request.getRequestDispatcher("/OpenPDFA.jsp").forward(request, response);
			}
			if(type == 1)
			{
				request.getRequestDispatcher("/OpenPDF.jsp").forward(request, response);
			}
			
		}
		
	
	}
	
}
