package model;

import com.example.food.R;

import java.io.Serializable;

public class Recipes implements Serializable {
    private int id;
    private String title;
    private String instructions;
    private String image;

    public Recipes() {
    }

    public Recipes(int id, String title, String instructions, String image) {
        this.id = id;
        this.title = title;
        this.instructions = instructions;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructions='" + instructions + '\'' +
                ", image=" + image +
                '}';
    }

}
