package xyz.myrecipeapp.myrecipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.myrecipeapp.myrecipeapp.model.Opinion;
import xyz.myrecipeapp.myrecipeapp.model.Recipe;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
    List<Opinion> findByRecipe(Recipe recipe);
}
