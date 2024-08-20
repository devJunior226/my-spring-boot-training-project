package training.demowithalibouali.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
    // means that this field can't be null or empty
    @NotEmpty(message = "Firstname should not be empty")
    String firstname,

    @NotEmpty(message = "Lastname should not be empty")
    String lastname,

    @Email
    String email,
    Integer schoolId
) {}

    // A student is linked to school,
    // so that we have to pass the id of the school to the dto







