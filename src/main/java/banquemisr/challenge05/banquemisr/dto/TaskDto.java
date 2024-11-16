package banquemisr.challenge05.banquemisr.dto;

import banquemisr.challenge05.banquemisr.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String title ;
    private String description;
    public  Status status ;
    private int priority ;
    private LocalDate dueDate ;
}
