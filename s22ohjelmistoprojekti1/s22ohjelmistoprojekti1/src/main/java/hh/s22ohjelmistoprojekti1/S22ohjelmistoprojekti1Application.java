package hh.s22ohjelmistoprojekti1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;

@SpringBootApplication
public class S22ohjelmistoprojekti1Application {
	
	@Autowired
	ClothRepository clothRepository;

	public static void main(String[] args) {
		SpringApplication.run(S22ohjelmistoprojekti1Application.class, args);
		
	}
	
	@Bean
	public CommandLineRunner BookStuff(ClothRepository clothRepository) {
		return (args) -> {
			clothRepository.save(new Cloth("Sadetakki", "Takki", "Peten koiravaatteet", "Vedenpitävä ohut takki", 19.99));
			clothRepository.save(new Cloth("Villatakki", "Takki", "Ruppa", "Villasta tehty lämmin takki", 39.99));
			clothRepository.save(new Cloth("Bandana", "Huivi", "Koiravaate Oy", "Koiran kaulan ympärille huivi", 39.99));
			clothRepository.save(new Cloth("Fleecetossut", "Kengät", "Koiravaate Oy", "Koiralle mukavat tossut ulos", 39.99));

		};	
	}
}
