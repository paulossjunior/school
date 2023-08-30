package br.nemo.immigrant.ontology.service.school.school.records;
import java.time.LocalDate;
public record StudentInput( LocalDate enrollmentDate,String name,LocalDate birthdate ) {
}
