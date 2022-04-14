

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet(name="Registration", urlPatterns="/JavaRegistration")
public class Registration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Adduser adduser = Adduser.fromRequestParameters(request);
		
		
		adduser.writeToFile(request);		
		
		adduser.setAsRequestAttributesAndCalculate(request);
		request.getRequestDispatcher("/Info.jsp").forward(request, response);
	}

	private static class Adduser
	{
		
		 private final String login;
		 private final String password;
		 static String s;
		 static boolean t;
		
		private Adduser  (String login, String password) 
		{
			this.login = login;
			this.password = password;	
			
		}
		
        public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			
			request.setAttribute("infa", s);
		}
		
		public static Adduser fromRequestParameters(HttpServletRequest request) 
		{
			return new Adduser(
			request.getParameter("login"),
			request.getParameter("password"));
		}
		
		private final void writeToFile(HttpServletRequest request) throws IOException{
	        
			String [] m = new String[51];
			
			String user = login + " " + password + " u";
			File file = new File("users");
			t = Files.exists(file.toPath());
           
			PrintWriter pw = new PrintWriter(file);
	        pw.println(user);
	        pw.close();

			        ClassLoader classLoader = getClass().getClassLoader();
				    InputStream myFile = classLoader.getResourceAsStream("users");
				    Scanner scanner = new Scanner(myFile);
				   
				  
				    while (scanner.hasNext())
				    {       
				       s = "Последнее в файлe " + scanner.nextLine();   
				    }
		}

	}
}
