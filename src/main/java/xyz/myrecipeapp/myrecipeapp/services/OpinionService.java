package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.exceptions.MyOpinionNotFoundException;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDto;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDtoConverter;
import xyz.myrecipeapp.myrecipeapp.model.Recipe;
import xyz.myrecipeapp.myrecipeapp.repositories.OpinionRepository;
import xyz.myrecipeapp.myrecipeapp.repositories.RecipeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final OpinionDtoConverter opinionDtoConverter;
    private final RecipeService recipeService;
    public OpinionService(OpinionRepository opinionRepository, OpinionDtoConverter opinionDtoConverter, RecipeRepository recipeRepository, RecipeService recipeService, RecipeRepository recipeRepository1) {
        this.opinionRepository = opinionRepository;
        this.opinionDtoConverter = opinionDtoConverter;
        this.recipeService = recipeService;
    }

    public List<OpinionDto> findAllOpinions() {
        return opinionRepository.findAll()
                .stream()
                .map(opinionDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<OpinionDto> findByOpinionId(Long id) {
        if (!opinionRepository.existsById(id)) {
            throw new MyOpinionNotFoundException("Opinion with id " + id + " was not found");
        }
        return opinionRepository.findById(id)
                .stream()
                .map(opinionDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public List<OpinionDto> findOpinionByRecipeId(Long id) {

        Recipe recipe = recipeService.findRecipeById(id);
        if (!opinionRepository.existsById(id)) {
            throw new MyOpinionNotFoundException("Recipe with id " + id + " does not have opinion");
        }
        return opinionRepository.findByRecipe(recipe)
                .stream()
                .map(opinionDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
