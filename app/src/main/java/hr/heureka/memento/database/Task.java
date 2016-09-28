package hr.heureka.memento.database;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 28.09.16..
 */
@Table(database = DatabaseMain.class)
public class Task extends BaseModel {

    @PrimaryKey(autoincrement = true)
    long id;

    @Column
    String name;
    @Column
    Date dueDate;
    @Column
    int completed;

    @Column
    @ForeignKey(tableClass = Category.class)
    Category category;

    public Task() {}


    public Task(String name, Date dueDate, Category category) {
        this.name = name;
        this.dueDate = dueDate;
        this.category = category;
        this.completed = 0;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Category getCategory(){
        return category;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public static List<Task> getAll(int completed){
        return SQLite.select().from(Task.class).where(Task_Table.completed.eq(completed)).orderBy(Task_Table.completed, false).queryList();
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
