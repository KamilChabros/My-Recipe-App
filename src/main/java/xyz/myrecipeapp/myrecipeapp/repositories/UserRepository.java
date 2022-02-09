package xyz.myrecipeapp.myrecipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.myrecipeapp.myrecipeapp.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);
    Boolean existsByUsername (String username);
    Boolean existsByEmail (String email);
}
