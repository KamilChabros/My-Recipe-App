package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDto;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDtoConverter;
import xyz.myrecipeapp.myrecipeapp.repositories.OpinionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private OpinionDtoConverter opinionDtoConverter;

    public OpinionService(OpinionRepository opinionRepository, OpinionDtoConverter opinionDtoConverter) {
        this.opinionRepository = opinionRepository;
        this.opinionDtoConverter = opinionDtoConverter;
    }

    public List<OpinionDto> findByRecipeId(Long id) {
        return opinionRepository.findAll()
                .stream()
                .map(opinionDtoConverter::convertToDto)
                .collect(Collectors.toList());
    }
}
