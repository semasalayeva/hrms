package kodlamaio.hrms.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_day")
    private LocalDate birthOfDate;

    @Column(name = "identity_number")
    private String identityNumber;
    public Candidate(String email, String password, String firstName, String lastName, LocalDate birthOfDate, String identityNumber) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
        this.identityNumber = identityNumber;
    }
}
