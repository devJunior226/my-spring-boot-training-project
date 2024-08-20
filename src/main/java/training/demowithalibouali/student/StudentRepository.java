package training.demowithalibouali.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

   // find students by firstnames
   List<Student> findAllByFirstnameContaining(String word);
}

