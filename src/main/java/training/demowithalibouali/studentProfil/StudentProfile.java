package training.demowithalibouali.studentProfil;


import jakarta.persistence.*;
import training.demowithalibouali.student.Student;

@Entity
public class StudentProfile {
   @Id
   @GeneratedValue
   private Integer id;
   private String bio;

   /* ## Relational mapping
    * The field of type Student must be the same passed
    * to mappedBy in the Student entity
    * ## @JoinColumn will create a new field named student_id
    * which is a reference fk of student table
    */
   @OneToOne
   @JoinColumn(name = "student_id")
   private Student student;

   public StudentProfile() {
   }

   public StudentProfile(String bio) {
      this.bio = bio;
   }

}
