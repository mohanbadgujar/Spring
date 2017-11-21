package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.model.User;

public class DaoImp implements Dao {

	@Autowired
	SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public User findById(int id) {

		Session session = factory.openSession();
		User user = session.get(User.class, id);
		System.out.println("User id" + user.getId());
		session.close();
		return user;
	}

	/*
	 * @Override public User findByName(String name) {
	 * 
	 * Session session = factory.openSession();
	 * 
	 * @SuppressWarnings("deprecation") Criteria criteria =
	 * session.createCriteria(User.class); criteria.add(Restrictions.eq("name",
	 * name));
	 * 
	 * @SuppressWarnings("unchecked") List<User> user = (List<User>)criteria.list();
	 * return user.get(0); }
	 */

	@Override
	public void SaveUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void updateUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void deleteUserById(int id) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = new User();
			user.setId(id);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public List<User> findAllUsers() {
		Session session = factory.openSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> list = criteria.list();
		return list;
	}

}
