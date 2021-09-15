package melih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_staffs")
public class SystemStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_staff_id")
    private int systemStaffId;

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @JsonIgnoreProperties({"password","status"})
    @OneToOne()
    @JoinColumn(name ="users_user_id", referencedColumnName = "user_id")
    private User user;
}
