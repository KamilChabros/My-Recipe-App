package xyz.myrecipeapp.myrecipeapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.myrecipeapp.myrecipeapp.model.Opinion;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDto;
import xyz.myrecipeapp.myrecipeapp.services.OpinionService;

import java.util.List;

@RestController
@RequestMapping("/api/opinions")
public class OpinionController {

    private final OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("/all") //??
    public ResponseEntity<List<OpinionDto>> getAllOpinions(){
        List<OpinionDto> opinions = opinionService.findAllOpinions();
        return new ResponseEntity<>(opinions, HttpStatus.OK);
    }

    @GetMapping("/{id}") //??
    public List<OpinionDto> getOpinionById(@PathVariable("id") Long id) {
        return opinionService.findByOpinionId(id);
    }
}
