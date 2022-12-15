package controller.client.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.HomeService;

@WebServlet(value = {"/admin/home","/admin"}, name = "HomeAdmin")
public class HomeAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public HomeAdmin() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*Cái này là gọi cái dịch vụ home ra để chuyển đến trang home của từng role*/
        HomeService home = new HomeService(request, response);
        /*Chuyển đến trên home của admin*/
        home.handleGetAdminHomeService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /*Hàm load thông tin cho trang chủ admin*/
    private void getInfoForAdminHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Chỗ này sẽ lấy các thông tin cần hiển thị lên trên home page của admin*/
    }

}