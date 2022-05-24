package xyz.myrecipeapp.myrecipeapp.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class OpinionDto {

     /*id is not necessary, cause is data transfer object,
     *not every field should be visible */

    private String username;
    private ERating rating;
    private String content;
    private ZonedDateTime date;
}
