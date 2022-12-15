import DAO.AccountDAO;
import DAO.CommitteeDAO;
import model.Account;
import model.Committe;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CommitteeDAO committeeDAO = new CommitteeDAO();
        List<Committe> committeList = committeeDAO.findAll();
        for (Committe acc : committeList
        ) {
            System.out.println(acc.getDescription());
        }
    }
}
