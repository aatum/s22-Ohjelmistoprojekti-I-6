package hh.s22ohjelmistoprojekti1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;
import hh.s22ohjelmistoprojekti1.domain.Producer;
import hh.s22ohjelmistoprojekti1.domain.ProducerRepository;

@SpringBootApplication
public class S22ohjelmistoprojekti1Application {
	
	@Autowired
	ClothRepository clothRepository;
	
	@Autowired
	ProducerRepository producerRepository;

	public static void main(String[] args) {
		SpringApplication.run(S22ohjelmistoprojekti1Application.class, args);
		
	}
	
	@Bean
	public CommandLineRunner BookStuff(ClothRepository clothRepository, ProducerRepository producerRepository) {
		return (args) -> {
			Producer producer1 = new Producer("producer1");
			producerRepository.save(producer1);
			Producer producer2 = new Producer("producer2");
			producerRepository.save(producer2);
			Producer producer3 = new Producer("producer3");
			producerRepository.save(producer3);
			clothRepository.save(new Cloth("Raincoat", "Coats", producer1, "A waterproof coat ", 19.99));
			clothRepository.save(new Cloth("Bandana", "Coats", producer2, "A waterproof coat ", 19.99));
			clothRepository.save(new Cloth("Raincoat", "Coats", producer3, "A waterproof coat ", 19.99));

		};	
	}
}