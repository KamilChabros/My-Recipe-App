package xyz.myrecipeapp.myrecipeapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

/*Not using lombok, cause of problems with
* relation ManyToOne may occur*/
@Entity
@Table(name = "opinion")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user; // import User from model package?
    @Enumerated(EnumType.STRING) // default are numbers 1 - OK,2 - NOK,etc.
    private ERating rating; //changed from String to ERating
    private String content;
    private ZonedDateTime lastEditDate; //changed from String to ZonedDateTime

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERating getRating() {
        return rating;
    }

    public void setRating(ERating rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(ZonedDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
