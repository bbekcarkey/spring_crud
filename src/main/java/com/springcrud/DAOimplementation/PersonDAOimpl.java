package com.springcrud.DAOimplementation;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcrud.DAO.PersonDAO;
import com.springcrud.model.Person;

@Transactional
@Repository
public class PersonDAOimpl implements PersonDAO
{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOimpl.class);
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPerson(Person p) 
	{
		
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person Saved SucessFully,Person Details+"+p);
		
	}

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("person updated sucessfully, person details="+p);
		
	}

	@Override
	public List<Person> listPerson() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personList= session.createQuery("from Person").list();
		for(Person p : personList)
		{
			logger.info("Person List="+ p);
		}
		return personList;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null!=p)
		{
			session.delete(p);
		}
		logger.info("Person Deleted="+p);
		
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class,new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		
		return p ;
	}

}
