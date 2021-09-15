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
@Table(name = "abilities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ability_id")
    private int abilityId;


    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToMany()
    @JoinColumn(name = "cv_id")
    private List<Cv> cvs;
}
