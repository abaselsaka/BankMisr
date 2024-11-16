package banquemisr.challenge05.banquemisr.repository;

import banquemisr.challenge05.banquemisr.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
