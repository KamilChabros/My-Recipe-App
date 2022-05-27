package xyz.myrecipeapp.myrecipeapp.model;

import org.springframework.stereotype.Component;

/*OpinionDtoConverter makes converts Opinion Entity
* to OpinionDto*/

@Component
public class OpinionDtoConverter {
    public OpinionDto convertToDto(Opinion opinion) {
        OpinionDto dto = new OpinionDto();
        dto.setUsername(opinion.getUser().getUsername());
        dto.setRating(opinion.getRating());
        dto.setDate(opinion.getLastEditDate());
        dto.setContent(opinion.getContent());
        return dto;
    }

}
