package service;

import DAO.CommitteeDAO;
import model.Committe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommitteeService extends SuperService {

    public static CommitteeDAO committeeDAO = new CommitteeDAO();

    public CommitteeService(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    public CommitteeService() {
    }


    public String checkInputData(Committe committe) {
        if (committe.getNumMember() < 2) {
            return "Tối thiểu 2 thành viên!";
        }
        if (committe.getNumMember() > 5) {
            return "Tối đa 5 thành viên!";
        }
        return "OK";
    }

    public String checkNameAvailable(Committe committe) {
        List<Committe> committeList = findCommitteeByName(committe);
        if (committeList.size() > 0) {
            return "Tên hội đồng <b>đã tồn tại</b>! Vui lòng nhập tên khác";
        }
        return "OK";
    }

    public List<Committe> findCommitteeByName(Committe committe) {
        List<Committe> committeList = new ArrayList<>();
        Map<String, Object> maping = new HashMap<String, Object>();
        maping.put("name", committe.getCommitteName());
        committeList = committeeDAO.findWithNamedQuery("Committee.findCommitteeByName", maping);
        return committeList;
    }

    public List<Committe> findByName(String keyword) {
        List<Committe> committeList = new ArrayList<>();
        Map<String, Object> maping = new HashMap<String, Object>();
        maping.put("name", "%" + keyword + "%");
        committeList = committeeDAO.findWithNamedQuery("Committee.findListByName", maping);
        return committeList;
    }

    public boolean checkIdAvailable(Committe committe) {
        List<Committe> committeList = committeeDAO.findAll();
        for (Committe c : committeList) {
            if (c.getCommitteId().equals(committe.getCommitteId())) {
                return false;
            }
        }
        return true;
    }
}
