package start;


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


/**
 * Класс Entrance для взаимодействия с jsp формой входа.
 */
@WebServlet(name="Entrance", urlPatterns="/JavaEntrance")
public class Entrance extends HttpServlet {
	
	/**
	 * переменная, хранаящая тип авторизирующегося пользователя
	 */
	static private int type = 0;
	
	/**
	 * Метод для создания экземпляра класса Input,
	 * получения данных с формы ввода логина и пароля при входе,
	 * и входа в систему
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Input input = Input.fromRequestParameters(request);
		
		input.readFromFile();
		String l = input.getlogin();
		String p = input.getpassword();
		String[] a = input.getArray();
		input.checkLoginAndPassword(l,p,a);
		
		input.setAsRequestAttributesAndCalculate(request);
		
		type = input.getType();
		
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
			request.getRequestDispatcher("/InputForm.jsp").forward(request, response);
		}
		
		
		}
	
}
