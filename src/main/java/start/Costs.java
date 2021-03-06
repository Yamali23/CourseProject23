package start;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

/**
	 * 
	 * Класс Costs для изменения коэфиициентов
	 *
	 */
	public  class Costs {
		/**
		 * Поля для хранения массивов цен, считанных с формы и файла,
		 * и строка для хранения сообщений
		 */
		String [] costArray = new String [25];
		String [] costFileArray = new String [25];
		String massage;
		
		/**
		 * 
		 * Метод для вывода сообщений на форму
		 */
	public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			
		request.setAttribute("infa", massage);
		}
	/**
	 * Консруктор
	 */
	private Costs  (String cost1, String cost2, String cost3, String cost4, String cost5, String cost6, String cost7, String cost8, String cost9, String cost10, String cost11, String cost12, String cost13, String cost14, String cost15, String cost16, String cost17, String cost18, String cost19, String cost20, String cost21, String cost22) 
	{
		costArray[1] = cost1;
	    costArray[2] = cost2;
		costArray[3] = cost3;
		costArray[4] = cost4;
		costArray[5] = cost5;
		costArray[6] = cost6;
		costArray[7] = cost7;
		costArray[8] = cost8;
		costArray[9] = cost9;
		costArray[10] = cost10;
		costArray[11] = cost11;
		costArray[12] = cost12;
		costArray[13] = cost13;
		costArray[14] = cost14;
		costArray[15] = cost15;
		costArray[16] = cost16;
		costArray[17] = cost17;
		costArray[18] = cost18;
		costArray[19] = cost19;
		costArray[20] = cost20;
		costArray[21] = cost21;
		costArray[22] = cost22;
		
		
	}
	/**
	 * Метод для получения введеных на форму параметров
	 */
	public static Costs fromRequestParameters(HttpServletRequest request) 
	{
		return new Costs(
		request.getParameter("cost1"),
		request.getParameter("cost2"),
		request.getParameter("cost3"),
		request.getParameter("cost4"),
		request.getParameter("cost5"),
		request.getParameter("cost6"),
		request.getParameter("cost7"),
		request.getParameter("cost8"),
		request.getParameter("cost9"),
		request.getParameter("cost10"),
		request.getParameter("cost11"),
		request.getParameter("cost12"),
		request.getParameter("cost13"),
		request.getParameter("cost14"),
		request.getParameter("cost15"),
		request.getParameter("cost16"),
		request.getParameter("cost17"),
		request.getParameter("cost18"),
		request.getParameter("cost19"),
		request.getParameter("cost20"),
		request.getParameter("cost21"),
		request.getParameter("cost22"));
	}
	
	

	/**
	 * Метод для считывания с файла имеющихся коэффициентов
	 * @throws IOException 
	 */
	public void readFromFile() throws IOException 
	{
   	    
		String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/CourseProject23/coeffs.txt";
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String[] lines = new String[50]; 	
		int i = 1;
		String line = "";
		while ((line = br.readLine()) != null) 
		{
			  
			 costFileArray[i] = line;
		    i++;
		        
		}
    
	}
	
	/*public double check(String s) {
		double a = 0;
		
		
		
		return a;
	}*/
	
	/**
	 * Метод для записи в файл новых коэффициентов
	 */
	public void writeToFile() throws IOException {

    	int m = 0;
		String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/CourseProject23/";
		
		File file = new File(filepath + "coeffs.txt");
			PrintWriter pw = new PrintWriter(file);
		
        	int s = 0;
	        for (int d = 1; d <=22 ; d++)
	        {
	            if(costArray[d].length() > 0)
	            {
	           try {
	            	if (Double.parseDouble(costArray[d]) > 0) 
	            	{
	        		   if (Double.parseDouble(costArray[d]) < 100000) 
	        		   {
	        			   costFileArray[d] = costArray[d];
	        			   s ++;
	        		   }
	        	    }
	        	   }
	           catch (NumberFormatException e) {
					
				  m++;
				  
				  massage = "Некорректные данные, повторите ввод";
				  }
	            }  
	        	pw.println(costFileArray[d]);
	        }
        	
	        pw.close();
	       
	        if(m == 0) massage = s + " значений было изменено";
	    
	}
	
	}