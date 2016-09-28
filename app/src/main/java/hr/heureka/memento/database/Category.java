package hr.heureka.memento.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Created by ivan on 28.09.16..
 */
@Table(database = DatabaseMain.class)
public class Category extends BaseModel {

    //must not be private
    @Column
    @PrimaryKey(autoincrement = true)
    long id;
    @Column
    String name;
    @Column
    String color;

    public Category(){}

    public Category(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public static Category getCategoryByName(String name){
        return SQLite.select().from(Category.class).where(Category_Table.name.eq(name)).querySingle();
    }

    public static List<Category> getAll(){
        return SQLite.select().from(Category.class).queryList();
    }

}
