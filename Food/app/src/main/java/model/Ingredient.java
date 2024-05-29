package model;

public class Ingredient {
    private int id;
    private int recipeId;
    private String name;

    public Ingredient(int id, int recipeId, String name) {
        this.id = id;
        this.recipeId = recipeId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
