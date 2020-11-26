package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.NumberPlaceLogic;
import model.NumberPlaceObject;
import model.User;


@WebServlet("/Main_numberplace_start")
public class Main_numberplace_start extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//セッションスコープのログインユーザーのクリアステージIDを取得
		User user = (User) session.getAttribute("user");

		System.out.println(user.getClearStageNumber());
		int clearstage_no = user.getClearStageNumber();
		int playstage_no = clearstage_no + 1;

		if(playstage_no > 50) {
			response.sendRedirect("/kino_NumberPlace/allclear.jsp");
		}else
		{

		//logicクラスのインスタンス生成、q_executeSelectメソッド実行（＝daoクラスのsqlのセレクトメソッドを実行してナンプレの問題をデータベースより取得）
		//取得したゲームデータをq_gamedatalist（リスト）に入れる
		NumberPlaceLogic a = new NumberPlaceLogic();
		List<NumberPlaceObject> q_gamedatalist = a.q_executeSelect(playstage_no);

		//q_gamedatalist（リスト）からq_gamedata（ゲームデータ単体）を取り出す
		NumberPlaceObject q_gamedata = q_gamedatalist.get(0);


		//ゲームデータ（単体）をリクエストスコープへ保存
		session.setAttribute("q_gamedata",q_gamedata );

		//回答内容を入力するためのデータ作成
		NumberPlaceObject input_number = new NumberPlaceObject(
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0,
				  0
		);

		//入力内容をセッションスコープに入れる
		session.setAttribute("input_number",input_number);

		//判定結果を作成 ※nullにて初期化
		String game_judge = null;

		//判定結果をセッションスコープに保存
		session.setAttribute("game_judge",game_judge);

		//main_numberplace.jspへ移動
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/main_numberplace.jsp");
		dispatcher.forward(request, response);
		}
	}
}