package br.nemo.immigrant.ontology.entity.school.school.repositories;

import br.nemo.immigrant.ontology.entity.school.school.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.ListCrudRepository;
import java.util.Optional;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long>, ListCrudRepository<Course, Long> {


}
