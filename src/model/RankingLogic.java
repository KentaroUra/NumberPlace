package model;

import java.util.ArrayList;
import java.util.List;

import dao.NumberPlaceDAO;

public class RankingLogic {
	public List<User> rank() {
		List<User> userList = new ArrayList();
		NumberPlaceDAO dao = new NumberPlaceDAO();
		userList = dao.rank();
		return userList;
	}
}
