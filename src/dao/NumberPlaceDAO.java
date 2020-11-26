package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class NumberPlaceDAO {
	final String URL = "jdbc:postgresql://localhost:5433/kino_numberplace";
	final String USER = "postgres";
	final String PASSWORD = "test";

	public ArrayList<User> findAll() {

		ArrayList<User> userList = new ArrayList<User>();
		try {
			/* postgreSQL接続に使用する情報*/
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			/* 2) JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* 3) PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();

			/* select文の準備*/
			String sql = "select user_name, password from playuser";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//sql文を実行し結果表を取得
			rs = pStmt.executeQuery();

			//select文の結果をArrayListに格納
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				String password = rs.getString("password");
				User user = new User(user_name, password);
				userList.add(user);
			}
			// PostgreSQLとの接続を切断 */
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		return userList;
	}

	public List<User> rank() {
		List<User> userList = new ArrayList<User>();
		try {
			/* postgreSQL接続に使用する情報*/
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			/* 2) JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* 3) PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();

			/* select文の準備*/
			String sql = "SELECT user_name, score FROM playuser ORDER BY score DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);

			//sql文を実行し結果表を取得
			rs = pStmt.executeQuery();

			//select文の結果をArrayListに格納
			while (rs.next()) {
				String user_name = rs.getString("user_name");
				int score = rs.getInt("score");
				User user = new User(user_name, score);
				userList.add(user);
			}
			// PostgreSQLとの接続を切断 */
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		return userList;
	}

	public User disp(String name) {
		User user = null;
		try {
			/* postgreSQL接続に使用する情報*/
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			/* 2) JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* 3) PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();

			/* select文の準備*/
			String sql = "SELECT user_id, user_name, password, score, clearstage_no FROM playuser where user_name = ? ; ";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, name);

			//sql文を実行し結果表を取得
			rs = pStmt.executeQuery();

			//select文の結果をArrayListに格納
			while (rs.next()) {
				String user_id = rs.getString("user_id");
				String user_name = rs.getString("user_name");
				String password = rs.getString("password");
				int score = rs.getInt("score");
				int clearstage_no = rs.getInt("clearstage_no");
				user = new User(user_id, user_name, password, score, clearstage_no);
			}

			// PostgreSQLとの接続を切断 */
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("(disp)DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
		return user;
	}

	public void addPoint(String name) {
		try {
			/* postgreSQL接続に使用する情報*/
			Connection con = null;
			Statement st = null;

			/* 2) JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* 3) PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();

			/* select文の準備*/
			//対象プレーヤーの「score」を10 pt　加算するSQL文
			String sql = "UPDATE playuser SET score = score + 10 WHERE user_name = ?";
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, name);
			//sql文を実行
			pStmt.executeUpdate();

			// PostgreSQLとの接続を切断 */
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		}
	}

	public void updateClearStageNo(String name) {
		try {
			/* postgreSQL接続に使用する情報*/
			Connection con = null;
			Statement st = null;

			/* 2) JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* 3) PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			st = con.createStatement();

			/* select文の準備*/
			//対象プレーヤーの「clearstage_no」を更新するSQL文（1ステージ分数字を加算)
			String sql = "UPDATE playuser SET clearstage_no = clearstage_no + 1 WHERE user_name = ? " ;
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, name);
			//sql文を実行
			pStmt.executeUpdate();

			// PostgreSQLとの接続を切断 */
			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();

		}
	}
}