

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="ChangeRoles", urlPatterns="/JavaChangeRoles")
public class ChangeRoles extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ChangeRole roles = ChangeRole.fromRequestParameters(request);
		roles.findUser();
		roles.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/Info.jsp").forward(request, response);
	}
	
	private static class ChangeRole
	{
		String name;
		String role;
		String info;
		
		private ChangeRole (String name, String role) 
		{
			this.name = name;
			this.role = role;
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
		{
			request.setAttribute("infa", info);
	
			
		}
		
		public static ChangeRole fromRequestParameters(HttpServletRequest request) 
		{
			return new ChangeRole(
			request.getParameter("userName"),
			request.getParameter("Role"));
		}
		
        public void findUser()
        {
        	String[] logins = new String[151];
        	String[] triple = new String[3];
        	
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
        	
        		    info = logins[0] + " / " + logins[1] + " / " + logins[2] + " / " + logins[3] + " / " + logins[4];
        		   
        }
	}
	
	

}
