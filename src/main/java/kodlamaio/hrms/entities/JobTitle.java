package kodlamaio.hrms.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "job_titles")
@Data
public class JobTitle {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    public JobTitle() {
    }


}
