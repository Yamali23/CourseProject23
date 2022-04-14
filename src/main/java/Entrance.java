

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Entrance", urlPatterns="/JavaEntrance")
public class Entrance extends HttpServlet {
	
	static String[] user = new String[51];
	static String s;
	static private int type = 0;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Input input = Input.fromRequestParameters(request);
		
		input.readFromFile();
		input.checkLoginAndPassword();
		
		input.setAsRequestAttributesAndCalculate(request);
		
		if (type == 1)
		{
			request.getRequestDispatcher("/MainForm.jsp").forward(request, response);
		}
		if (type == 2)
		{
			request.getRequestDispatcher("/MainFormA.jsp").forward(request, response);
		}
		if (type == 0)
		{
			request.getRequestDispatcher("/Info.jsp").forward(request, response);
		}
		
		
		}
	
	private static class Input 
	{
		
		 private  String login;
		 private final String password;
		
		private Input  (String login, String password) 
		{
			this.login = login;
			this.password = password;	
			s = password;
		}
		
		public static Input fromRequestParameters(HttpServletRequest request) {
			return new Input(
			request.getParameter("login"),
			request.getParameter("password"));
			}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			
			request.setAttribute("infa", s);
		}
		
		public void readFromFile() throws IOException
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
			
			
		}
		
		public void checkLoginAndPassword() 
		{
			String myUser;
			
			for (int i = 0; i <50; i++)
			{
				
				if (user[i].equals(login + " " + password + " a"))
				{
					
					type = 2;
					s = "2";
				}
				if (user[i].equals(login + " " + password + " u"))
				{
					s = "1";
					type = 1;
				}
				if(type == 0) 
				{
					s = "Неверный логин или пароль";
				}
			}
		}
		
		/*public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
		{
			request.setAttribute("first_result", login);
			request.setAttribute("second_result", password);
			
		}*/
	}
}
