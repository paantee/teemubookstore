package com.example.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {return (args) -> {
		
		crepository.save(new Category("category1"));
		crepository.save(new Category("category2"));
		crepository.save(new Category("category3"));
				
		repository.save(new Book("Teemu", "a1", "Teemu Testi", "2017", crepository.findByName("category1").get(0)));
		repository.save(new Book("Janne", "a2", "Janne Testi", "2018", crepository.findByName("category2").get(0)));
		repository.save(new Book("Aatu", "a3", "Aatu Testi", "2019", crepository.findByName("category1").get(0)));

	User user1 = new User("user1", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2); 
		
	};
	}
	
}
