package model;

import java.util.List;

import dao.NumberPlaceAnswerDAO;
import dao.NumberPlaceDAO;
import dao.NumberPlaceQuestionDAO;

public class NumberPlaceLogic {

	public List<NumberPlaceObject> q_executeSelect(int clearstage_no) {

		NumberPlaceQuestionDAO questiondao = new NumberPlaceQuestionDAO();
		List<NumberPlaceObject> q_gamedatalist = questiondao.q_selectDAO(clearstage_no);

		return q_gamedatalist;

	}

	public List<NumberPlaceObject> a_executeSelect(int clearstage_no) {

		NumberPlaceAnswerDAO answerdao = new NumberPlaceAnswerDAO();
		List<NumberPlaceObject> a_gamedatalist = answerdao.a_selectDAO(clearstage_no);

		return a_gamedatalist;
	}

	public void addPoint(String name) {
		NumberPlaceDAO dao = new NumberPlaceDAO();
		dao.addPoint(name);
	}

	public void updateClearStageNo(String name) {
		NumberPlaceDAO dao = new NumberPlaceDAO();
		dao.updateClearStageNo(name);
	}

}