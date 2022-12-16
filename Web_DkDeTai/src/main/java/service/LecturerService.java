package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LecturerDAO;
import model.Lecturer;
import model.Person;

public class LecturerService extends SuperService{
	private static final LecturerDAO LecturerDAO = new LecturerDAO();

	public LecturerService(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	
	public static Lecturer getLecturerByPerson(Person person) {
		Lecturer pLecturer = null;
		Map<String, Object> maping = new HashMap<String, Object>();
		maping.put("p", person);
		if (LecturerDAO.findWithNamedQuery("Lecturer.findLecturerByPerson", maping).size() >0 )
		{
			pLecturer = LecturerDAO.findWithNamedQuery("Lecturer.findLecturerByPerson", maping).get(0);
		}
		return pLecturer;
	}
}
