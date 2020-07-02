package br.com.erudio;

import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.services.PersonServices;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonServices personServices = new PersonServices();

	@RequestMapping(
		value    = "/{id}",
		method   = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person findById(@PathVariable("id") String id) {
		return personServices.findById(id);
	}

	@RequestMapping(
		method   = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Person> findAll() {
		return personServices.findAll();
	}

	@RequestMapping(
		method   = RequestMethod.POST,
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public Person create(@RequestBody Person person) {
		return personServices.create(person);
	}

	@RequestMapping(
		method   = RequestMethod.PUT,
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public Person update(@RequestBody Person person) {
		return personServices.update(person);
	}

	@RequestMapping(
		value    = "/{id}",
		method   = RequestMethod.DELETE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public void delete(@PathVariable("id") String id) {
		personServices.delete(id);
	}

}