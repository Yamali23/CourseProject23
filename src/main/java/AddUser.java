import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

//import Registration.Adduser;

public class AddUser {

	private final String login;
	 private final String password;
	 static String s;
	 static boolean t;
	
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

	public static AddUser fromRequestParameters(HttpServletRequest request) 
	{
		return new AddUser(
		request.getParameter("login"),
		request.getParameter("password"));
	}
	
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
		filepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/";
		

	    ClassLoader classLoader = getClass().getClassLoader();
	    InputStream myFile = classLoader.getResourceAsStream("users");
	    Scanner scanner = new Scanner(myFile);
			   
		String[] lines = new String[50]; 	
		int k = 0;
		 while (scanner.hasNext())
			{       
			   lines[k] = scanner.nextLine(); 
			   k++;
			}
       lines[k] = user;
       
       File file = new File(filepath + "users");
		PrintWriter pw = new PrintWriter(file);
		
       for (int d = 0; d <=k ; d++)
       {
       	pw.println(lines[d]);
       }

       pw.close();
   
	}
	
}
