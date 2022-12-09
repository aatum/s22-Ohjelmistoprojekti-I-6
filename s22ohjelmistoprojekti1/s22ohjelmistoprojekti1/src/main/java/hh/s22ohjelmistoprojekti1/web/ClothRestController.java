package hh.s22ohjelmistoprojekti1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;
import hh.s22ohjelmistoprojekti1.domain.Producer;
import hh.s22ohjelmistoprojekti1.domain.ProducerRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ClothRestController {

	@Autowired
	ClothRepository clothRepository;

	@Autowired
	ProducerRepository producerRepository;

	// delete with REST
	@DeleteMapping("api/cloths/{id}")
	void deleteCloth(@PathVariable Long id) {
		clothRepository.deleteById(id);
	}
	
	@DeleteMapping("api/producers/{id}")
	void deleteProducer(@PathVariable Long id) {
		producerRepository.deleteById(id);
	}
	
	@PutMapping("api/cloths/{id}")
	void editCloth(@PathVariable Long id, @RequestBody Cloth cloth) {
		clothRepository.save(cloth);
	}
	
	@PutMapping("api/producers/{id}")
	void editProducer(@PathVariable Long id, @RequestBody Producer producer) {
		producerRepository.save(producer);
	}
	
	@RequestMapping(value = "api/cloths")
	public @ResponseBody List<Cloth> getClothes() {
		return (List<Cloth>) clothRepository.findAll();
	}

	@RequestMapping(value = "api/producers")
	public @ResponseBody List<Producer> getProducers() {
		return (List<Producer>) producerRepository.findAll();
	}
	
	@PostMapping(value = "/api/cloths")
	public void saveCloth(@RequestBody Cloth cloth) {
		clothRepository.save(cloth);
	}
	
	@PostMapping(value = "/api/producers")
	public void saveProducer(@RequestBody Producer producer) {
		producerRepository.save(producer);
	}
}