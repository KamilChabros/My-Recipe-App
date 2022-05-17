package xyz.myrecipeapp.myrecipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.myrecipeapp.myrecipeapp.model.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
