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
		
		try {
			writeToFile(login,password);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
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
	
}
