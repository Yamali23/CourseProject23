package start;
import javax.servlet.http.HttpServletRequest;

/**
  * 
  * Класс Reader для обработки введенных с формы данных
  *
  */
	public class Reader{
		/**
		 * Поле для хранение переменной для варианта выбора 
		 */
		private int a = 0;
		/**
		 * Строка для хранения введенного на форму значения
		 */
		private String ls = " ";
		/**
		 * Метод, возвращающий параметр а
		 * @return а
		 */
		public int getA()
		{
			return a;
		}
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
	
