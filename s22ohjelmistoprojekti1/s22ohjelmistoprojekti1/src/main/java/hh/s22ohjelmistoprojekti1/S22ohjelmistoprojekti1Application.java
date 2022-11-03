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
			clothRepository.save(new Cloth("Raincoat", "Coats", "Pete's dog clothing", "A waterproof coat ", 19.99));
			clothRepository.save(new Cloth("Woolcoat", "Coats", "Ruppa", "A warm coat made of wool", 39.99));
			clothRepository.save(new Cloth("Bandana", "Scarfs", "Dogclothes LLC", "A scarf for the dog", 10.99));
			clothRepository.save(new Cloth("Fleeceboots ", "Shoes", "Dogclothes LLC", "Comfortable shoes for the dog to wear outside", 24.99));

		};	
	}
}
