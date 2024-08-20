package training.demowithalibouali.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
   private final SchoolMapperService schoolMapperService;
   private final SchoolRepository schoolRepository;

   public SchoolService(SchoolMapperService schoolMapperService,
                        SchoolRepository schoolRepository) {
      this.schoolMapperService = schoolMapperService;
      this.schoolRepository = schoolRepository;
   }


   // Save a school
   public SchoolDto saveSchool(SchoolDto schoolDto) {
      var school = this.schoolMapperService.toSchool(schoolDto);
      schoolRepository.save(school);
      return schoolDto;
   }

   // Get all school saved
   public List<SchoolDto> findAllSchools() {
      return this.schoolRepository.findAll()
          .stream()
          .map(this.schoolMapperService::toSchoolDto)
          .collect(Collectors.toList());
   }
}
