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




@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Person  implements Serializable {


        @Id
        protected @GeneratedValue (strategy=GenerationType.IDENTITY)
        Long id;



  protected String name;


  protected LocalDate birthdate;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        Person elem = (Person) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "Person {" +
         "id="+this.id+
          ", name='"+this.name+"'"+
          ", birthdate='"+this.birthdate+"'"+

      '}';
  }
}
