package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_seekers"})
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_position_id")
    private int jobPositionId;

    @NotNull
    @NotBlank
    @Column(name = "job_position_name")
    private String jobPositionName;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition")
    private List<JobSeeker> jobSeekers;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition")
    private List<JobAdvertisement> jobAdvertisements;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosition")
    private List<WorkExperience> workExperiences;

}