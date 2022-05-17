package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.exceptions.RecipeNotFoundException;
import xyz.myrecipeapp.myrecipeapp.model.Recipe;
import xyz.myrecipeapp.myrecipeapp.repositories.RecipeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe addRecipe(Recipe recipe) {
        recipe.setRecipeCode(UUID.randomUUID().toString());
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe findRecipeById(Long id) {
        return recipeRepository.findRecipeById(id)
                .orElseThrow(()-> new RecipeNotFoundException("Recipe by id " + id + " was not found!"));
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteRecipeById(id);
    }
}
