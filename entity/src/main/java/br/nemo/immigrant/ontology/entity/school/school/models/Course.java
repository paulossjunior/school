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
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  class Course  implements Serializable {



        @Id
        private @GeneratedValue (strategy=GenerationType.IDENTITY)
        Long id;


  private String name;


  private String code;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  private Teacher teacher;





  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();

  @Override
  public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || this.getClass() != o.getClass()) return false;

        Course elem = (Course) o;
        return getId().equals(elem.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
      return "Course {" +
         "id="+this.id+
          ", name='"+this.name+"'"+
          ", code='"+this.code+"'"+

      '}';
  }
}
