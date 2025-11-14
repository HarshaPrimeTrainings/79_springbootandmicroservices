package com.training.springhibernatedemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public String saveUser(User u) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.persist(u);
		tr.commit();
		session.close();
		return "User Saved";
	}
	
	public User getUserById(Integer uid) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		//User u =  session.load(User.class, uid);
		User u = session.get(User.class, uid);
		session.close();
		return u;
	}
	
	public List<User> getusers(){
		Session session= sessionFactory.openSession();
		List<User> users = session.createQuery("FROM User").list();
		return users;
		
	}
	
	public String deleteUser(Integer uid) {
		Session session= sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		 User usr = getUserById(uid);
		 session.delete(usr);
		 tr.commit();
		 session.close();
		 return "User Deleted";
	}
	
	
}
