package hr.heureka.memento.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by ivan on 5.7.2016..
 */
public class DbTask  {

    private String name;
    private Date dueDate;
    private DbCategory category;
    private int completed;


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

}