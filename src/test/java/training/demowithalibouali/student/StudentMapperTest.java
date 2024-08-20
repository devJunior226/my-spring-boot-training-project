package training.demowithalibouali.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

   // We must import the class we want to test
   private StudentMapper studentMapper;


   // Then we initialise it in the beforeEach method
   @BeforeEach
   void setUp() {
      studentMapper = new StudentMapper();
   }


   // Testing the student to student dto mapping method
   @Test
   public void shouldMapStudentDtoToStudent() {
      StudentDto dto = new StudentDto(
        "John",
        "Doe",
        "john@gmail.com",
          2
      );

      Student student = studentMapper.toStudent(dto);

      // We want to make sure that our dto map well the classes fields
      // that the output of this dto is what we expect
      assertEquals(dto.firstname(), student.getFirstname());
      assertEquals(dto.lastname(), student.getLastname());
      assertEquals(dto.email(), student.getEmail());

      assertNotNull(student.getSchool());
      assertEquals(dto.schoolId(), student.getSchool().getId());
   }


   @Test
   public void should_thow_null_pointer_exception_when_studentDto_is_null() {
      var exception_msg = assertThrows(NullPointerException.class, () ->
          studentMapper.toStudent(null));

      assertEquals("The student dto should not be null", exception_msg.getMessage());

      /**Student studentToMap = studentMapper.toStudent(null);
      assertEquals("", studentToMap.getFirstname());
      assertEquals("", studentToMap.getLastname());
      assertEquals("", studentToMap.getEmail());

      assertNotNull(studentToMap.getSchool());
      assertEquals("", studentToMap.getSchool().getId());
       **/
   }


   // Testing the student to student response dto mapping method
   @Test
   public void shouldMapStudentToStudentResponseDto() {

      // We are giving the student object
      Student studentToMapp = new Student(
          "Juldas",
          "RAMDE",
          "email",
          21
      );

      // We're mapping the student object to student response dto
      StudentResponseDto responseDto = studentMapper.toStudentResponseDto(studentToMapp);

      // The result we're expecting
      assertEquals(responseDto.firstname(), studentToMapp.getFirstname());
      assertEquals(responseDto.lastname(), studentToMapp.getLastname());
      assertEquals(responseDto.email(), studentToMapp.getEmail());
   }

}














