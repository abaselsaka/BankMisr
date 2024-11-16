package banquemisr.challenge05.banquemisr.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title ;

    private String description;

    @NotBlank(message = "Status is mandatory")
    public Status status ;

    @NotNull(message = "Priority is mandatory")
    private int priority ;

    @NotNull(message = "Due date is mandatory")
    private LocalDate dueDate ;

}
