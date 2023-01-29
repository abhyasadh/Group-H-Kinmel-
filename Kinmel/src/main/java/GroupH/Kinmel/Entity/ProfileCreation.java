package GroupH.Kinmel.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class ProfileCreation {
    @Id
    @SequenceGenerator(name = "kinMel_user_seq_gen", sequenceName = "kinMel_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kinMel_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(name = "password")
    private String password;


}