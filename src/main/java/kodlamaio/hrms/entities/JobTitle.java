package kodlamaio.hrms.entities;

import javax.persistence.*;

@Entity
@Table(name = "job_titles")
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    public JobTitle() {
    }

    public JobTitle(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
