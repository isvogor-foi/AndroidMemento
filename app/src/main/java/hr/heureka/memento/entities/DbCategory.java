package hr.heureka.memento.entities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by ivan on 5.7.2016..
 */
@Table(name = "category")
public class DbCategory extends Model {

    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;

    public DbCategory() {
    }

    public DbCategory(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

}
