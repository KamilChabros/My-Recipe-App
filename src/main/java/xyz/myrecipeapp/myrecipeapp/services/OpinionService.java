package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDto;
import xyz.myrecipeapp.myrecipeapp.repositories.OpinionRepository;

import java.util.List;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public OpinionService(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    public List<OpinionDto> findByRecipeId(Long id) {
        return null;
    }
}
