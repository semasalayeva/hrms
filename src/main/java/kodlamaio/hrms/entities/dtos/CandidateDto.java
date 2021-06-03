package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto extends UserDto{
    private String firstName;
    private String lastName;
    private String birthOfDate;
    private String identityNumber;
}
