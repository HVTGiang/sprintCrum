import DAO.AccountDAO;
import model.Account;
import service.PersonService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//        CommitteeDAO committeeDAO = new CommitteeDAO();
//        List<Committe> committeList = committeeDAO.findAll();
//        for (Committe acc : committeList
//        ) {
//            System.out.println(acc.getDescription());
//        }

//        CommitteeDAO committeeDAO = new CommitteeDAO();
//        Committe committe = committeeDAO.find("cmt00001");
//        CommitteeService committeeService = new CommitteeService();
//        System.out.println(committeeService.findCommitteeByName(committe).get(0).getCommitteName());

        AccountDAO adminDAO = new AccountDAO();
        List<Account> accountList = adminDAO.findAll();
        PersonService personService = new PersonService();
        /*personService.InsertPersonIntoAccountList(accountList);*/
        for (Account a : accountList
        ) {
            System.out.println(a.getPerson().getFullName());
        }

    }
}
