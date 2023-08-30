package br.nemo.immigrant.ontology.entity.school.school.repositories;

import br.nemo.immigrant.ontology.entity.school.school.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;


public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, ListCrudRepository<Student, Long> {

 

}
