package melih.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private int imageId;

    @NotBlank
    @NotNull
    @Column(name="image_url")
    private String url;

    @NotBlank
    @NotNull
    @Column(name="creation_date")
    private LocalDate creationDate = LocalDate.now();

    @JsonIgnoreProperties({"first_name","last_name","birth_date","identity_number","status","job_status"})
    @ManyToOne
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cv_id")
    private Cv cv;
}