package br.nemo.immigrant.ontology.service.school.school.repositories;

import br.nemo.immigrant.ontology.entity.school.school.models.Course;
import br.nemo.immigrant.ontology.entity.school.school.repositories.CourseRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "course", path = "course")
public interface CourseRepositoryWeb extends CourseRepository {

}
