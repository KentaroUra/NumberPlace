package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.User;

public class userDAO {
	// データベース接続に使用する情報
	private final String URL = "jdbc:postgresql://localhost:5433/kino_numberplace";
	private final String USER = "postgres";
	private final String PASSWORD = "test";
	//?
	public boolean entry(User user) {
		boolean b = false;

		//データベース接続
		Connection con = null;
		PreparedStatement pStmt = null;

		try {
			/* JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			/* INSERT文の準備 */
			String sql = "INSERT INTO PLAYUSER(USER_NAME, PASSWORD,score) VALUES(?, ?,0); ";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, user.getPassword());

			/* INSERT文の実行 */
			pStmt.executeUpdate();
			b = false;
			return b;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			/* PostgreSQLとの接続を切断 */
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}
		return b;
	}

	public Map<String, String> selectAll() {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		Map<String, String> sRecords = null;

		try {
			/* JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			/* SELECT文の準備 */
			String sql = "SELECT * FROM PLAYUSER; ";
			st = con.prepareStatement(sql);

			/* SELECT文の実行 */
			rs = st.executeQuery();

			/* 結果をリストに移し替える */
			sRecords = makeResultData(rs);

		} catch (Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			/* PostgreSQLとの接続を切断 */
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

		return sRecords;
	}

	public Map<String, String> makeResultData(ResultSet rs) throws Exception {


		Map<String, String> sRecords = new HashMap();

		while (rs.next()) {
			// 1行分のデータを読込む
			String user_name = rs.getString("user_name");
			String password = rs.getString("password");

			// 1行分のデータを格納するインスタンス
			User sRecord = new User(user_name,
					password);

			// リストに1行分のデータを追加する
			sRecords.put(user_name, password);
		}
		return sRecords;
	}
}