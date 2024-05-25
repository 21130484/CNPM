package model;

import java.io.Serializable;

public class Recipes implements Serializable {
    private int id;
    private String title;
    private String instructions;
    private int image;

    public Recipes() {
    }

    public Recipes(int id, String title, String instructions, int image) {
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
