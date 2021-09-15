package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_application_id")
    private int jobApplicationId;

    @JsonIgnoreProperties({"first_name","last_name","birth_date","identity_number","status","job_status"})
    @ManyToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @JsonIgnoreProperties({"salary","needed_employee","status","job_description","expiration_date","release_date","city","education_level"})
    @ManyToOne()
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;
}
