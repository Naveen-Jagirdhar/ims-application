package in.ikcon.ims.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import in.ikcon.ims.enums.Priority;
import in.ikcon.ims.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tickets extends Auditable{

    private String title;
    private String ticketNo;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_user_id")
    @JsonBackReference
    private Users creator;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approver_emp_id")
    @JsonBackReference
    private Employees approver;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.CREATED;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority = Priority.LOW;
}
