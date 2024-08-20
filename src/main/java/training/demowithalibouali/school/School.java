package training.demowithalibouali.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import training.demowithalibouali.student.Student;

import java.util.List;

@Entity
public class School {
   @Id
   @GeneratedValue
   private Integer id;
   private String name;

   /* ## OneToMany
    * When it is OneToMany, it is always a list of objects
    * And we don't forget to generate the getters
    * and setters for the objects
   */
   @OneToMany(mappedBy = "school")

   // notation to avoid the infinite loop while getting all
   @JsonManagedReference
   private List<Student> students;



   public School() {
   }

   public School(String name) {
      this.name = name;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<Student> getStudents() {
      return students;
   }

   public void setStudents(List<Student> students) {
      this.students = students;
   }
}
