package hh.s22ohjelmistoprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;
import hh.s22ohjelmistoprojekti1.domain.Producer;
import hh.s22ohjelmistoprojekti1.domain.ProducerRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class ClothController {

	@Autowired
	ClothRepository clothRepository;

	@Autowired
	ProducerRepository producerRepository;

	// homepage

	@GetMapping(value = { "/", "index" })
	public String mainpage(Model model) {
		return "index";
	}

	// errorpage

	@GetMapping("error")
	public String errorpage(Model model) {
		return "error";
	}

	// get all clothes as a table

	@GetMapping("clothlist")
	public String showClothes(Model model) {
		model.addAttribute("cloth", clothRepository.findAll());
		return "clothlist";
	}

	// get all producers as a table

	@GetMapping("producerlist")
	public String showProducers(Model model) {
		model.addAttribute("producer", producerRepository.findAll());
		return "producerlist";
	}

	// spring security, only admin can add a cloth

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("add")
	public String addCloth(Model model) {
		model.addAttribute("cloth", new Cloth());
		model.addAttribute("producers", producerRepository.findAll());
		return "addcloth";
	}

	// add new producer

	@GetMapping("addproducer")
	public String addProducer(Model model) {
		model.addAttribute("producer", new Producer());
		return "addproducer";
	}

	// save new cloth

	@PostMapping("save")
	public String saveCloth(Cloth cloth) {
		clothRepository.save(cloth);
		return "redirect:clothlist";
	}

	// save new producer

	@PostMapping("saveproducer")
	public String saveProducer(Producer producer) {
		producerRepository.save(producer);
		return "redirect:producerlist";
	}

	// spring security, only admin can delete a cloth

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteCloth(@PathVariable("id") Long id, Model model) {
		clothRepository.deleteById(id);
		return "redirect:../clothlist";
	}

	// spring security, only admin can delete a producer

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/deleteproducer/{id}")
	public String deleteProducer(@PathVariable("id") Long id, Model model) {
		producerRepository.deleteById(id);
		return "redirect:../producerlist";
	}

	// spring securyity, only admin can edit a cloth

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/edit/{id}")
	public String editCloth(@PathVariable("id") Long id, Model model) {
		model.addAttribute("cloth", clothRepository.findById(id));
		model.addAttribute("producers", producerRepository.findAll());
		return "editcloth";
	}

	// spring security, only admin can edit a producer

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/editproducer/{id}")
	public String editProducer(@PathVariable("id") Long id, Model model) {
		model.addAttribute("producer", producerRepository.findById(id));
		return "editproducer";
	}

	// spring security

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listbyproducer/{id}")
	public String listbyProducer(@PathVariable("id") Long id, Model model) {
		model.addAttribute("cloth", clothRepository.findAll());
		producerRepository.findById(id).ifPresent(o -> model.addAttribute("producer", o));
		return "listbyproducer";
	}
}
