

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Класс For3dModel для отображения 3d модели окна.
 */
@WebServlet(name="For3dModel", urlPatterns="/For3dModel")
public class For3dModel extends HttpServlet {
/**
 * Поле для хранения типа выбранного отображения модели
 */
	static int a = 0;
 
	/**
	 * Метод для создания экземпляра класса Reader, 
	 * считывания данных с формы выбора типа отображения модели 
	 * и перехода на соответвующую форму
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reader roles = Reader.fromRequestParameters(request);
		roles.checker();
		a = roles.getA();
		if (a == 1) {
			request.getRequestDispatcher("/Pause.jsp").forward(request, response);
		}
		if (a == 2)
		{
			request.getRequestDispatcher("/3dModel.jsp").forward(request, response);
		}
		if (a == 3)
		{
			request.getRequestDispatcher("/Left3dModel.jsp").forward(request, response);
		}
	}
 
}
