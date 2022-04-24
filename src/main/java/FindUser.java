
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

/**
 * Класс FindUser.
 */
@WebServlet(name="FindUser", urlPatterns="/JavaFindUser")
public class FindUser extends HttpServlet {
	
	/**
	 * Перемнная для хранения метки - был найден пользователь или нет
	 */
	private static int exname = 0;

	/**
	 * Метод для создания экземпляра класса Find,
	 * получения данных с формы поиска пользователя
	 * и перехода на другие формы при удачном или неудачном поиске
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		exname = 0;
		Find roles = Find.fromRequestParameters(request);
		roles.findUser();
		roles.setAsRequestAttributesAndCalculate(request);
		exname = roles.getExname();	
		if (exname == 1) {
			request.getRequestDispatcher("/Roles.jsp").forward(request, response);
		}
		if (exname == 0)
		{
			request.getRequestDispatcher("/NotFound.jsp").forward(request, response);
		}
		
	}


}
