package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cancel
 */
@WebServlet("/Main_numberplace_cancel")
public class Main_numberplace_cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession(true);

    	session.invalidate();

		//main_numberplace.jspへ移動
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/main_numberplace.jsp");
		dispatcher.forward(request, response);
	}
}