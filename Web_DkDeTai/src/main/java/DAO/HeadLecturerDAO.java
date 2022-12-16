package DAO;

import model.Headlecturer;

import java.util.List;
import java.util.Map;

public class HeadLecturerDAO extends JpaUtils<Headlecturer> implements GenericDAO<Headlecturer>{
	public  HeadLecturerDAO() {
		super();
	}
	
	@Override
	public  Headlecturer create( Headlecturer entity) {
		return super.create(entity);
	}
	
	@Override
	public  Headlecturer update( Headlecturer entity) {
		return super.update(entity);
	}
	
	@Override
	public void delete(Object id) {
		super.delete( Headlecturer.class, id);
	}
	
	@Override
	public Headlecturer find(Object primaryKey) {
		return super.find(Headlecturer.class, primaryKey);
	}
	
	@Override
	public List<Headlecturer> findAll(){
		String queryName = "HeadLecturer.findAll";
		return super.findAll(queryName, Headlecturer.class);
	}
	
	@Override
	public List<Headlecturer> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
		return super.findWithNamedQuery(queryName, parameters);
	}

	@Override
	public String randomId() {
		return super.randomId("HL");
	}

	@Override
	public List<Headlecturer> pagination(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}