package model;

import java.io.Serializable;

public class User implements Serializable {
	private String user_id;
	private String user_name;
	private String password;
	private int score;
	private int clearstage_no;

	public User(String user_id, String user_name, String password, int score) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.score = score;
	}

	public User(String user_id, String user_name, String password, int score, int clearstage_no) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.score = score;
		this.clearstage_no = clearstage_no;
	}
	public User(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}
	public User(String user_name, int score) {
		this.user_name = user_name;
		this.score = score;
	}

	// setter
	public void setUser_id(String user_id) {
		this.user_id = user_id;

	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;

	}

	public void setPassword(String password) {
		this.password = password;

	}

	public void setScore(int score) {
		this.score = score;

	}

	public void setClearstage_no(int clearstage_no) {
		this.clearstage_no = clearstage_no;
	}

	// getter
	public String getUserId() {
		return user_id;
	}

	public String getUserName() {
		return user_name;
	}

	public String getPassword() {
		return password;
	}

	public int getScore() {
		return score;
	}

	public int getClearStageNumber() {
		return clearstage_no;
	}

}
