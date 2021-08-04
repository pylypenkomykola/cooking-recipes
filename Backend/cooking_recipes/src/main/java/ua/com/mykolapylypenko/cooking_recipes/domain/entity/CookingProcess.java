package ua.com.mykolapylypenko.cooking_recipes.domain.entity;

import ua.com.mykolapylypenko.cooking_recipes.public_info.PublicVariables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cooking_processes", schema = PublicVariables.DATABASE_SCHEMA_NAME)
public class CookingProcess implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cooking_process")
    private Long cookingProcessId;

    @Column(name = "description")
    private String description;

    @Column(name = "time_spend")
    private String timeSpend;

    public CookingProcess() {
    }

    public CookingProcess(Builder builder) {
        this.cookingProcessId = builder.cookingProcessId;
        this.description = builder.description;
        this.timeSpend = builder.timeSpend;
    }

    @OneToMany(mappedBy = "cookingProcess")
    private Set<RecipeProcess> recipeProcesses;

    public Long getCookingProcessId() {
        return cookingProcessId;
    }

    public String getDescription() {
        return description;
    }

    public String getTimeSpend() {
        return timeSpend;
    }

    public Set<RecipeProcess> getRecipeProcesses() {
        return recipeProcesses;
    }

    public final class Builder{
        private Long cookingProcessId;
        private String description;
        private String timeSpend;
        private Set<RecipeProcess> recipeProcesses;

        public Builder(){

        }

        public Builder cookingProcessId(Long cookingProcessId){
            this.cookingProcessId = cookingProcessId;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder timeSpend(String timeSpend){
            this.timeSpend = timeSpend;
            return this;
        }

        public Builder recipeProcesses(Set<RecipeProcess> recipeProcesses){
            this.recipeProcesses = recipeProcesses;
            return this;
        }

        public CookingProcess build(){
            return new CookingProcess(this);
        }
    }
}
