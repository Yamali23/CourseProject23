

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



@WebServlet(name="ChangeRoles", urlPatterns="/JavaChangeRoles")
public class ChangeRoles extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ChangeRole roles = ChangeRole.fromRequestParameters(request);
		roles.findUser();
		roles.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/FindUser.jsp").forward(request, response);
	}
	
	private static class ChangeRole
	{
		String name;
		String role;
		String info = " ";
		
		private ChangeRole (String name, String role) 
		{
			this.name = name;
			info = "имя " + name;
			
			this.role = role;
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
		{
			request.setAttribute("infa", info);
	
			
		}
		
		public static ChangeRole fromRequestParameters(HttpServletRequest request) 
		{
			return new ChangeRole(
			request.getParameter("name"),
			request.getParameter("Role"));
		}
		
        public void findUser() throws IOException
        {
        	String[] logins = new String[300];
        	String[] loginsFinal = new String[100];
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
        		    //info = name;
        		    counter = i;
        		    //info = role;
        		    
        		    for (i = 0; i < counter; i++)
        		    {
        		    	//info = info + " {" + logins[3*i] + "} и" + " {" + name + "} /////";
        		    	
        		    	if (logins[3*i].equals(name))
        		    	{
        		    		if(role.equals("oneRole"))
        		    		{
        		    			logins[3*i+2] = "u";
        		    		}
        		    		if(role.equals("twoRole"))
        		    		{
        		    			//info =info + " Зашли в иф по администратору";
        		    			logins[3*i+2] = "a";
        		    		}
        		    	}
        		    }
        		    
        		    String filepath = new File("").getCanonicalPath();
        			String[] parsfilepath = filepath.split("/");
        			
        			int lengthpath = parsfilepath.length;
        			String abspath=""; 
        			
        			for(i=0;i<(lengthpath-1);i++) 
        			{
        				abspath=abspath+parsfilepath[i]+"/";
        			}
        			filepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/";
        		    
        		    File file = new File(filepath + "users");
        			PrintWriter pw = new PrintWriter(file);
        		    
        		    for (i= 0 ;i < counter;i++) 
        		    {
        		    	
        		    loginsFinal[i] = logins[3*i] + " " + logins[3*i+1] + " " + logins[3*i+2];
        		    //info = info + loginsFinal[i] + " /// ";
        		    pw.println(loginsFinal[i]);
        		    }
        		    pw.close();
        	
        		  
        		   
        }
	}
	
	

}
