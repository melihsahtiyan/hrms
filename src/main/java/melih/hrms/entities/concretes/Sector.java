package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sectors")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sector_id")
    private int sectorId;

    @NotBlank
    @NotNull
    @Column(name = "sector_name")
    private String sectorName;

    @JsonIgnore
    @OneToMany(mappedBy = "sector")
    private List<JobAdvertisement> jobAdvertisements;
}
