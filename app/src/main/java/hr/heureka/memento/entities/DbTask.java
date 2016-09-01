package hr.heureka.memento.entities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 5.7.2016..
 */
@Table(name="task")
public class DbTask extends Model {

    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date dueDate;
    @Column (name = "category")
    private DbCategory category;

    @Column (name = "completed")
    private int completed;

    public DbTask() {}


    public DbTask(String name, Date dueDate, DbCategory category) {
        this.name = name;
        this.dueDate = dueDate;
        this.category = category;
        this.completed = 0;
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

    public DbCategory getCategory() {
        return category;
    }

    public void setCategory(DbCategory category) {
        this.category = category;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public static List<DbTask> getAll(int completed){
        return new Select().from(DbTask.class).where("completed = ?", completed).orderBy("date DESC").execute();
    }

}