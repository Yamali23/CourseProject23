

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
 /**
  * 
  * Класс Reader для обработки введенных с формы данных
  *
  */
	public static class Reader{
		/**
		 * Строка для хранения введенного на форму значения
		 */
		String ls = " ";
		/**
		 * Конструктор 
		 * @param name - тип отображения модели
		 */
		private Reader (String name) 
		{
			this.ls = name;
		}
		/**
		 * 
		 * Метод для считывания данных с формы
		 */
		public static Reader fromRequestParameters(HttpServletRequest request) 
		{
			return new Reader(
			request.getParameter("number"));
		}
		/**
		 * Метод для проверки значения, которое было выбрано на форме
		 */
		public void checker() 
		{
			
			if (ls.equals("pause")){
				a=1;
			}
			
			if (ls.equals("right")){
				a=2;
			}

			if (ls.equals("left")){
				a=3;
			}
		}
	}
	
}
