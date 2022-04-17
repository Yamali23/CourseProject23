

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="FindUser", urlPatterns="/JavaFindUser")
public class FindUser extends HttpServlet {
	
	static int exname = 0;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Find roles = Find.fromRequestParameters(request);
		roles.findUser();
		roles.setAsRequestAttributesAndCalculate(request);
		
		if (exname == 1) {
			request.getRequestDispatcher("/Roles.jsp").forward(request, response);
		}
		if (exname == 0)
		{
			request.getRequestDispatcher("/NotFound.jsp").forward(request, response);
		}
		
	}
	
	private static class Find
	{
		String name;
		String sss;
		
		private Find (String name) 
		{
			this.name = name;
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
		{
			request.setAttribute("name", name);
	
			///request.setAttribute("sss", sss);
		}
		
		public static Find fromRequestParameters(HttpServletRequest request) 
		{
			return new Find(
			request.getParameter("userName"));
		}
		
        public void findUser() throws IOException
        {
        	String[] logins = new String[300];
        	String[] triple = new String[3];
        	int counter;
        	
        	ClassLoader classLoader = getClass().getClassLoader();
        		    InputStream myFile = classLoader.getResourceAsStream("users");
        		    Scanner scanner = new Scanner(myFile);
        		   
        		  String line;
        		  
        		  int i = 0;
        		    while (scanner.hasNext())
        		    {
                       line = scanner.nextLine();
        		       triple = line.split(" ");
        		       
                       logins[3*i] = triple[0];
                       logins[3*i+1] = triple[1];
                       logins[3*i+2] = triple[2];
                      i++;
                     
        		    }
        		    
        		    counter = i;
        		    
        		    exname = 0;
        		    for (i = 0; i < counter; i++){
        		    	///sss = sss  + logins[3*i] +" "+ name +" //// ";	
        		    	
        		    	String s1 = logins[3*i];
        		    	String s2 = name;
        		        
        		    	if (logins[3*i].equals(name))
        		    	{
        		    		exname = 1;
        		    	}
        		    	
        		    
        		    	
        		    }
        		   
        }
	}
	
	

}
