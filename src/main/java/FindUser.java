
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="FindUser", urlPatterns="/JavaFindUser")
public class FindUser extends HttpServlet {
	
	private static int exname = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		exname = 0;
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
		private  String name;
		String sss = " ";
		String[] logins = new String[12];
		String[] user = new String[51];
    	String[] triple = new String[3];
		
		private Find (String name) 
		{
			this.name = " ";
			this.name = name;
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
		{
			request.setAttribute("name", name);
	
			request.setAttribute("sss", sss);
		}
		
		public static Find fromRequestParameters(HttpServletRequest request) 
		{
			return new Find(
			request.getParameter("userName"));
		}
		
        public void findUser() throws IOException
        {
        	
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
        		 
        		    
        		    for (i = 0; i < counter; i++)
        		    {
   	                    
        		    	if (logins[3*i].equals(name))
        		    	{
        		    		exname = 1;
        		    		rememberUser(logins[3*i]);
        		    	}
        	
        		    }
        }
       
        public void rememberUser(String s) throws IOException 
        {
        	String filepath = new File("").getCanonicalPath();
			String[] parsfilepath = filepath.split("/");
			
			int lengthpath = parsfilepath.length;
			String abspath=""; 
			for(int i=0;i<(lengthpath-1);i++) 
			{
				abspath=abspath+parsfilepath[i]+"/";
			}
			filepath=abspath+"webapps/WindowsCalculator/WEB-INF/classes/";
			
			File file = new File(filepath + "buffer");
			PrintWriter pw = new PrintWriter(file);
			
	        pw.println(s);

	        pw.close();
        }
       
	}

}
