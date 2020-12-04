//コメントアウト入れてみました,git実験
//コメントアウト入れてみました。iuchi
package model;

import java.util.ArrayList;

import dao.NumberPlaceDAO;

public class LoginLogic {
	NumberPlaceDAO dao = new NumberPlaceDAO();
public ArrayList<User> check() {

	ArrayList<User> userList = new ArrayList();
	userList = dao.findAll();
return userList;
}
public User disp(String name) {
User user = null;
	user=dao.disp(name);
	return user;
}
}
