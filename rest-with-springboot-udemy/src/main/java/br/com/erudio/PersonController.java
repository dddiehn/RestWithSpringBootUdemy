package br.com.erudio;

import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.services.PersonServices;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonServices personServices = new PersonServices();

	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return personServices.findById(id);
	}

	@GetMapping
	public List<Person> findAll() {
		return personServices.findAll();
	}

	@PostMapping
	public Person create(@RequestBody Person person) {
		return personServices.create(person);
	}

	@PutMapping
	public Person update(@RequestBody Person person) {
		return personServices.update(person);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		personServices.delete(id);
	}

}