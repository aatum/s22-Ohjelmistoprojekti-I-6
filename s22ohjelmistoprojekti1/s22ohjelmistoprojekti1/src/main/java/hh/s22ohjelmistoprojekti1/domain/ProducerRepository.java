package hh.s22ohjelmistoprojekti1.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProducerRepository extends CrudRepository<Producer, Long>{
    List<Producer> findByname(String name);
}
