package hr.heureka.memento.entities;

import java.util.Date;

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

}