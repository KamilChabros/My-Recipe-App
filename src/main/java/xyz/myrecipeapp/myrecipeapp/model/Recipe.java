package xyz.myrecipeapp.myrecipeapp.model;


import javax.persistence.*;
import java.io.Serializable;

/*Serializable helps transform Recipe class into different types of String*/
/*@Entity makes sure, that this class is mapped to any database,
 that we configured in classpath*/

@Entity
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) //once it's set, it's set forever
    private Long id;
    private String name;
    private String tags;
    private String ingredients;
    private String recipe;
    private String imageUrl;
    private String recipeCode;

    public Recipe() {
    }

    public Recipe(Long id, String name, String tags, String ingredients, String recipe, String imageUrl, String recipeCode) {
        this.id = id;
        this.name = name;
        this.tags = tags;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.imageUrl = imageUrl;
        this.recipeCode = recipeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRecipeCode() {
        return recipeCode;
    }

    public void setRecipeCode(String recipeCode) {
        this.recipeCode = recipeCode;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", recipe='" + recipe + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", recipeCode='" + recipeCode + '\'' +
                '}';
    }
}
