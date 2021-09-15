package melih.hrms.entities.concretes;

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
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cvId;

    @Column(name = "github_link")
    private String githubLink;


    @NotNull
    @NotBlank
    @Column(name = "linkedin_link")
    private String linkedinLink;

    @NotBlank
    @Column(name = "university_enterance_date")
    @NotNull
    private Date universityEnteranceDate;

    @Column(name = "graduation_date")
    private Date graduationDate;

    @NotNull
    @NotBlank
    @Column(name = "preface")
    private String preface;

    @JsonIgnoreProperties({"first_name","last_name","birth_date","identity_number","status","job_status"})
    @OneToOne()
    @JoinColumn(name ="job_seekers_job_seeker_id", referencedColumnName = "job_seeker_id")
    private JobSeeker jobSeeker;

    @JsonIgnoreProperties({"company_name","starting_year","ending_year",""})
    @ManyToMany()
    @JoinColumn(name = "work_experience_id")
    private List<WorkExperience> workExperiences;

    @JsonIgnoreProperties({"language","level"})
    @ManyToMany()
    @JoinColumn(name = "language_id")
    private List<Language> language;

    @JsonIgnoreProperties({"description"})
    @ManyToMany()
    @JoinColumn(name = "ability_id")
    private List<Ability> ability;

    @JsonIgnoreProperties({"school_name","department"})
    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;

    @JsonIgnoreProperties({"image_url","creation_date"})
    @OneToMany(mappedBy = "cv")
    private List<Image> images;

}
