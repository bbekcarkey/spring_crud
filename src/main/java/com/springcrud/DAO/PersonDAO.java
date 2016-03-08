package com.springcrud.DAO;

import java.util.List;

import com.springcrud.model.Person;

public interface PersonDAO {
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPerson();
	public void removePerson(int id);
	public Person getPersonById(int id);

}
