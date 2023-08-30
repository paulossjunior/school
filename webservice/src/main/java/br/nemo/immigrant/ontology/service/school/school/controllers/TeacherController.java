package br.nemo.immigrant.ontology.service.school.school.controllers;

import br.nemo.immigrant.ontology.entity.school.school.models.Teacher;
import br.nemo.immigrant.ontology.entity.school.school.repositories.TeacherRepository;
import br.nemo.immigrant.ontology.service.school.school.records.TeacherInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TeacherController  {

  @Autowired
  TeacherRepository repository;

  @QueryMapping
  public List<Teacher> findAllTeachers() {
    return repository.findAll();
  }

  @QueryMapping
  public Teacher findByIDTeacher(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Teacher createTeacher(@Argument TeacherInput input) {
    Teacher instance = Teacher.builder().hiringDate(input.hiringDate()).
                                         name(input.name()).
                                         birthdate(input.birthdate()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Teacher updateTeacher(@Argument Long id, @Argument TeacherInput input) {
    Teacher instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Teacher not found");
    }
    instance.setHiringDate(input.hiringDate());
    instance.setName(input.name());
    instance.setBirthdate(input.birthdate());
    repository.save(instance);
    return instance;
  }

  @MutationMapping
  public void deleteTeacher(@Argument Long id) {
    repository.deleteById(id);
  }

}
