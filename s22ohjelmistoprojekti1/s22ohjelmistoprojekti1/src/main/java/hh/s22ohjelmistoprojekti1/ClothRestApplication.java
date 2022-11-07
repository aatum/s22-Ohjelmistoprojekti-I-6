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

@SpringBootApplication
public class ClothRestApplication implements CommandLineRunner {
	private static final Logger log = (Logger) LoggerFactory.getLogger(ClothRestApplication.class);

	@Autowired
	ClothRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ClothRestApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		log.info("creating couple of clothes");
		Producer producer1 = new Producer("producer1");
		repository.save(new Cloth("Bandana", "Accessories", producer1, "Scarf for a dog", 15.00));
		Producer producer2 = new Producer("producer2");
		repository.save(new Cloth("Raincoat", "Coats", producer2, "Raincoat for a dog", 25.50));
		Producer producer3 = new Producer("producer3");
		repository.save(new Cloth("Dog shoes", "Shoes", producer3, "Shoes for a dog", 20.00));

		log.info("Print clothes to console:");
		for (Cloth cloth : repository.findAll()) {
			log.info(cloth.toString());
		}
	}
}
