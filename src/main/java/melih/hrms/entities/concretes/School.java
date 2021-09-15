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
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int schoolId;

    @NotNull
    @NotBlank
    @Column(name = "school_name")
    private String schoolName;

    @NotNull
    @NotBlank
    @Column(name = "department")
    private String department;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Cv> cvs;
}
