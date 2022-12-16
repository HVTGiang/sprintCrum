package service;

import DAO.AccountDAO;
import model.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountService extends SuperService {

    public static AccountDAO accountDAO = new AccountDAO();

    public AccountService(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public AccountService() {
    }

    public boolean checkIdAvailable(Account account) {
        List<Account> accountList = accountDAO.findAll();
        for (Account a : accountList) {
            if (a.getAccountId().equals(account.getAccountId())) {
                return false;
            }
        }
        return true;
    }

    public String checkUsernameAvailable(Account account) {
        List<Account> accountList = findAccountByUsername(account.getUsername());
        if (accountList.size() > 0) {
            return "Username <b>đã tồn tại</b>! Vui lòng nhập username khác";
        }
        return "OK";
    }

    public List<Account> findAccountByUsername(String username) {
        List<Account> accountList = new ArrayList<>();
        Map<String, Object> maping = new HashMap<String, Object>();
        maping.put("username", username);
        accountList = accountDAO.findByQuery("Account.findByUsername", maping);
        return accountList;
    }
}
