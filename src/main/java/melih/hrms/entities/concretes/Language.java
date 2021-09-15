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
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int languageId;

    @NotNull
    @NotBlank
    @Column(name = "language")
    private String language;

    @NotNull
    @NotBlank
    @Column(name = "level")
    private String level;

    @JsonIgnore
    @ManyToMany()
    @JoinColumn(name = "cv_id")
    private List<Cv> cvs;

}
