package br.nemo.immigrant.ontology.service.school.school.controllers;

import br.nemo.immigrant.ontology.entity.school.school.models.Student;
import br.nemo.immigrant.ontology.entity.school.school.repositories.StudentRepository;
import br.nemo.immigrant.ontology.service.school.school.records.StudentInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController  {

  @Autowired
  StudentRepository repository;

  @QueryMapping
  public List<Student> findAllStudents() {
    return repository.findAll();
  }

  @QueryMapping
  public Student findByIDStudent(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Student createStudent(@Argument StudentInput input) {
    Student instance = Student.builder().enrollmentDate(input.enrollmentDate()).
                                         name(input.name()).
                                         birthdate(input.birthdate()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Student updateStudent(@Argument Long id, @Argument StudentInput input) {
    Student instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Student not found");
    }
    instance.setEnrollmentDate(input.enrollmentDate());
    instance.setName(input.name());
    instance.setBirthdate(input.birthdate());
    repository.save(instance);
    return instance;
  }

  @MutationMapping
  public void deleteStudent(@Argument Long id) {
    repository.deleteById(id);
  }

}
