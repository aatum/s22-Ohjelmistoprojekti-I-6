package hh.s22ohjelmistoprojekti1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.s22ohjelmistoprojekti1.domain.Cloth;
import hh.s22ohjelmistoprojekti1.domain.ClothRepository;
import hh.s22ohjelmistoprojekti1.domain.Producer;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClothRepositoryTest {

	@Autowired
	private ClothRepository repository;

	@Test // testing findByName-method from ClothRepository
	public void findByNameShouldReturnProductName() {
		List<Cloth> clothes = repository.findByName("Raincoat");

		assertThat(clothes).hasSize(1);
		assertThat(clothes.get(0).getProducer().getName()).isEqualTo("producer1");
	}
	
	@Test // testing save-method from ClothRepository
	public void createNewCloth() {
		Cloth cloth = new Cloth("vaate", "vaate", new Producer("valmistaja"), "kuvaus", 10.0);
		repository.save(cloth);
		assertThat(cloth.getId()).isNotNull();
	}
}
