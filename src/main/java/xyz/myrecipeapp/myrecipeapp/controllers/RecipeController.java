package xyz.myrecipeapp.myrecipeapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xyz.myrecipeapp.myrecipeapp.model.Recipe;
import xyz.myrecipeapp.myrecipeapp.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // shows all recipes
    @GetMapping("/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.findAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
        Recipe recipes = recipeService.findRecipeById(id);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        Recipe updateRecipe = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(updateRecipe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
