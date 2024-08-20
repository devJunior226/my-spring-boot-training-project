package training.demowithalibouali.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
   private final StudentService studentService;

   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }

   // Post a student
   @PostMapping("/students")
   public StudentResponseDto postStudent(
       // We tell to spring that the object must be validated with @Valid
       @Valid @RequestBody StudentDto studentDto) {
      return studentService.saveStudent(studentDto);
   }

   // get all students
   @GetMapping("/students")
   public List<StudentResponseDto> getAllStudents() {
      return this.studentService.findAllStudents();
   }

   // Get one student
   @GetMapping("/students/{student-id}")
   public StudentResponseDto getStudentById(
       @PathVariable("student-id") Integer id) {
      return this.studentService.findStudentById(id);
   }

   // Find all students by their firstnames
   @GetMapping("/students/search/{student-name}")
   public List<StudentResponseDto> findStudentsByName(
       @PathVariable("student-name") String name
   ) {
      return this.studentService.findStudentsByName(name);
   }

   // Delete a student
   @DeleteMapping("/students/{student-id}")
   @ResponseStatus(HttpStatus.OK)
   public void deleteStudent(@PathVariable("student-id") Integer id) {
      this.studentService.removeStudent(id);
   }

   // Handle exception for not values arguments
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<?> handleMethodArgumentNotValidException(
       MethodArgumentNotValidException exception
   ){
      var errors = new HashMap<String, String>();
      exception.getBindingResult().getAllErrors()
          .forEach(error -> {
             var fieldName = ((FieldError) error).getField();
             var errorMessage = error.getDefaultMessage();
             errors.put(fieldName, errorMessage);
          });
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
   }
}
