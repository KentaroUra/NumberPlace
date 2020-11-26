package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NumberPlaceObject;

public class NumberPlaceQuestionDAO {

	/**
	 * 「qestion」テーブルへのアクセスを担当する
	 * DAOクラスです。
	 */
	private final String URL = "jdbc:postgresql://localhost:5433/kino_numberplace";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

	/**
	 * 「question」テーブルから出題用ゲームデータを検索し
	 * 返します。
	 */
	public List<NumberPlaceObject> q_selectDAO(int playstage_no) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<NumberPlaceObject> q_gamedatalist = null;

		try {
			/* JDBCドライバの定義 */
			Class.forName("org.postgresql.Driver");

			/* PostgreSQLへの接続 */
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			/* SELECT文の準備 */
			String sql = "SELECT * FROM question ";

			sql += "where question_id = ?;";

			st = con.prepareStatement(sql);
       	 	st.setInt(1, playstage_no);

			/* SELECT文の実行 */
			rs = st.executeQuery();

			/* 結果をリストに移し替える */
			q_gamedatalist = makeResultData(rs);


		} catch(Exception e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			/* PostgreSQLとの接続を切断 */
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}

        return q_gamedatalist;
    }


    public List<NumberPlaceObject> makeResultData(ResultSet rs) throws Exception {


       	// 検索結果を格納するリストを準備
    	List<NumberPlaceObject> q_gamedatalist = new ArrayList<NumberPlaceObject>();

    	while(rs.next()) {

    	//変数の初期化
        	int question_id = 0;
        	int block01 = 0;
        	int block02 = 0;
        	int block03 = 0;
        	int block04 = 0;
        	int block05 = 0;
        	int block06 = 0;
        	int block07 = 0;
        	int block08 = 0;
        	int block09 = 0;
        	int block10 = 0;
        	int block11 = 0;
        	int block12 = 0;
        	int block13 = 0;
        	int block14 = 0;
        	int block15 = 0;
        	int block16 = 0;
        	int block17 = 0;
        	int block18 = 0;
        	int block19 = 0;
        	int block20 = 0;
        	int block21 = 0;
        	int block22 = 0;
        	int block23 = 0;
        	int block24 = 0;
        	int block25 = 0;
        	int block26 = 0;
        	int block27 = 0;
        	int block28 = 0;
        	int block29 = 0;
        	int block30 = 0;
        	int block31 = 0;
        	int block32 = 0;
        	int block33 = 0;
        	int block34 = 0;
        	int block35 = 0;
        	int block36 = 0;
        	int block37 = 0;
        	int block38 = 0;
        	int block39 = 0;
        	int block40 = 0;
        	int block41 = 0;
        	int block42 = 0;
        	int block43 = 0;
        	int block44 = 0;
        	int block45 = 0;
        	int block46 = 0;
        	int block47 = 0;
        	int block48 = 0;
        	int block49 = 0;
        	int block50 = 0;
        	int block51 = 0;
        	int block52 = 0;
        	int block53 = 0;
        	int block54 = 0;
        	int block55 = 0;
        	int block56 = 0;
        	int block57 = 0;
        	int block58 = 0;
        	int block59 = 0;
        	int block60 = 0;
        	int block61 = 0;
        	int block62 = 0;
        	int block63 = 0;
        	int block64 = 0;
        	int block65 = 0;
        	int block66 = 0;
        	int block67 = 0;
        	int block68 = 0;
        	int block69 = 0;
        	int block70 = 0;
        	int block71 = 0;
        	int block72 = 0;
        	int block73 = 0;
        	int block74 = 0;
        	int block75 = 0;
        	int block76 = 0;
        	int block77 = 0;
        	int block78 = 0;
        	int block79 = 0;
        	int block80 = 0;
        	int block81 = 0;

        		// ゲームデータを読込む
        	question_id = rs.getInt("question_id");
        	block01 = rs.getInt("block01");
        	block02 = rs.getInt("block02");
        	block03 = rs.getInt("block03");
        	block04 = rs.getInt("block04");
        	block05 = rs.getInt("block05");
        	block06 = rs.getInt("block06");
        	block07 = rs.getInt("block07");
        	block08 = rs.getInt("block08");
        	block09 = rs.getInt("block09");
        	block10 = rs.getInt("block10");
        	block11 = rs.getInt("block11");
        	block12 = rs.getInt("block12");
        	block13 = rs.getInt("block13");
        	block14 = rs.getInt("block14");
        	block15 = rs.getInt("block15");
        	block16 = rs.getInt("block16");
        	block17 = rs.getInt("block17");
        	block18 = rs.getInt("block18");
        	block19 = rs.getInt("block19");
        	block20 = rs.getInt("block20");
        	block21 = rs.getInt("block21");
        	block22 = rs.getInt("block22");
        	block23 = rs.getInt("block23");
        	block24 = rs.getInt("block24");
        	block25 = rs.getInt("block25");
        	block26 = rs.getInt("block26");
        	block27 = rs.getInt("block27");
        	block28 = rs.getInt("block28");
        	block29 = rs.getInt("block29");
        	block30 = rs.getInt("block30");
        	block31 = rs.getInt("block31");
        	block32 = rs.getInt("block32");
        	block33 = rs.getInt("block33");
        	block34 = rs.getInt("block34");
        	block35 = rs.getInt("block35");
        	block36 = rs.getInt("block36");
        	block37 = rs.getInt("block37");
        	block38 = rs.getInt("block38");
        	block39 = rs.getInt("block39");
        	block40 = rs.getInt("block40");
        	block41 = rs.getInt("block41");
        	block42 = rs.getInt("block42");
        	block43 = rs.getInt("block43");
        	block44 = rs.getInt("block44");
        	block45 = rs.getInt("block45");
        	block46 = rs.getInt("block46");
        	block47 = rs.getInt("block47");
        	block48 = rs.getInt("block48");
        	block49 = rs.getInt("block49");
        	block50 = rs.getInt("block50");
        	block51 = rs.getInt("block51");
        	block52 = rs.getInt("block52");
        	block53 = rs.getInt("block53");
        	block54 = rs.getInt("block54");
        	block55 = rs.getInt("block55");
        	block56 = rs.getInt("block56");
        	block57 = rs.getInt("block57");
        	block58 = rs.getInt("block58");
        	block59 = rs.getInt("block59");
        	block60 = rs.getInt("block60");
        	block61 = rs.getInt("block61");
        	block62 = rs.getInt("block62");
        	block63 = rs.getInt("block63");
        	block64 = rs.getInt("block64");
        	block65 = rs.getInt("block65");
        	block66 = rs.getInt("block66");
        	block67 = rs.getInt("block67");
        	block68 = rs.getInt("block68");
        	block69 = rs.getInt("block69");
        	block70 = rs.getInt("block70");
        	block71 = rs.getInt("block71");
        	block72 = rs.getInt("block72");
        	block73 = rs.getInt("block73");
        	block74 = rs.getInt("block74");
        	block75 = rs.getInt("block75");
        	block76 = rs.getInt("block76");
        	block77 = rs.getInt("block77");
        	block78 = rs.getInt("block78");
        	block79 = rs.getInt("block79");
        	block80 = rs.getInt("block80");
        	block81 = rs.getInt("block81");



        	// 1行分のデータを格納するインスタンス
        	NumberPlaceObject q_gamedata
        	= new NumberPlaceObject(
        			question_id,
        			block01,
        			block02,
        			block03,
        			block04,
        			block05,
        			block06,
        			block07,
        			block08,
        			block09,
        			block10,
        			block11,
        			block12,
        			block13,
        			block14,
        			block15,
        			block16,
        			block17,
        			block18,
        			block19,
        			block20,
        			block21,
        			block22,
        			block23,
        			block24,
        			block25,
        			block26,
        			block27,
        			block28,
        			block29,
        			block30,
        			block31,
        			block32,
        			block33,
        			block34,
        			block35,
        			block36,
        			block37,
        			block38,
        			block39,
        			block40,
        			block41,
        			block42,
        			block43,
        			block44,
        			block45,
        			block46,
        			block47,
        			block48,
        			block49,
        			block50,
        			block51,
        			block52,
        			block53,
        			block54,
        			block55,
        			block56,
        			block57,
        			block58,
        			block59,
        			block60,
        			block61,
        			block62,
        			block63,
        			block64,
        			block65,
        			block66,
        			block67,
        			block68,
        			block69,
        			block70,
        			block71,
        			block72,
        			block73,
        			block74,
        			block75,
        			block76,
        			block77,
        			block78,
        			block79,
        			block80,
        			block81
        			);
        		q_gamedatalist.add(q_gamedata);
        	}

        return q_gamedatalist;

        }
    }
