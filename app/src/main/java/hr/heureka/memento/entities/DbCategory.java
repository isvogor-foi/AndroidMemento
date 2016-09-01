package hr.heureka.memento.entities;

import java.util.List;

/**
 * Created by ivan on 5.7.2016..
 */
public class DbCategory {

    private String name;
    private String color;

    public DbCategory(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

}
