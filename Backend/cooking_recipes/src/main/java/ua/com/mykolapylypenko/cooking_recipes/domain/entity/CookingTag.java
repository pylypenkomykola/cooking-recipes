package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.public_info.PublicVariables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tags", schema = PublicVariables.DATABASE_SCHEMA_NAME)
public class CookingTag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Long tagId;

    @Column(name = "tag_name")
    private String tagName;

    public CookingTag() {
    }

    private CookingTag(Builder builder) {
        this.tagId = builder.tagId;
        this.tagName = builder.tagName;
        this.recipeTags = builder.recipeTags;
    }

    @OneToMany(mappedBy = "tag")
    private Set<RecipeTag> recipeTags;

    public Long getTagId() {
        return tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public Set<RecipeTag> getRecipeTags() {
        return recipeTags;
    }

    public static final class Builder{
        private Long tagId;
        private String tagName;
        private Set<RecipeTag> recipeTags;

        public Builder() {
        }

        public Builder tagId(Long tagId){
            this.tagId = tagId;
            return this;
        }

        public Builder tagName(String tagName){
            this.tagName = tagName;
            return this;
        }

        public Builder recipeTags(Set<RecipeTag> recipeTags){
            this.recipeTags = recipeTags;
            return this;
        }

        public CookingTag build(){
            return new CookingTag(this);
        }
    }
}
