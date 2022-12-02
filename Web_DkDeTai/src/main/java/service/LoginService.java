package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SuperService;

public class LoginService extends SuperService{
	public LoginService(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}
	public void handleGetLogin() throws ServletException, IOException {
		String url = "/default/login.jsp";

		super.forwardToPage(url);
		
	}
	public void handlePostLogin() throws ServletException, IOException {
		String url = "/default/login.jsp";

		super.forwardToPage(url);
	}
	
}