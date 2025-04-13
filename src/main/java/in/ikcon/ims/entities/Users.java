package in.ikcon.ims.entities;

import in.ikcon.ims.enums.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users extends Auditable{

    @Column(name = "email" , unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "entity_name")
    private String entityName;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "creator" ,
            orphanRemoval = true , cascade = CascadeType.ALL)
    @OrderBy("created_date DESC")
    private List<Tickets> tickets = new ArrayList<>();
}
