package br.nemo.immigrant.ontology.entity.school.school.repositories;

import br.nemo.immigrant.ontology.entity.school.school.models.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;


public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long>, ListCrudRepository<Teacher, Long> {


}
