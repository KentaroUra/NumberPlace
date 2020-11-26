package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		//ユーザー名、スコアをデータベースから取得しセッションスコープに保存
		LoginLogic loginLogic = new LoginLogic();
		User user = loginLogic.disp(userName);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//ユーザー名とパスワードの確認
		if (!(userName.equals("")) && !(password.equals(""))) {
			//データベースにあるユーザー情報(ユーザー名、パスワード)を取得しArrayListに格納
			ArrayList<User> userList = new ArrayList();
			userList = loginLogic.check();

			/*ArrayListに格納されたユーザー情報とリクエストパラメータで取得した
			 ユーザー名、パスワードを照合し判定*/
			boolean check = true;
			for (User u : userList) {
				System.out.println("入力：" + u.getUserName() + "データ："+userName);
				System.out.println("入力：" + u.getPassword() + "データ："+password);
				//ユーザー名とパスワードが合っていればスタート画面へ
				if (userName.equals(u.getUserName()) &&
						password.equals(u.getPassword())) {
					check = true;
					break;
				}
				if (!userName.equals(u.getUserName()) &&
						!password.equals(u.getPassword())) {
					check = false;
				}
			}
			if (check) {
				//スタート画面へフォワード
				RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main_start.jsp");
				d.forward(request, response);

			} else {
				String message = "ユーザー名もしくはパスワードが間違っています";
				request.setAttribute("message", message);
				RequestDispatcher d = request.getRequestDispatcher("/index.jsp");
				d.forward(request, response);
			}

		}
		//ユーザー名、パスワードの未入力判定
		if (userName.equals("") || password.equals("")) {
			String message1 = "ユーザー名とパスワードは必須項目です";
			request.setAttribute("message1", message1);
			RequestDispatcher d = request.getRequestDispatcher("/index.jsp");
			d.forward(request, response);
		}
	}
}