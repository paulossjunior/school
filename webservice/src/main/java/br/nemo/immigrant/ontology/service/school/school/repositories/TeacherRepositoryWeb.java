package br.nemo.immigrant.ontology.service.school.school.repositories;

import br.nemo.immigrant.ontology.entity.school.school.models.Teacher;
import br.nemo.immigrant.ontology.entity.school.school.repositories.TeacherRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "teacher", path = "teacher")
public interface TeacherRepositoryWeb extends TeacherRepository {

}
