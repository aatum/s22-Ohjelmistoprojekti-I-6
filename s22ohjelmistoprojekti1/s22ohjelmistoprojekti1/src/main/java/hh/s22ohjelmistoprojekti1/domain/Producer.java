package hh.s22ohjelmistoprojekti1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Producer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long producerid;
	private String name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producer")
	private List<Cloth> clothes;

	// parameterized constructor

	public Producer(String name) {
		super();
		this.name = name;
	}

	public Producer() {

	}

	// getters&setters

	public Long getProducerid() {
		return producerid;
	}

	public void setProducerid(Long producerid) {
		this.producerid = producerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cloth> getClothes() {
		return clothes;
	}

	public void setClothes(List<Cloth> clothes) {
		this.clothes = clothes;
	}

	// toString method

	@Override
	public String toString() {
		return "Producer [producerid=" + producerid + ", name=" + name + ", clothes=" + clothes + "]";
	}

}
