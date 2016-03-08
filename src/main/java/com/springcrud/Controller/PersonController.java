package com.springcrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcrud.model.Person;
import com.springcrud.sevice.PersonService;

@Controller
public class PersonController {
	
	private PersonService personservice;
	  
    @Autowired(required=true)
    @Qualifier(value="personservice")
    public void setPersonService(PersonService personservice)
    {
        this.personservice=personservice;
    }
	
    
    
    @RequestMapping(value={"/persons","/"}, method= RequestMethod.GET)
    public String listPersons(Model model)
    {
    	model.addAttribute("person",new Person());
    	model.addAttribute("listPersons", this.personservice.listPerson());
    	return "person";
    	
    }
	
    //for add and update person both
    
    @RequestMapping(value="/person/add",method=RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p)
    {
    	
    	if (p.getId()==0)
    	{
    		//new friend add it
    		this.personservice.addPerson(p);
    		
    	}
    	else{
    		this.personservice.updatePerson(p);
    	}
    	
    	return "redirect:/persons";
    	
    }
    
    @RequestMapping("remove/{id}")
    public String removePerson(@PathVariable("id") int id)
    {
    	this.personservice.removePerson(id);
    	return "redirect:/persons";
    }
    
    @RequestMapping("edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personservice.getPersonById(id));
        model.addAttribute("listPersons", this.personservice.listPerson());
        return "person";
    }
     

}
