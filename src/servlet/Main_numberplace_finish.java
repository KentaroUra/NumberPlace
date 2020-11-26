package servlet;

import java.io.IOException;
import java.util.Arrays;
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

@WebServlet("/Main_numberplace_finish")
public class Main_numberplace_finish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("/kino_NumberPlace/result.jsp");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープの領域確保
		HttpSession session = request.getSession();

		//回答内容を入れるための配列を準備
		String[] input_numbers = new String[81];

		// セッションスコープよりプレイユーザーのデータを取得
		User clear_user = (User) session.getAttribute("user");

		//フォームから受信したデータ（=ゲームの回答内容）をnumbersに代入
		input_numbers = request.getParameterValues("ans");

		//input_numbersに代入したデータをNumberPlaceObject型のフィールドに代入
		NumberPlaceObject input_number = new NumberPlaceObject(
				0,
				Integer.parseInt(input_numbers[0]),
				Integer.parseInt(input_numbers[1]),
				Integer.parseInt(input_numbers[2]),
				Integer.parseInt(input_numbers[3]),
				Integer.parseInt(input_numbers[4]),
				Integer.parseInt(input_numbers[5]),
				Integer.parseInt(input_numbers[6]),
				Integer.parseInt(input_numbers[7]),
				Integer.parseInt(input_numbers[8]),
				Integer.parseInt(input_numbers[9]),
				Integer.parseInt(input_numbers[10]),
				Integer.parseInt(input_numbers[11]),
				Integer.parseInt(input_numbers[12]),
				Integer.parseInt(input_numbers[13]),
				Integer.parseInt(input_numbers[14]),
				Integer.parseInt(input_numbers[15]),
				Integer.parseInt(input_numbers[16]),
				Integer.parseInt(input_numbers[17]),
				Integer.parseInt(input_numbers[18]),
				Integer.parseInt(input_numbers[19]),
				Integer.parseInt(input_numbers[20]),
				Integer.parseInt(input_numbers[21]),
				Integer.parseInt(input_numbers[22]),
				Integer.parseInt(input_numbers[23]),
				Integer.parseInt(input_numbers[24]),
				Integer.parseInt(input_numbers[25]),
				Integer.parseInt(input_numbers[26]),
				Integer.parseInt(input_numbers[27]),
				Integer.parseInt(input_numbers[28]),
				Integer.parseInt(input_numbers[29]),
				Integer.parseInt(input_numbers[30]),
				Integer.parseInt(input_numbers[31]),
				Integer.parseInt(input_numbers[32]),
				Integer.parseInt(input_numbers[33]),
				Integer.parseInt(input_numbers[34]),
				Integer.parseInt(input_numbers[35]),
				Integer.parseInt(input_numbers[36]),
				Integer.parseInt(input_numbers[37]),
				Integer.parseInt(input_numbers[38]),
				Integer.parseInt(input_numbers[39]),
				Integer.parseInt(input_numbers[40]),
				Integer.parseInt(input_numbers[41]),
				Integer.parseInt(input_numbers[42]),
				Integer.parseInt(input_numbers[43]),
				Integer.parseInt(input_numbers[44]),
				Integer.parseInt(input_numbers[45]),
				Integer.parseInt(input_numbers[46]),
				Integer.parseInt(input_numbers[47]),
				Integer.parseInt(input_numbers[48]),
				Integer.parseInt(input_numbers[49]),
				Integer.parseInt(input_numbers[50]),
				Integer.parseInt(input_numbers[51]),
				Integer.parseInt(input_numbers[52]),
				Integer.parseInt(input_numbers[53]),
				Integer.parseInt(input_numbers[54]),
				Integer.parseInt(input_numbers[55]),
				Integer.parseInt(input_numbers[56]),
				Integer.parseInt(input_numbers[57]),
				Integer.parseInt(input_numbers[58]),
				Integer.parseInt(input_numbers[59]),
				Integer.parseInt(input_numbers[60]),
				Integer.parseInt(input_numbers[61]),
				Integer.parseInt(input_numbers[62]),
				Integer.parseInt(input_numbers[63]),
				Integer.parseInt(input_numbers[64]),
				Integer.parseInt(input_numbers[65]),
				Integer.parseInt(input_numbers[66]),
				Integer.parseInt(input_numbers[67]),
				Integer.parseInt(input_numbers[68]),
				Integer.parseInt(input_numbers[69]),
				Integer.parseInt(input_numbers[70]),
				Integer.parseInt(input_numbers[71]),
				Integer.parseInt(input_numbers[72]),
				Integer.parseInt(input_numbers[73]),
				Integer.parseInt(input_numbers[74]),
				Integer.parseInt(input_numbers[75]),
				Integer.parseInt(input_numbers[76]),
				Integer.parseInt(input_numbers[77]),
				Integer.parseInt(input_numbers[78]),
				Integer.parseInt(input_numbers[79]),
				Integer.parseInt(input_numbers[80]));



		//入力内容をセッションスコープに入れる
		session.setAttribute("input_number", input_number);

		//***** Logic経由でDAOに問い合わせてRDBのanswerデータを取得して正誤判定用の配列に入れる *****
		//answerデータの入ったリストを取得
		NumberPlaceLogic hantei = new NumberPlaceLogic();
		List<NumberPlaceObject> a_gamedatalist = hantei.a_executeSelect(clear_user.getClearStageNumber() + 1);

		//リストからanswerデータを取り出す
		NumberPlaceObject a_gamedata = a_gamedatalist.get(0);

		//answerデータのBlockフィールドを配列に移す
		String[] answer_numbers = new String[81];

		//
		answer_numbers[0] = Integer.toString(a_gamedata.getBlock01());
		answer_numbers[1] = Integer.toString(a_gamedata.getBlock02());
		answer_numbers[2] = Integer.toString(a_gamedata.getBlock03());
		answer_numbers[3] = Integer.toString(a_gamedata.getBlock04());
		answer_numbers[4] = Integer.toString(a_gamedata.getBlock05());
		answer_numbers[5] = Integer.toString(a_gamedata.getBlock06());
		answer_numbers[6] = Integer.toString(a_gamedata.getBlock07());
		answer_numbers[7] = Integer.toString(a_gamedata.getBlock08());
		answer_numbers[8] = Integer.toString(a_gamedata.getBlock09());
		answer_numbers[9] = Integer.toString(a_gamedata.getBlock10());
		answer_numbers[10] = Integer.toString(a_gamedata.getBlock11());
		answer_numbers[11] = Integer.toString(a_gamedata.getBlock12());
		answer_numbers[12] = Integer.toString(a_gamedata.getBlock13());
		answer_numbers[13] = Integer.toString(a_gamedata.getBlock14());
		answer_numbers[14] = Integer.toString(a_gamedata.getBlock15());
		answer_numbers[15] = Integer.toString(a_gamedata.getBlock16());
		answer_numbers[16] = Integer.toString(a_gamedata.getBlock17());
		answer_numbers[17] = Integer.toString(a_gamedata.getBlock18());
		answer_numbers[18] = Integer.toString(a_gamedata.getBlock19());
		answer_numbers[19] = Integer.toString(a_gamedata.getBlock20());
		answer_numbers[20] = Integer.toString(a_gamedata.getBlock21());
		answer_numbers[21] = Integer.toString(a_gamedata.getBlock22());
		answer_numbers[22] = Integer.toString(a_gamedata.getBlock23());
		answer_numbers[23] = Integer.toString(a_gamedata.getBlock24());
		answer_numbers[24] = Integer.toString(a_gamedata.getBlock25());
		answer_numbers[25] = Integer.toString(a_gamedata.getBlock26());
		answer_numbers[26] = Integer.toString(a_gamedata.getBlock27());
		answer_numbers[27] = Integer.toString(a_gamedata.getBlock28());
		answer_numbers[28] = Integer.toString(a_gamedata.getBlock29());
		answer_numbers[29] = Integer.toString(a_gamedata.getBlock30());
		answer_numbers[30] = Integer.toString(a_gamedata.getBlock31());
		answer_numbers[31] = Integer.toString(a_gamedata.getBlock32());
		answer_numbers[32] = Integer.toString(a_gamedata.getBlock33());
		answer_numbers[33] = Integer.toString(a_gamedata.getBlock34());
		answer_numbers[34] = Integer.toString(a_gamedata.getBlock35());
		answer_numbers[35] = Integer.toString(a_gamedata.getBlock36());
		answer_numbers[36] = Integer.toString(a_gamedata.getBlock37());
		answer_numbers[37] = Integer.toString(a_gamedata.getBlock38());
		answer_numbers[38] = Integer.toString(a_gamedata.getBlock39());
		answer_numbers[39] = Integer.toString(a_gamedata.getBlock40());
		answer_numbers[40] = Integer.toString(a_gamedata.getBlock41());
		answer_numbers[41] = Integer.toString(a_gamedata.getBlock42());
		answer_numbers[42] = Integer.toString(a_gamedata.getBlock43());
		answer_numbers[43] = Integer.toString(a_gamedata.getBlock44());
		answer_numbers[44] = Integer.toString(a_gamedata.getBlock45());
		answer_numbers[45] = Integer.toString(a_gamedata.getBlock46());
		answer_numbers[46] = Integer.toString(a_gamedata.getBlock47());
		answer_numbers[47] = Integer.toString(a_gamedata.getBlock48());
		answer_numbers[48] = Integer.toString(a_gamedata.getBlock49());
		answer_numbers[49] = Integer.toString(a_gamedata.getBlock50());
		answer_numbers[50] = Integer.toString(a_gamedata.getBlock51());
		answer_numbers[51] = Integer.toString(a_gamedata.getBlock52());
		answer_numbers[52] = Integer.toString(a_gamedata.getBlock53());
		answer_numbers[53] = Integer.toString(a_gamedata.getBlock54());
		answer_numbers[54] = Integer.toString(a_gamedata.getBlock55());
		answer_numbers[55] = Integer.toString(a_gamedata.getBlock56());
		answer_numbers[56] = Integer.toString(a_gamedata.getBlock57());
		answer_numbers[57] = Integer.toString(a_gamedata.getBlock58());
		answer_numbers[58] = Integer.toString(a_gamedata.getBlock59());
		answer_numbers[59] = Integer.toString(a_gamedata.getBlock60());
		answer_numbers[60] = Integer.toString(a_gamedata.getBlock61());
		answer_numbers[61] = Integer.toString(a_gamedata.getBlock62());
		answer_numbers[62] = Integer.toString(a_gamedata.getBlock63());
		answer_numbers[63] = Integer.toString(a_gamedata.getBlock64());
		answer_numbers[64] = Integer.toString(a_gamedata.getBlock65());
		answer_numbers[65] = Integer.toString(a_gamedata.getBlock66());
		answer_numbers[66] = Integer.toString(a_gamedata.getBlock67());
		answer_numbers[67] = Integer.toString(a_gamedata.getBlock68());
		answer_numbers[68] = Integer.toString(a_gamedata.getBlock69());
		answer_numbers[69] = Integer.toString(a_gamedata.getBlock70());
		answer_numbers[70] = Integer.toString(a_gamedata.getBlock71());
		answer_numbers[71] = Integer.toString(a_gamedata.getBlock72());
		answer_numbers[72] = Integer.toString(a_gamedata.getBlock73());
		answer_numbers[73] = Integer.toString(a_gamedata.getBlock74());
		answer_numbers[74] = Integer.toString(a_gamedata.getBlock75());
		answer_numbers[75] = Integer.toString(a_gamedata.getBlock76());
		answer_numbers[76] = Integer.toString(a_gamedata.getBlock77());
		answer_numbers[77] = Integer.toString(a_gamedata.getBlock78());
		answer_numbers[78] = Integer.toString(a_gamedata.getBlock79());
		answer_numbers[79] = Integer.toString(a_gamedata.getBlock80());
		answer_numbers[80] = Integer.toString(a_gamedata.getBlock81());



		//回答内容のコンソール確認用 ※RDBからの流れがうまくいったら削除してよい***************
		System.out.print("回答内容：");
		for (String number : input_numbers) {
			System.out.print(number);}
		System.out.println();
		//答えの内容を確認
		System.out.print("答え内容：");
		for (String ans : answer_numbers) {
			System.out.print(ans);}
		System.out.println();
		//**************************************************************************************


		//boolean型 判定用変数（game_judge）を定義
		//配列同士で正誤判定、結果を判定変数へ入れる
		//0:初期値  1:正解  2:不正解

		String game_judge = "0";

		if (Arrays.equals(input_numbers, answer_numbers)) {

			game_judge = "1";



			//以下クリア後処理***
			//スコア10pt加点およびクリアステージNoを1つ加算
			NumberPlaceLogic npl = new NumberPlaceLogic();
			clear_user.setScore(clear_user.getScore() + 10);
			clear_user.setClearstage_no(clear_user.getClearStageNumber() + 1);
			npl.addPoint(clear_user.getUserName());
			npl.updateClearStageNo(clear_user.getUserName());

			System.out.println("ユーザー名:" + clear_user.getUserName());
			System.out.println("スコア:" + clear_user.getScore());
			System.out.println("クリアステージNo:" + clear_user.getClearStageNumber());

			//変更した数字をuserに反映させてセッションスコープに保存
			HttpSession session1 = request.getSession();
			session1.setAttribute("user", clear_user);

			//判定結果をセッションスコープに入れる
			session.setAttribute("game_judge", game_judge);

			//main_numberplace.jspへ移動
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
//			dispatcher.forward(request, response);

			response.sendRedirect("/kino_NumberPlace/result.jsp");

		} else {

			game_judge = "2";

			//判定結果をセッションスコープに入れる
			session.setAttribute("game_judge", game_judge);

			//main_numberplace.jspへ移動
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main_numberplace.jsp");
			dispatcher.forward(request, response);

		}
	}
}