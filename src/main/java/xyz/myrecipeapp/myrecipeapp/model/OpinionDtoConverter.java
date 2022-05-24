package xyz.myrecipeapp.myrecipeapp.model;

import org.springframework.stereotype.Component;

/*OpinionDtoConverter makes converts Opinion Entity
* to OpinionDto*/

@Component
public class OpinionDtoConverter {
    public OpinionDto convertToDto(Opinion opinion) {
        OpinionDto dto = new OpinionDto();
        dto.setContent(opinion.getContent());
        dto.setDate(opinion.getLastEditDate());
        dto.setUsername(opinion.getUser().getUsername());
        dto.setRating(opinion.getRating());
        return dto;
    }

}
