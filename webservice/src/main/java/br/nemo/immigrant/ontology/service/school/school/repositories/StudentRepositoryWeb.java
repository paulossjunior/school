package br.nemo.immigrant.ontology.service.school.school.repositories;

import br.nemo.immigrant.ontology.entity.school.school.models.Student;
import br.nemo.immigrant.ontology.entity.school.school.repositories.StudentRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepositoryWeb extends StudentRepository {

}
