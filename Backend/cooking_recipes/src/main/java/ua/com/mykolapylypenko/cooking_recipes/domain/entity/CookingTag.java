package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tags", schema = "cooking_recipes")
public class CookingTag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag")
    private Long tagId;

    @Column(name = "tag_name")
    private String tagName;

    public CookingTag() {
    }

    public CookingTag(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
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
