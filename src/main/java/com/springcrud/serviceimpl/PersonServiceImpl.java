package com.springcrud.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.DAO.PersonDAO;
import com.springcrud.model.Person;
import com.springcrud.sevice.PersonService;

@Service("personservice")
public class PersonServiceImpl implements PersonService
{
  
	@Autowired
	private PersonDAO personDAO;
	
	public void setPersonDAO(PersonDAO personDAO)
	{
		this.personDAO=personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) 
	{
		
	this.personDAO.addPerson(p);
		
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
		
	}

	@Override
	@Transactional
	public List<Person> listPerson() {
		// TODO Auto-generated method stub
		return this.personDAO.listPerson();
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
		
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return this.personDAO.getPersonById(id);
	}

	
}
