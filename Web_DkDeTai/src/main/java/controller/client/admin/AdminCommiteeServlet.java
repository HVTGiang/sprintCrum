package controller.client.admin;

import DAO.CommitteeDAO;
import model.Committe;
import service.CommitteeService;
import service.SuperService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
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
        String message = request.getParameter("message");

        switch (action) {
            case "home":
                service.forwardToPage("/default/admin/committee.jsp");
                break;
            case "insert":
                actionInsert(request, response);
                service.forwardToPage("/default/admin/committee-form.jsp");
                break;
            case "edit":
                actionEdit(request, response);
                service.forwardToPage("/default/admin/committee-form.jsp");
                break;
            case "find":
                actionFind(request, response);
                service.forwardToPage("/default/admin/committee.jsp");
                break;
            default:
                service.redirectToPage("/admin/committee");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "save":
                actionSave(request, response);
                break;
            default:
                service.redirectToPage("/admin/committee");
                break;
        }
    }

    /*Hàm load thông tin cho trang committee của admin*/
    private void getInfoForAdminCommitteePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Chỗ này sẽ lấy các thông tin cần hiển thị lên trên home page của admin*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*Lấy danh sách các hội đồng hiện có*/
        CommitteeDAO committeeDAO = new CommitteeDAO();
        List<Committe> committeList = committeeDAO.findAll();
        request.setAttribute("committeList", committeList);
    }

    private void actionInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "insert");
    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "edit");

        String committeeId = request.getParameter("committeeId");
        CommitteeDAO committeeDAO = new CommitteeDAO();
        Committe selectedCommitte = committeeDAO.find(committeeId);
        request.setAttribute("committee", selectedCommitte);
    }

    private void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        CommitteeService committeeService = new CommitteeService();
        CommitteeDAO committeeDAO = new CommitteeDAO();
        /*Service để thực hiện ba cái chuyển trang đồ đó*/
        SuperService service = new SuperService(request, response);
        String randomID;

        String committeeId = request.getParameter("committeeId");
        String committeeName = request.getParameter("committeeName");
        String committeeNumber = request.getParameter("committeeNumber");
        String description = request.getParameter("description");
        String reportDate = request.getParameter("committeeReportDate");

        if (!committeeName.equals("") && !committeeNumber.equals("")) {
            Committe committe = new Committe();
            if (!committeeId.equals("")) {
                committe.setCommitteId(committeeId);
            }
            committe.setCommitteName(committeeName);
            committe.setNumMember(Integer.parseInt(committeeNumber));
            committe.setDescription(description);

            Date date = Date.valueOf(reportDate);
            committe.setReportDate(date);

            if (!"OK".equals(committeeService.checkInputData(committe))) {
                String message = committeeService.checkInputData(committe);
                request.setAttribute("message", message);
                request.setAttribute("committee", committe);
                service.forwardToPage("/default/admin/committee-form.jsp");
            } else {
                if (committe.getCommitteId() == null) {

                    do {
                        randomID = committeeDAO.randomId();
                        committe.setCommitteId(randomID);
                        System.out.println(randomID);
                    } while (!committeeService.checkIdAvailable(committe));

                    if (!"OK".equals(committeeService.checkNameAvailable(committe))) {
                        String message = committeeService.checkNameAvailable(committe);
                        request.setAttribute("message", message);
                        request.setAttribute("committee", committe);
                        service.forwardToPage("/default/admin/committee-form.jsp");
                    } else {
                        try {
                            committeeDAO.create(committe);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String message = new String("Vừa thêm hội đồng <b> " + committe.getCommitteName() + "</b>");
                        request.setAttribute("message", message);
                        getInfoForAdminCommitteePage(request, response);
                        service.forwardToPage("/default/admin/committee.jsp");
                    }

                } else {
                    try {
                        committeeDAO.update(committe);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String message = new String("Vừa cập nhật hội đồng <b>" + committe.getCommitteName() + "</b>");
                    request.setAttribute("message", message);
                    getInfoForAdminCommitteePage(request, response);
                    service.forwardToPage("/default/admin/committee.jsp");
                }
            }
        }
    }

    private void actionFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Chỗ này sẽ lấy các thông tin cần hiển thị lên trên home page của admin*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /*Lấy danh sách các hội đồng hiện có*/

        String findString = request.getParameter("find");
        CommitteeService committeeService = new CommitteeService();
        List<Committe> committeList = committeeService.findByName(findString);
        request.setAttribute("committeList", committeList);
    }
}
