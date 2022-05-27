package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.stereotype.Service;
import xyz.myrecipeapp.myrecipeapp.exceptions.MyOpinionNotFoundException;
import xyz.myrecipeapp.myrecipeapp.model.Opinion;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDto;
import xyz.myrecipeapp.myrecipeapp.model.OpinionDtoConverter;
import xyz.myrecipeapp.myrecipeapp.repositories.OpinionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final OpinionDtoConverter opinionDtoConverter;

    public OpinionService(OpinionRepository opinionRepository, OpinionDtoConverter opinionDtoConverter) {
        this.opinionRepository = opinionRepository;
        this.opinionDtoConverter = opinionDtoConverter;
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

//    public List<OpinionDto> findByOpinionId(Long id) {
//        return opinionRepository.findAll()
//                .stream()
//                .map(opinionDtoConverter::convertToDto)
//                .collect(Collectors.toList());
//    }
}
