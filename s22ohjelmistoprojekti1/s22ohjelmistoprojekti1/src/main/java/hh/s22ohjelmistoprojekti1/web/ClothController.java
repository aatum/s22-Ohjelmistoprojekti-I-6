package hh.s22ohjelmistoprojekti1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;
import hh.s22ohjelmistoprojekti1.domain.Producer;
import hh.s22ohjelmistoprojekti1.domain.ProducerRepository;



@Controller
public class ClothController {
	
	@Autowired
	ClothRepository clothRepository;
	
	@Autowired
	ProducerRepository producerRepository;
	
	@GetMapping(value = {"/", "index"})
	public String mainpage(Model model) {
		return "index";
	}

	@GetMapping("error")
	public String errorpage(Model model) {
		return "error";
	}
	
	@GetMapping("clothlist")
	public String showClothes(Model model) {
		model.addAttribute("cloth", clothRepository.findAll());
		return "clothlist";
	}
	
	@GetMapping("producerlist")
	public String showProducers(Model model) {
		model.addAttribute("producer", producerRepository.findAll());
		return "producerlist";
	}
	
    // @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("add")
    public String addCloth(Model model){
    	model.addAttribute("cloth", new Cloth());
    	model.addAttribute("producers", producerRepository.findAll());
        return "addcloth";
    }
	
	@GetMapping("addproducer")
	public String addProducer(Model model) {
		model.addAttribute("producer", new Producer());
		return "addproducer";
	}
	
    @PostMapping("save")
    public String saveCloth(Cloth cloth){
        clothRepository.save(cloth);
        return "redirect:clothlist";
    }
    
    @PostMapping("saveproducer")
    public String saveProducer(Producer producer){
        producerRepository.save(producer);
        return "redirect:producerlist";
    }
    
    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteCloth(@PathVariable("id") Long id, Model model) {
    	clothRepository.deleteById(id);
        return "redirect:../clothlist";
    }
    
    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/deleteproducer/{id}")
    public String deleteProducer(@PathVariable("id") Long id, Model model) {
    	producerRepository.deleteById(id);
        return "redirect:../producerlist";
    }
    
    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editCloth(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("cloth", clothRepository.findById(id));
    	model.addAttribute("producers", producerRepository.findAll());
        return "editcloth";
    }   
    
    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editproducer/{id}")
    public String editProducer(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("producer", producerRepository.findById(id));
        return "editproducer";
    }  
}
