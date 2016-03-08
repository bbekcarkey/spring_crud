package com.springcrud.sevice;

import java.util.List;

import com.springcrud.model.Person;

public interface PersonService {
		public void addPerson(Person p);
		public void updatePerson(Person p);
		public List<Person> listPerson();
		public void removePerson(int id);
		public Person getPersonById(int id);




}
