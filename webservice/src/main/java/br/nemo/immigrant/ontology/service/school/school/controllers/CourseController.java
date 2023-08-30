package br.nemo.immigrant.ontology.service.school.school.controllers;

import br.nemo.immigrant.ontology.entity.school.school.models.Course;
import br.nemo.immigrant.ontology.entity.school.school.repositories.CourseRepository;
import br.nemo.immigrant.ontology.service.school.school.records.CourseInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController  {

  @Autowired
  CourseRepository repository;

  @QueryMapping
  public List<Course> findAllCourses() {
    return repository.findAll();
  }

  @QueryMapping
  public Course findByIDCourse(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Course createCourse(@Argument CourseInput input) {
    Course instance = Course.builder().name(input.name()).
                                       code(input.code()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Course updateCourse(@Argument Long id, @Argument CourseInput input) {
    Course instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Course not found");
    }
    instance.setName(input.name());
    instance.setCode(input.code());
    repository.save(instance);
    return instance;
  }

  @MutationMapping
  public void deleteCourse(@Argument Long id) {
    repository.deleteById(id);
  }

}
