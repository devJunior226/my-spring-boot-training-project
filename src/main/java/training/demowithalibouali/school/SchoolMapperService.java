package training.demowithalibouali.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapperService {
   // return only schools names instead of schools and their students
   public SchoolDto toSchoolDto(School school) {
      return new SchoolDto(school.getName());
   }

   // save only the school name and return it
   public School toSchool(SchoolDto schoolDto) {
      return new School(schoolDto.name());
   }
}
