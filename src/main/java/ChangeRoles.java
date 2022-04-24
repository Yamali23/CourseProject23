

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


/**
 * Класс ChangeRoles, реализующий взаимодействие
 * с формами изменения роли пользователя.
 */

@WebServlet(name="ChangeRoles", urlPatterns="/JavaChangeRoles")
public class ChangeRoles extends HttpServlet {
	
	/**
	 * Метод, создающий экземпляр класса Roles 
	 * для считывания данных с формы ввода роли пользователя,
	 * и изменения данных в файле
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Roles roles = Roles.fromRequestParameters(request);
		roles.readFromBuffer();
		String name = roles.getName();
		String role = roles.getRole();
		
		roles.findUser(role,name);
		roles.writer();
		roles.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/FindUser.jsp").forward(request, response);
	}

}
