

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
        	String[] logins = new String[300];
        	String[] loginsFinal = new String[100];
        	String[] triple = new String[3];
        	
        	for ( int j = 0 ; j < 300; j++)
        	{
        		logins[j] = " ";
        	}
        	
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
        		    
        		    for (i = 0; i < 40; i++){
        		    	if (logins[3*i].equals(name))
        		    	{
        		    		if(role.equals("oneRole"))
        		    		{
        		    			logins[3*i+2] = "u";
        		    		}
        		    		if(role.equals("twoRole"))
        		    		{
        		    			logins[3*i+2] = "a";
        		    		}
        		    	}
        		    }
        		    
        		    for (i= 0 ;i < 40;i++) {
        		    loginsFinal[i] = logins[3*i] + " " + logins[3*i+1] + " " + logins[3*i+2];
        		    }
        	
        		   info = loginsFinal[0] + " /.../ " + loginsFinal[i];
        		   //info = "Если " + logins[0] + " = " + name;
        		   
        }
	}
	
	

}
