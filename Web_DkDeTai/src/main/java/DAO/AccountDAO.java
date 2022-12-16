package DAO;

import model.Account;

import java.util.List;
import java.util.Map;

public class AccountDAO extends JpaUtils<Account> implements GenericDAO<Account>{
	public AccountDAO( ) {
		super();
	}
	
	@Override
	public Account create(Account entity) {
		return super.create(entity);
	}
	
	@Override
	public Account update(Account entity) {
		return super.update(entity);
	}
	
	@Override
	public void delete(Object id) {
		super.delete(Account.class, id);
	}
	
	@Override
	public Account find(Object primaryKey) {
		return super.find(Account.class, primaryKey);
	}
	
	@Override
	public List<Account> findAll(){
		String queryName = "Account.findAll";
		return super.findAll(queryName, Account.class);
	}
	
	@Override
	public List<Account> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
		return super.findWithNamedQuery(queryName, parameters);
	}

	@Override
	public String randomId() {
		return super.randomId("AC");
	}

	@Override
	public List<Account> pagination(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}