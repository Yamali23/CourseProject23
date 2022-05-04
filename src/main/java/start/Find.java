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
	 * Класс Find для поиска пользователя в списке зарегистрированных
	 */
	public class Find
	{
		private int exname = 0;
		/**
		 * Поля для хранения введенного логина,
		 * сроки с сообщением,
		 * массива логинов
		 * и впомогательно массива для поиска введенного логина
		 */
		private  String name;
		String sss = " ";
		String[] logins = new String[51];
    	String[] triple = new String[3];
		
    	/**
    	 * Метод, возвращающий найденного пользователя
    	 * @return exname
    	 */
    	
    	public int getExname()
    	{
    		return exname;
    	}
    	
    	/**
    	 * Конструктор
    	 * @param name - логин введенного пользователя
    	 */
		private Find (String name) 
		{
			this.name = " ";
			this.name = name;
		}
		/**
		 * 
		 * Метод для вывода данных на форму
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
		{
			request.setAttribute("name", name);
	
			request.setAttribute("sss", sss);
		}
		/**
		 * 
		 * Метод для считывания данных с формы ввода логина 
		 * 
		 */
		public static Find fromRequestParameters(HttpServletRequest request) 
		{
			return new Find(
			request.getParameter("userName"));
		}
		/**
		 * Метод для поиска введенного логина
		 * среди записанных в файле
		 */
        public void findUser() throws IOException
        {
        	
        	int counter;
        	
        	 String filepath = new File("").getCanonicalPath();
 			String[] parsfilepath = filepath.split("/");
 			int lengthpath = parsfilepath.length;
 			String abspath = "";
 			for (int ii = 0; ii < (lengthpath - 1); ii++) {
 				abspath = abspath + parsfilepath[ii] + "/";
 			}
 			filepath = abspath + "webapps/WindowsCalculator/users";
 			
 			File file = new File(filepath);
 			FileInputStream fis = new FileInputStream(file);
 			InputStreamReader isr = new InputStreamReader(fis);
 			BufferedReader br = new BufferedReader(isr);
            
            String line;
        		  
        		  int i = 0;
        		 
      			while ((line = br.readLine()) != null) 
      			{
                       
        		       triple = line.split(" ");
        		       
                       logins[3*i] = triple[0];
                       logins[3*i+1] = triple[1];
                       logins[3*i+2] = triple[2];
                      i++;
                     
        		  }
        		    
        		    counter = i;
        		   
        		    exname = 0;
        		 
        		    
        		    for (i = 0; i < counter; i++)
        		    {
   	                    
        		    	if (logins[3*i].equals(name))
        		    	{
        		    		exname = 1;
        		    		rememberUser(logins[3*i]);
        		    	}
        	
        		    }
        }
       /**
        * Метод для записи найденного логина в буфер обмена
        * @param s - логин пользователя
        * 
        */
        public void rememberUser(String s) throws IOException 
        {
        	String filepath = new File("").getCanonicalPath();
			String[] parsfilepath = filepath.split("/");
			
			int lengthpath = parsfilepath.length;
			String abspath=""; 
			for(int i=0;i<(lengthpath-1);i++) 
			{
				abspath=abspath+parsfilepath[i]+"/";
			}
			filepath=abspath+"webapps/WindowsCalculator/";
			
			File file = new File(filepath + "buffer.txt");
			PrintWriter pw = new PrintWriter(file);
			
	        pw.println(s);

	        pw.close();
        }
       
	}
