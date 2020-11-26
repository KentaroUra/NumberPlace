package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userDAO;
import model.User;

/**
 * ユーザ登録に関するリクエストを処理するコントローラ
 */
@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ユーザ登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String newUser = request.getParameter("new_user");
		String newPass = request.getParameter("new_pass");

		User user = new User(newUser, newPass);
		userDAO dao = new userDAO();

		// 登録処理
		if (newUser.length() != 0 && newPass.length() != 0) {
			Map<String, String> userMap = (Map<String, String>) request.getAttribute("userMap");

			// ユーザーリストがリクエストスコープに
			// 存在しなければ新規でインスタンスを作成
			if (userMap == null) {
				userMap = new HashMap<String, String>();
			}

			// これから登録するユーザー名がすでに登録済みか調べる
			// 登録されていなければ、登録処理を行う。
			Map<String, String> sRecords = new HashMap();
			sRecords = dao.selectAll();
			boolean b = true;

			//追加するためにデータベースが空であるかを調べる
			if(sRecords.isEmpty()) {

				// 新規ユーザを追加したユーザーリストを、リクエストスコープに再登録
				userMap.put(newUser, newPass);
				request.setAttribute("userMap", userMap);
				b = dao.entry(user);

				// 登録完了メッセージをリクエストスコープに保存
				request.setAttribute("message", "登録が完了しました");

			}else {

				for (String s : sRecords.keySet()) {
					if (sRecords.containsKey(newUser)) {
						// エラーメッセージをリクエストスコープに保存
						request.setAttribute("message", "そのユーザーは既に登録されています。");

					} else {
						if (b) {
							// 新規ユーザを追加したユーザーリストをリクエストスコープに再登録

							userMap.put(newUser, newPass);
							request.setAttribute("userMap", userMap);
							b = dao.entry(user);

							// 登録完了メッセージをリクエストスコープに保存
							request.setAttribute("message", "登録が完了しました");
						}
					}
				}
			}

		} else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("message", "ユーザー名、パスワードは必須項目です");
		}

		// フォワード処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
		dispatcher.forward(request, response);
	}
}
