package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_experience_id")
    private int workExperienceId;

    @NotBlank
    @NotNull
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name = "starting_year")
    private String startingYear;

    @Column(name = "ending_year")
    private String endingYear;

    @JsonIgnoreProperties({"job_position_name"})
    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @JsonIgnore
    @ManyToMany()
    @JoinColumn(name = "cv_id")
    private List<Cv> cvs;

}
