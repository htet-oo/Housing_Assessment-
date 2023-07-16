package springblog.persistence.dao.house.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springblog.persistence.dao.house.HouseDao;
import springblog.persistence.entity.House;

@Repository
@Transactional
public class HouseDaoImpl implements HouseDao {

    private static String TABLENAME = "House";

    private static String QUERY = "FROM " + TABLENAME;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveHouse(House house) {
		getSession().save(house);
	}
	
	@Override
	public List<House> getAllHouses(int id) {
		System.out.println("this is username from housedao" + id);
	    String queryString = QUERY + " WHERE owner_id = :owner_id";
	    Query<House> query = getSession().createQuery(queryString, House.class);
	    query.setParameter("owner_id",id);
	    return query.list();
	}
	

	@Override
	public void deleteHouse(House house) {
		getSession().delete(house);
		
	}
	
	@Override
	public House findById(int id) {
		return getSession().get(House.class, id);
	}
	

	@Override
	public void edit(House house) {
		String sql = "UPDATE House SET address = :address, amount = :amount, housingName = :housingName, updated_at = :updatedAt, numberOfFloor = :numberOfFloor, numberOfMasterRoom =:numberOfMasterRoom, numberOfSingleRoom =:numberOfSingleRoom WHERE id = :id";
		Query<?> query = getSession().createQuery(sql);
		query.setParameter("address", house.getAddress());
		query.setParameter("amount", house.getAmount());
		query.setParameter("housingName", house.getHousingName());
		query.setParameter("updatedAt", house.getUpdated_at());
		query.setParameter("id", house.getId());
		query.setParameter("numberOfFloor", house.getNumberOfFloor());
		query.setParameter("numberOfMasterRoom", house.getNumberOfMasterRoom());
		query.setParameter("numberOfSingleRoom", house.getNumberOfSingleRoom());
		query.executeUpdate();
		
	}

	@Override
	public List<House> searchUser(String keyword) {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		stringBuf.append(" AS U");
		stringBuf.append(" WHERE U.housingName LIKE :keyword OR U.numberOfFloor LIKE :keyword OR U.numberOfMasterRoom LIKE :keyword OR U.numberOfSingleRoom LIKE :keyword");
		@SuppressWarnings("unchecked")
		Query<House> query = getSession().createQuery(stringBuf.toString());
		query.setParameter("keyword", "%" + keyword + "%"); 
		return query.list();
	}
	
	@Override
	public List<House> getAllHouses() {
		StringBuffer stringBuf = new StringBuffer(QUERY);
		@SuppressWarnings("unchecked")
		Query<House> query = getSession().createQuery(stringBuf.toString());
		return query.list();
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
