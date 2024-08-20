package training.demowithalibouali.student;

import org.springframework.stereotype.Service;
import training.demowithalibouali.school.School;

@Service
public class StudentMapper {

   /* Creating a method to map our dto */
   public Student toStudent(StudentDto studentDto) {
      if (studentDto == null) {
         throw new NullPointerException("The student dto should not be null");
      }

      // Creating a new student
      var student = new Student();

      // Mapping our dto to a new student
      student.setFirstname(studentDto.firstname());
      student.setLastname(studentDto.lastname());
      student.setEmail(studentDto.email());

      // Creating a new school
      var school = new School();
      school.setId(studentDto.schoolId());

      student.setSchool(school);

      return student;
   }


   /* Creating another method to display some specific informations */
   public StudentResponseDto toStudentResponseDto(Student student) {
      return new StudentResponseDto(
          student.getFirstname(),
          student.getLastname(),
          student.getEmail()
      );
   }
}
