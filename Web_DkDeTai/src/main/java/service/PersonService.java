package service;

//import DAO.JpaUtils;
//import model.Person;
//
//import javax.persistence.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.PersonDAO;
import model.Account;
import model.Person;

public class PersonService extends SuperService {
    final PersonDAO personDAO = new PersonDAO();

    public Person getPersonByUsername(String username) {
        System.out.println("getPersonByUsername()");

//        JpaUtils<Person> jpaUtils = new JpaUtils();
//        System.out.println("1");
//        EntityManagerFactory emf = jpaUtils.getEntityManagerFactory();
//        System.out.println("2");
//        EntityManager em = jpaUtils.getEntityManager();
//        System.out.println("3");
//        em.getTransaction().begin();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Web_DkDeTai");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = new Person();

        try {
            final String strQuery = "Select a.person " +
                    "From Account a " +
                    "WHERE a.username = :username";
            TypedQuery<Person> query = em.createQuery(strQuery, Person.class);
            query.setParameter("username", username);
            person = query.getSingleResult();
            System.out.println("person: " + person.getPersonId());
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return person;
    }

    /*public void InsertPersonIntoAccountList(List<Account> accountList) {

        for (Account acc : accountList) {
            Person person = personDAO.find(acc.getPersonID());
            acc.setPerson(person);
        }
    }*/

    public String checkInputData(Person person) {
        if (!isPhoneNumber(person.getPhonenumber())) {
            return "Nhập đúng định dạng số điện thoại!";
        }
        if (person.getPhonenumber().length() != 10) {
            return "Nhập đúng định dạng số điện thoại 10 số!";
        }
        return "OK";
    }

    private boolean isPhoneNumber(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (Character.isLetter(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String checkPhoneAvailable(Person person) {
        List<Person> personList = findPersonByPhone(person.getPhonenumber());
        if (personList.size() > 0) {
            return "Số điện thoại <b>đã tồn tại</b>! Vui lòng nhập SĐT khác";
        }
        return "OK";
    }

    public String checkEmailAvailable(Person person) {
        List<Person> personList = findPersonByEmail(person.getEmail());
        if (personList.size() > 0) {
            return "Email <b>đã tồn tại</b>! Vui lòng nhập email khác";
        }
        return "OK";
    }

    public List<Person> findPersonByPhone(String phone) {
        List<Person> personList = new ArrayList<>();
        Map<String, Object> maping = new HashMap<String, Object>();
        maping.put("phone", phone);
        personList = personDAO.findByPhone("Person.findByPhone", maping);
        return personList;
    }

    public List<Person> findPersonByEmail(String mail) {
        List<Person> personList = new ArrayList<>();
        Map<String, Object> maping = new HashMap<String, Object>();
        maping.put("mail", mail);
        personList = personDAO.findByQuery("Person.findByMail", maping);
        return personList;
    }

    public boolean checkIdAvailable(Person person) {
        List<Person> personList = personDAO.findAll();
        for (Person p : personList) {
            if (p.getPersonId().equals(person.getPersonId())) {
                return false;
            }
        }
        return true;
    }
}
