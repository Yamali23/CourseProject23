package start;


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
 * Классs MaterialCost .
 */
@WebServlet(name="MaterialsCost", urlPatterns="/MaterialsCost")
public class MaterialsCost extends HttpServlet {
	
	/**
	 * Метод для взаимодействия с формой ввода коэффициентов
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Costs costs = Costs.fromRequestParameters(request);
		
		costs.readFromFile();
		costs.writeToFile();
		
		costs.setAsRequestAttributesAndCalculate(request);
		request.getRequestDispatcher("/Materials.jsp").forward(request, response);
	}
	
	
}
