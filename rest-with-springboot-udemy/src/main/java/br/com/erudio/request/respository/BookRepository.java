package br.com.erudio.request.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.data.model.Book;
import br.com.erudio.data.model.Person;

@Repository 
public interface BookRepository extends JpaRepository<Book, Long>{
	
}