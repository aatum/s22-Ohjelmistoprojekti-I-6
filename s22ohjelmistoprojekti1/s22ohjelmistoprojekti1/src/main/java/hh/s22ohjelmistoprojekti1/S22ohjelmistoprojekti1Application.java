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
	

}