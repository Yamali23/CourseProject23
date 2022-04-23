

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="For3dModel", urlPatterns="/For3dModel")
public class For3dModel extends HttpServlet {
static int a = 0;

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

	public static class Reader{
		String ls = " ";
		private Reader (String name) 
		{
			this.ls = name;
		}
		public static Reader fromRequestParameters(HttpServletRequest request) 
		{
			return new Reader(
			request.getParameter("number"));
		}
		
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
