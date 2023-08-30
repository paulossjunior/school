package br.nemo.immigrant.ontology.entity.school.school.models;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;
import java.time.LocalDate;
import java.util.Date;



import br.nemo.immigrant.ontology.entity.school.school.models.Person;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Teacher extends Person implements Serializable {




  private LocalDate hiringDate;

  @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "teacher")
  @Builder.Default
  Set<Course> courses = new HashSet<>();





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        Teacher elem = (Teacher) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "Teacher {" +
         "id="+this.id+
          ", hiringDate='"+this.hiringDate+"'"+
          ", name='"+this.name+"'"+
          ", birthdate='"+this.birthdate+"'"+

      '}';
  }
}
