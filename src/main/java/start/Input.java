package start;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;



/**
 * Класс Input.
 */
public class Input {

	/**
	 * Поля для хранения массива пользователей,
	 * строки и информацией,
	 * имени авторизованного пользователя
	 * типа пользователя,
	 * логина и пароля
	 */
	static String[] user = new String[51];
	static String s;
	static String yourName;
	static private int type = 0;	 
	private  String login;
	 private final String password;
	
	 /**
	  * Конструктор
	  * @param login - логин 
	  * @param password - пароль 
	  */
	Input  (String login, String password) 
	{
		this.login = login;
		this.password = password;	
	
	}
	/**
	 * Метод для считывания данных, введенных на форме входа

	 */
	public static Input fromRequestParameters(HttpServletRequest request) {
		return new Input(
		request.getParameter("login"),
		request.getParameter("password"));
		}
	
	/**
	 * Метод для вывода необходимой информации на форму
	 */
	public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
		
		request.setAttribute("name", yourName);
		request.setAttribute("infa", s);
	}
	/**
	 * Метод для чтения из файла зарегистрированных пользователец
	 * @return user
	 * 
	 */
	public String[] readFromFile() throws IOException
	{
		
		int i =0;
		 for ( int j = 0; j < 50; j++)
		    {
		    	user[j] = "000";
		    }
//////////////////////////////////////////////////////////////////////////////		
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
			
			i=0;
			String line = "";
			while ((line = br.readLine()) != null) 
			{
				  
				user[i] = line;
			    i++;
			        
			}
			
		
		return user;
	}
	/**
	 * Метод, возвращающий тип авторизирующегося пользователя
	 * @return
	 */
	public int getType()
	{
		return type;
	}
	/**
	 * Метод для авторизации пользователя
	 */
	public void checkLoginAndPassword() 
	{
		String myUser;
		
		type = 0;
		
		for (int i = 0; i <50; i++)
		{
			
			if (user[i].equals(login + " " + password + " a"))
			{
				yourName = "Вы вошли как " + login;
				type = 2;
				
			}
			if (user[i].equals(login + " " + password + " u"))
			{
				yourName = "Вы вошли как " + login;
				type = 1;
			}
			
		}
		
		s = " ";
		if(type == 0) 
		{
			s = "Неверный логин или пароль";
		}
	}
	
	
}