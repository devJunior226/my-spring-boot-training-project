package training.demowithalibouali.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
   private final StudentRepository studentRepository;
   private final StudentMapper studentMapper;

   public StudentService(StudentRepository studentRepository,
                         StudentMapper studentMapper) {
      this.studentRepository = studentRepository;
      this.studentMapper = studentMapper;
   }

   // return only student names and email
   public StudentResponseDto saveStudent(StudentDto studentDto) {
      var student = studentMapper.toStudent(studentDto);
      var savedStudent = studentRepository.save(student);
      return studentMapper.toStudentResponseDto(savedStudent);
   }

   // Get all students
   public List<StudentResponseDto> findAllStudents() {
      return studentRepository.findAll()
          .stream()
          .map(studentMapper::toStudentResponseDto)
          .collect(Collectors.toList());
   }

   // Get one student by his id
   public StudentResponseDto findStudentById(Integer id) {
      return this.studentRepository.findById(id)
          .map(studentMapper::toStudentResponseDto)
          .orElse(null);
   }

   // find all student by their firstname
   public List<StudentResponseDto> findStudentsByName(String name) {
      return this.studentRepository.findAllByFirstnameContaining(name)
          .stream()
          .map(studentMapper::toStudentResponseDto)
          .collect(Collectors.toList());
   }

   // delete a student
   public void removeStudent(Integer id) {
      this.studentRepository.deleteById(id);
   }
}
