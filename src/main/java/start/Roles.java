package start;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

/**
 * Класс Roles для изменения роли пользователя.
 */
public class Roles {
	/**
	 * Поля для хранения массивов данных польлователей,
	 * вспомогательного массива, счетчика, 
	 * логина текущего пользователя, изменяемой роли,
	 * строки с информацией
	 */
	String[] logins = new String[300];
	String[] loginsFinal = new String[100];
	String[] triple = new String[3];
	int counter;
	String name;
	String role;
	String info = " ";
	
	/**
	 * Конструктор
	 * @param name - логин пользователя
	 * @param role - роль
	 */
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
	
	/**
	 * Метод, возвращающий логин пользователя
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Метод, возвращающий роль пользователя
	 * @return role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Метод, возвращающий массив данных пользователей
	 * @return logins
	 */
	public String[] getArray() {
		return logins;
	}
	/**
	 * Метод для вывода информации на форму
	 * 
	 */
	public void setAsRequestAttributesAndCalculate(HttpServletRequest request) 
	{
		request.setAttribute("infa", info);

		
	}
	/**
	 * Метод для получения данных с формы изменения роли
	 */
	public static Roles fromRequestParameters(HttpServletRequest request) 
	{
		return new Roles(
		request.getParameter("name"),
		request.getParameter("Role"));
	}
	
	/**
	 * Метод для поиска пользователя
	 * @param role - роль 
	 * @param name - логин
	 */
    public void findUser(String role, String name) throws IOException
    {
    	
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/CourseProject23/users.txt";
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String[] lines = new String[50]; 	
		int i = 0;
		String line = "";
		while ((line = br.readLine()) != null) 
    		    {
                   
    		       triple = line.split(" ");
    		       
                   logins[3*i] = triple[0];
                   logins[3*i+1] = triple[1];
                   logins[3*i+2] = triple[2];
                  i++;
                 
    		    }
    		    
    		    counter = i;
    		    
    		    
    		    //info = name + " " + role;
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
    /**
     * Метод для записи в файл
     */
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
    			filepath=abspath+"webapps/CourseProject23/";
    		    
    		    File file = new File(filepath + "users.txt");
    			PrintWriter pw = new PrintWriter(file);
    		    
    		    for (int i= 0 ;i < counter;i++) 
    		    {
    		    	
    		    loginsFinal[i] = logins[3*i] + " " + logins[3*i+1] + " " + logins[3*i+2];
    		   
    		    pw.println(loginsFinal[i]);
    		    }
    		    pw.close();
	   
    }
    /**
     * Метод для чтения из буфера обмена
     * @throws IOException 
     */
    public void readFromBuffer() throws IOException 
    {
    	String filepath = new File("").getCanonicalPath();
		String[] parsfilepath = filepath.split("/");
		
		int lengthpath = parsfilepath.length;
		String abspath=""; 
		for(int i=0;i<(lengthpath-1);i++) 
		{
			abspath=abspath+parsfilepath[i]+"/";
		}
		filepath=abspath+"webapps/CourseProject23/buffer.txt";
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String line = "";
	    
	    name = br.readLine();
	    
	    
    }
}
