package springblog.persistence.dao.owner.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springblog.persistence.dao.owner.OwnerDao;
import springblog.persistence.entity.Owner;

@Repository
@Transactional
public class OwnerDaoImpl implements OwnerDao {
    private static String TABLENAME = "owner";

    private static String QUERY = "FROM " + TABLENAME;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOwner(Owner owner) {
		getSession().save(owner);
	}
	
    @Override
    public Owner findByEmail(String email) {
        String queryString = "FROM Owner o WHERE o.email = :email";
        return getSession().createQuery(queryString, Owner.class)
                .setParameter("email", email)
                .getSingleResult();
    }
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}



}
