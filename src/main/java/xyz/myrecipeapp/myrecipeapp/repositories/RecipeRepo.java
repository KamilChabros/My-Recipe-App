package xyz.myrecipeapp.myrecipeapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.myrecipeapp.myrecipeapp.model.Recipe;

import java.util.Optional;

public interface RecipeRepo extends JpaRepository <Recipe, Long> {
    Optional<Recipe> findRecipeById(Long id);

    void deleteRecipeById(Long id);
}
