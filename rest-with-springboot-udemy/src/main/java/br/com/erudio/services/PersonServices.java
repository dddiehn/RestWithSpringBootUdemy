package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();

	public Person create(Person person) {
		return person;
	}

	public Person update(Person person) {
		return person;
	}

	public void delete(String id) {
		Person person = this.findById(id);
//		person.delete();
	}

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Dom");
		person.setLastName("Diehn");
		person.setAddress("Wherever");
		person.setGender("Male");

		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("First "  + i);
		person.setLastName("Last " + i);
		person.setAddress("Wherever " + i);
		person.setGender("Male " + i);

		return person;
	}

}