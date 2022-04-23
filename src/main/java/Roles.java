import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

public class Roles {
	String[] logins = new String[300];
	String[] loginsFinal = new String[100];
	String[] triple = new String[3];
	int counter;
	String name;
	String role;
	String info = " ";
	
	Roles (String name, String role) 
	{
		//this.name = name;
		
		
		this.role = role;
		/*try {
			findUser(role, this.name);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	public String[] getArray() {
		return logins;
	}
	public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
	{
		request.setAttribute("infa", info);

		
	}
	
	public static Roles fromRequestParameters(HttpServletRequest request) 
	{
		return new Roles(
		request.getParameter("name"),
		request.getParameter("Role"));
	}
	
    public void findUser(String role, String name) throws IOException
    {
    	
    	
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
    		    
    		    
    		    info = name + " " + role;
    		    for (i = 0; i < counter; i++)
    		    {
    		    	
    		    	
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
    
    }
    public void writer() throws IOException
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
    		    
    		    File file = new File(filepath + "users");
    			PrintWriter pw = new PrintWriter(file);
    		    
    		    for (int i= 0 ;i < counter;i++) 
    		    {
    		    	
    		    loginsFinal[i] = logins[3*i] + " " + logins[3*i+1] + " " + logins[3*i+2];
    		   
    		    pw.println(loginsFinal[i]);
    		    }
    		    pw.close();
	   
    }
    
    public void readFromBuffer() 
    {
    	ClassLoader classLoader = getClass().getClassLoader();
	    InputStream myFile = classLoader.getResourceAsStream("buffer");
	    Scanner scanner = new Scanner(myFile);
	    
	    name = scanner.nextLine();
	    
    }
}
