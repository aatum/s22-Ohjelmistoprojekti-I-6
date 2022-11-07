package hh.s22ohjelmistoprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;

@RestController
public class ClothRestController {

	@Autowired
	ClothRepository repository;

	// return list of clothes
	@CrossOrigin
	@GetMapping("/rest/clothes")
	public Iterable<Cloth> getClothes() {
		return repository.findAll();
	}

	// add new cloth
	@PostMapping("/rest/clothes")
	Cloth newCloth(@RequestBody Cloth newCloth) {
		return repository.save(newCloth);
	}

	// edit cloth information
	@PutMapping("rest/clothes/{id}")
	Cloth editCloth(@RequestBody Cloth editedCloth, @PathVariable Long id) {
		editedCloth.setId(id);
		return repository.save(editedCloth);
	}

	// delete cloth
	@DeleteMapping("rest/clothes/{id}")
	void deleteCloth(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
