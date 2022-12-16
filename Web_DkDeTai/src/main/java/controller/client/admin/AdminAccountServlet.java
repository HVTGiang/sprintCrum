package controller.client.admin;

import DAO.AccountDAO;
import DAO.PersonDAO;
import model.Account;
import model.Person;
import service.AccountService;
import service.PersonService;
import service.SuperService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminAccountServlet", value = "/admin/account")
public class AdminAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getInfoForAdminAccountPage(request, response);

        /*Service để thực hiện ba cái chuyển trang đồ đó*/
        SuperService service = new SuperService(request, response);


        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        String message = request.getParameter("message");

        switch (action) {
            case "home":
                service.forwardToPage("/default/admin/account.jsp");
                break;
            case "insert":
//                actionInsert(request, response);
                request.setAttribute("action", "insert");
                service.forwardToPage("/default/admin/account-form.jsp");
                break;
            case "edit":
                actionEdit(request, response);
                service.forwardToPage("/default/admin/account-form.jsp");
                break;
           /* case "find":
//                actionFind(request, response);
//                service.forwardToPage("/default/admin/account.jsp");
                break;*/
            default:
                service.redirectToPage("/admin/account");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getInfoForAdminAccountPage(request, response);

        /*Service để thực hiện ba cái chuyển trang đồ đó*/
        SuperService service = new SuperService(request, response);

        String action = request.getParameter("action");
        if (action == null) {
            action = new String("home");
        }
        String message = request.getParameter("message");

        switch (action) {
            case "home":
                service.forwardToPage("/default/admin/account.jsp");
                break;
            case "insert":
//                actionInsert(request, response);
                request.setAttribute("action", "insert");
                service.forwardToPage("/default/admin/account-form.jsp");
                break;
            case "save":
                actionSave(request, response);
                break;
           /* case "find":
//                actionFind(request, response);
//                service.forwardToPage("/default/admin/account.jsp");
                break;*/
            default:
                service.redirectToPage("/admin/account");
                break;
        }
    }

    private void getInfoForAdminAccountPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Chỗ này sẽ lấy các thông tin cần hiển thị lên trên home page của admin*/
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        /*Lấy danh sách các hội đồng hiện có*/
        AccountDAO accountDAO = new AccountDAO();
        List<Account> accountList = accountDAO.findAll();
        PersonService personService = new PersonService();
        /*personService.InsertPersonIntoAccountList(accountList);*/

        request.setAttribute("accountList", accountList);
    }

    private void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("action", "edit");

        //Lấy account có accountID đang được chỉnh sửa
        AccountDAO accountDAO = new AccountDAO();
        PersonService personService = new PersonService();
        /*Lấy cái id ra nè*/
        String accountID = request.getParameter("accountId");
        List<Account> accountList = new ArrayList<>();
        /*Tìm cái account*/
        Account account = accountDAO.find(accountID);
        /*Tà đạo để gắn person vào trong cái account*/
        accountList.add(account);
        /*personService.InsertPersonIntoAccountList(accountList);*/
        account = accountList.get(0);

        request.setAttribute("account", account);
    }

    private void actionSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        AccountService accountService = new AccountService();
        AccountDAO accountDAO = new AccountDAO();
        PersonDAO personDAO = new PersonDAO();
        PersonService personService = new PersonService();
        /*Service để thực hiện ba cái chuyển trang đồ đó*/
        SuperService service = new SuperService(request, response);
        String randomID;

        String accountFullName = request.getParameter("accountFullName");
        String accountUsername = request.getParameter("accountUsername");
        String accountPassword = request.getParameter("accountPassword");
        String accountGender = request.getParameter("accountGender");
        String accountPhone = request.getParameter("accountPhone");
        String accountEmail = request.getParameter("accountEmail");
        String accountRole = request.getParameter("accountRole");
        String accountAddress = request.getParameter("accountAddress");

        if (!accountFullName.equals("") && !accountUsername.equals("") && !accountPassword.equals("") && !accountPhone.equals("") && !accountEmail.equals("") && !accountRole.equals("")) {
            Person person = new Person();
/*            if (!committeeId.equals("")) {
                committe.setCommitteId(committeeId);
            }*/
            person.setFullName(accountFullName);
            if (accountGender.equals("male")) {
                person.setGender( (byte) 1);
            } else {
                person.setGender((byte) 2);
            }
            person.setEmail(accountEmail);
            person.setPhonenumber(accountPhone);
            person.setRole(accountRole);
            person.setAddress(accountAddress);

            do {
                randomID = personDAO.randomId();
                person.setPersonId(randomID);
            } while (!personService.checkIdAvailable(person));

            Account account = new Account();
            account.setPerson(person);
            account.setUsername(accountUsername);
            account.setPassword(accountPassword);
            /*account.setPersonID(person.getPersonId());*/

            if (!"OK".equals(personService.checkInputData(person))) {
                String message = personService.checkInputData(person);
                request.setAttribute("message", message);
                request.setAttribute("account", account);
                request.setAttribute("action", "insert");
                service.forwardToPage("/default/admin/account-form.jsp");
            } else {
                if (account.getAccountId() == null) {
                    do {
                        randomID = accountDAO.randomId();
                        account.setAccountId(randomID);
                    } while (!accountService.checkIdAvailable(account));
                    /*Kiểm tra sđt có bị trùng hay không*/
                    if (!"OK".equals(personService.checkPhoneAvailable(person))) {
                        String message = personService.checkPhoneAvailable(person);
                        request.setAttribute("message", message);
                        request.setAttribute("account", account);
                        request.setAttribute("action", "insert");
                        service.forwardToPage("/default/admin/account-form.jsp");
                        /*Kiểm tra email có bị trùng hay không*/
                    } else if (!"OK".equals(personService.checkEmailAvailable(person))) {
                        String message = personService.checkEmailAvailable(person);
                        request.setAttribute("message", message);
                        request.setAttribute("account", account);
                        request.setAttribute("action", "insert");
                        service.forwardToPage("/default/admin/account-form.jsp");
                        /*Kiểm tra username có bị trùng hay không*/
                    } else if (!"OK".equals(accountService.checkUsernameAvailable(account))) {
                        String message = accountService.checkUsernameAvailable(account);
                        request.setAttribute("message", message);
                        request.setAttribute("account", account);
                        request.setAttribute("action", "insert");
                        service.forwardToPage("/default/admin/account-form.jsp");
                    } else {
                        try {
                            personDAO.create(person);
                            accountDAO.create(account);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String message = new String("Vừa thêm tài khoản của <b> " + person.getFullName() + "</b>");
                        request.setAttribute("message", message);
                        getInfoForAdminAccountPage(request, response);
                        service.forwardToPage("/default/admin/account.jsp");
                    }
                }
                /*Tạo tài khoản*//*try {
                        committeeDAO.update(committe);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String message = new String("Vừa cập nhật hội đồng <b>" + committe.getCommitteName() + "</b>");
                    request.setAttribute("message", message);
                    getInfoForAdminAccountPage(request, response);
                    service.forwardToPage("/default/admin/account.jsp");*/
            }
        }
    }
}
