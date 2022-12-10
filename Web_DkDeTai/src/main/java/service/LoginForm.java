package connectdatabase;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginForm
 */
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		String quyen=request.getParameter("quyen");
		PrintWriter writer=response.getWriter();
		HttpSession session =request.getSession();
		User user = CheckUser.getUser(username);
		if(user!=null)
		{
			if(password !=null)
			{
				if(password.equals(user.getPassWord()))
				{
					if(user.getQuyen()=="sinhvien")
					{
						session.setAttribute("user", user);
					response.sendRedirect("Actor_SinhVien.jsp");
					}
					if(user.getQuyen()=="giaovien")
					{
						session.setAttribute("user", user);
					response.sendRedirect("Actor_GiaoVien.jsp");
					}
					if(user.getQuyen()=="nhanvienql")
					{
						session.setAttribute("user", user);
					response.sendRedirect("Actor_NhanVien.jsp");
					}
					if(user.getQuyen()=="admin")
					{
						session.setAttribute("user", user);
					response.sendRedirect("Actor_Admin.jsp");
					}
					if(user.getQuyen()=="lanhdao")
					{
						session.setAttribute("user", user);
					response.sendRedirect("Actor_NhanVien.jsp");
					}
				}
				else
				{
					response.sendRedirect("home");	
				}
			}
			else
			{
				response.sendRedirect("home");	
			}
		}
		else
		{
			response.sendRedirect("home");	
		}
	}

}
