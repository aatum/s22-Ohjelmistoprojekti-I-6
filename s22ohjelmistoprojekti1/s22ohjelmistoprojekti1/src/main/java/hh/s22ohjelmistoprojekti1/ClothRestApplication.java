package hh.s22ohjelmistoprojekti1;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;
import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;
import hh.s22ohjelmistoprojekti1.domain.Producer;
import hh.s22ohjelmistoprojekti1.domain.ProducerRepository;

@SpringBootApplication
public class ClothRestApplication implements CommandLineRunner {
	private static final Logger log = (Logger) LoggerFactory.getLogger(ClothRestApplication.class);

	@Autowired
	ClothRepository repository;
	
	@Autowired
	ProducerRepository prodrepository;


	public static void main(String[] args) {
		SpringApplication.run(ClothRestApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		log.info("creating couple of clothes");
		Producer producer4 = new Producer("producer4");
		Producer producer5 = new Producer("producer5");
		Producer producer6 = new Producer("producer6");
		prodrepository.save(producer4);
		prodrepository.save(producer5);
		prodrepository.save(producer6);
		repository.save(new Cloth("Bandana", "Accessories", producer4, "Scarf for a dog", 15.00));
		repository.save(new Cloth("Raincoat", "Coats", producer5, "Raincoat for a dog", 25.50));
		repository.save(new Cloth("Dog shoes", "Shoes", producer6, "Shoes for a dog", 20.00));

		log.info("Print clothes to console:");
		for (Cloth cloth : repository.findAll()) {
			log.info(cloth.toString());
		}
	}
}
