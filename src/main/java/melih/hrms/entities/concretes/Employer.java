package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import melih.hrms.core.entities.concretes.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue
    @Column(name = "employer_id")
    private int employerId;

    @NotNull
    @NotBlank
    @Column(name = "company_name")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name = "web_site")
    private String webSite;

    @NotNull
    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnoreProperties({"password","status"})
    @OneToOne()
    @JoinColumn(name ="users_user_id", referencedColumnName = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}