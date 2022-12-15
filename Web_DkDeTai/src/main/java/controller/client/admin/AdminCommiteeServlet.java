package controller.client.admin;

import DAO.CommitteeDAO;
import model.Committe;
import service.SuperService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCommiteeServlet", value = "/admin/committee")
public class AdminCommiteeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getInfoForAdminCommitteePage(request, response);

        /*Service để thực hiện ba cái chuyển trang đồ đó*/
        SuperService service = new SuperService(request, response);


        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }

        switch (action) {
            case "home":
                service.forwardToPage("/default/admin/committee.jsp");
                break;
            default:
                service.redirectToPage("/default/admin/committee");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /*Hàm load thông tin cho trang committee của admin*/
    private void getInfoForAdminCommitteePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Chỗ này sẽ lấy các thông tin cần hiển thị lên trên home page của admin*/

        /*Lấy danh sách các hội đồng hiện có*/
        CommitteeDAO committeeDAO = new CommitteeDAO();
        List<Committe> committeList = committeeDAO.findAll();
        request.setAttribute("committeList", committeList);
    }
}
