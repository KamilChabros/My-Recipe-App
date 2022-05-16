package xyz.myrecipeapp.myrecipeapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "opinion")
public class Opinion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String rating;
    private String content;
    private String date;

    public Opinion() {
    }

    public Opinion(Long id, String user, String rating, String content, String date) {
        this.id = id;
        this.user = user;
        this.rating = rating;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
