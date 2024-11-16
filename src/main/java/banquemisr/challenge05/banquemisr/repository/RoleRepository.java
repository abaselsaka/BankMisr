package banquemisr.challenge05.banquemisr.repository;


import banquemisr.challenge05.banquemisr.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
