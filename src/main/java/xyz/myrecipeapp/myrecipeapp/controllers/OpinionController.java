package xyz.myrecipeapp.myrecipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDto;
import xyz.myrecipeapp.myrecipeapp.services.OpinionService;

import java.util.List;

@RestController
@RequestMapping("api/opinions")
public class OpinionController {

    private OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("/recipe/{id}") //??
    public List<OpinionDto> getAll(@PathVariable("id") Long id) {
        return opinionService.findByRecipeId(id);
    }
}
