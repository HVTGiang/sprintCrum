import DAO.AccountDAO;
import DAO.AdminDAO;
import DAO.CommitteeDAO;
import model.Account;
import model.Admin;
import model.Committe;
import service.AdminService;
import service.CommitteeService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        CommitteeDAO committeeDAO = new CommitteeDAO();
//        List<Committe> committeList = committeeDAO.findAll();
//        for (Committe acc : committeList
//        ) {
//            System.out.println(acc.getDescription());
//        }

        CommitteeDAO committeeDAO = new CommitteeDAO();
        Committe committe = committeeDAO.find("cmt00001");
        CommitteeService committeeService = new CommitteeService();
        System.out.println(committeeService.findCommitteeByName(committe).get(0).getCommitteName());

    }
}
