import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;



public class Input {

	static String[] user = new String[51];
	static String s;
	static String yourName;
	static private int type = 0;	 
	private  String login;
	 private final String password;
	
	Input  (String login, String password) 
	{
		this.login = login;
		this.password = password;	
		
		
		
	}
	
	public static Input fromRequestParameters(HttpServletRequest request) {
		return new Input(
		request.getParameter("login"),
		request.getParameter("password"));
		}
	
	public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
		
		request.setAttribute("name", yourName);
		request.setAttribute("infa", s);
	}
	
	public String[] readFromFile() throws IOException
	{
		
		int i =0;
		 for ( int j = 0; j < 50; j++)
		    {
		    	user[j] = "000";
		    }
		
		ClassLoader classLoader = getClass().getClassLoader();
	    InputStream myFile = classLoader.getResourceAsStream("users");
	    Scanner scanner = new Scanner(myFile);
	   
	  
	    while (scanner.hasNext())
	    {
           
	       user[i] = scanner.nextLine();
	       
           i++;
	    }
		
	    
		return user;
	}
	
	public int getType()
	{
		return type;
	}
	
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
		
		if(type == 0) 
		{
			s = "Неверный логин или пароль";
		}
	}
	
	
}
