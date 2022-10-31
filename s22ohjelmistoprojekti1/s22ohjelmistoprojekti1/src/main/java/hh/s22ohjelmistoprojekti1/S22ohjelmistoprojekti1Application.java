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
			clothRepository.save(new Cloth("asd","asd","asd","asd", 0));

		};	
	}
}
