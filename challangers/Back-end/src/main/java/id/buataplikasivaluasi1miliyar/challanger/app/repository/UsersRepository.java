package id.buataplikasivaluasi1miliyar.challanger.app.repository;

import id.buataplikasivaluasi1miliyar.challanger.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, String>{
    // Cari userId terbesar (contoh: CHL-0007)
    @Query("SELECT u.user_id FROM User u ORDER BY u.user_id DESC LIMIT 1")
    Optional<String> findLastUserId();
}