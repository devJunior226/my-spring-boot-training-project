package training.demowithalibouali.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
   private final SchoolService schoolService;

   public SchoolController(SchoolService schoolService) {
      this.schoolService = schoolService;
   }

   // Save a school
   @PostMapping("/schools")
   public SchoolDto postSchool(@RequestBody SchoolDto schoolDto) {
      return this.schoolService.saveSchool(schoolDto);
   }

   // return only the list of schools
   @GetMapping("/schools")
   public List<SchoolDto> getAllSchools() {
      return this.schoolService.findAllSchools();
   }
}
