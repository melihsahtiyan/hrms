package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advertisement_id")
    private int jobAdvertisement_id;

    @NotNull
    @NotBlank
    @Column(name = "salary")
    private String salary;

    @NotNull
    @NotBlank
    @Column(name = "needed_employee")
    private int neededEmployee;

    @Column(name = "status")
    private boolean status;

    @NotNull
    @NotBlank
    @Column(name = "job_description")
    private String jobDescription;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    @NotNull
    @NotBlank
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    @NotNull
    @NotBlank
    @Column(name = "release_date")
    private Date releaseDate;

    @NotNull
    @NotBlank
    @Column(name = "city")
    private String city;

    @NotNull
    @NotBlank
    @Column(name = "education_level")
    private String educationLevel;

    @JsonIgnoreProperties({"company_name","web_site","phone_number"})
    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @JsonIgnoreProperties({"job_position_name"})
    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @JsonIgnoreProperties({"sector_name"})
    @ManyToOne()
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @JsonIgnore
    @OneToMany(mappedBy = "jobAdvertisement")
    private List<JobApplication> jobApplications;
}
