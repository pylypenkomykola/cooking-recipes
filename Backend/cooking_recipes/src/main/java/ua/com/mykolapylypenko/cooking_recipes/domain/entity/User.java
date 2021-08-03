package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users", schema = "cooking_recipe")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    public User() {
    }

    private User(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.fullName = builder.fullName;
    }

    @OneToMany(mappedBy = "user")
    private Set<SavedRecipe> savedRecipes;

    @OneToMany(mappedBy = "user")
    private Set<PostedRecipe> postedRecipes;

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Set<SavedRecipe> getSavedRecipes() {
        return savedRecipes;
    }

    public Set<PostedRecipe> getPostedRecipes() {
        return postedRecipes;
    }

    public static final class Builder{
        private String username;
        private String password;
        private String fullName;

        public Builder(){

        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
