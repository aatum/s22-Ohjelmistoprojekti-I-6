package hh.s22ohjelmistoprojekti1.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClothRepository extends CrudRepository<Cloth, Long> {
	List<Cloth> findByName(String name);
}
