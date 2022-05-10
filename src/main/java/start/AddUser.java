package start;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;


/**
 * Класс AddUser, реализующий добавление 
 * в файл новых пользователей
 * при регистрации.
 */
public class AddUser {

	/** 
	 * Поля для хранения введенных логина и пароля
	 */
	 private final String login;
	 private final String password;
	 private int reg;
     private String infa;
	 /**
		 * Конструктор - создание объекта для добавления пользователя.
		 *
		 * @param log логин пользователя
		 * @param pass пароль пользователя
		 */
	AddUser  (String log, String pass) 
	{
		this.login = log;
		this.password = pass;	
		reg = 0;
		
		
		/*try {
			writeToFile(login,password);
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
	}

	/**
	 * Метод, считывающий введенные данные с формы
	 *
	 */
	public static AddUser fromRequestParameters(HttpServletRequest request) 
	{
		return new AddUser(
		request.getParameter("login"),
		request.getParameter("password"));
	}
	
	/**
	 * Метод, записывающий данные о пользователе в файл
	 *
	 */
	final void writeToFile(String login, String password) throws IOException{
       
		
		String [] m = new String[51];
		
		String user = login + " " + password + " u";
		
   	
   	    String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/CourseProject23/users.txt";
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String[] lines = new String[50]; 	
		int k = 0;
		String line = "";
		while ((line = br.readLine()) != null) 
		{
			  
			lines[k] = line;
		    k++;
		        
		}
		
		lines[k] = user;
	       
	        
		 PrintWriter pw = new PrintWriter(file);
			
	       for (int d = 0; d <=k ; d++)
	       {
	       	pw.println(lines[d]);
	       }

	       pw.close();

	}
	
	
	/**
	 * Метод, проверяющий логин на длину
	 */
	public void checkPassword() 
	{
		
		if (password.length() < 6)
		{
			reg = 1;
			infa = "Длина пароля не может быть менее 6 символов";
	
		}
		if (password.length() > 16)
		{
			reg = 2;
			infa = "Длина пароля не может быть более 16 символов";
		}
		
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(password);
		boolean found = matcher.find();
		if(found)
		{
			reg = 3;
			infa = "Пароль не должен содержать пробелов";
		}
		
		if(reg == 0)
		{
			try {
				writeToFile(login,password);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Метод для вывода необходимой информации на форму
	 */
	public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
		
		request.setAttribute("infa", infa);
	}
	
	/**
	 * 
	 * Метод для возврата результата регистрации
	 */
	public int getReg() {
		return reg;
	}
	
	/**
	 * Метод, проверяющий логин на уже существующий
	 * @throws IOException 
	 */
	public void checkLogin() throws IOException 
	{
		
		if(login.length() == 0)
		{
			reg = 6;
			infa = "Вы не ввели логин";
		}
		
		Pattern pattern2 = Pattern.compile("\\s");
		Matcher matcher2 = pattern2.matcher(login);
		boolean found2 = matcher2.find();
		if(found2)
		{
			reg = 4;
			infa = "Логин не должен содержать пробелов";
		}
		
		int counter;
	   int exname = 0;
	   String[] logins = new String[51];
   	   String[] triple = new String[3];
   	
   	 String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		int lengthpath = parsfilepath.length;
		String abspath = "";
		for (int ii = 0; ii < (lengthpath - 1); ii++) {
			abspath = abspath + parsfilepath[ii] + "/";
		}
		filepath = abspath + "webapps/CourseProject23/users.txt";
		
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
	                    
   		    	if (logins[i].equals(login))
   		    	{
   		    		reg = 5;
   					infa = "Пользователь с данным логином уже сущетсвует";
   		    	}
   	
   		    }
	}
}
