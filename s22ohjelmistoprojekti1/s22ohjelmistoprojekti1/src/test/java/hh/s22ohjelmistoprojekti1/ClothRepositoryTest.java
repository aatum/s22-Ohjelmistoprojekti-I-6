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

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class ClothRepositoryTest {

	@Autowired
	private ClothRepository clothRepository;

	@Test // testing findByName-method from ClothRepository
	public void findByNameShouldReturnProductName() {
		List<Cloth> clothes = clothRepository.findByName("Bandana");

		assertThat(clothes).hasSize(1);
		assertThat(clothes.get(0).getProducer()).isEqualTo("producer4");
	}
}
