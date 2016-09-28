package hr.heureka.memento.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hr.heureka.memento.database.Category;
import hr.heureka.memento.database.Task;

/**
 * Created by ivan on 1.9.2016..
 */
public class MockDataLoader {



    public static void loadMockData2(){

        // demo kategorije
        List<Category> mCategories = new ArrayList<>();
        mCategories.add(new Category("Sport", "#000080"));
        mCategories.add(new Category("Books", "#00AA00"));
        mCategories.add(new Category("Homework", "#FF0000"));
        mCategories.add(new Category("Hobby", "#CCCCCC"));

        // pohrana kategorija u bazu podataka
        for (Category category : mCategories){
            category.save();
        }

        // ne završeni demo zadaci
        List<Task> mItems = new ArrayList<>();
        mItems.add(new Task("Football on Sunday", new Date(), Category.getCategoryByName("Sport")));
        mItems.add(new Task("Concert", new Date(), Category.getCategoryByName("Hobby")));
        mItems.add(new Task("Math homework", new Date(), Category.getCategoryByName("Homework")));

        // pohrana ne završenih zadataka
        for (Task task : mItems){
            task.save();
        }
        mItems.clear();

        // završeni demo zadaci
        mItems.add(new Task("Cycling cup", new Date(), Category.getCategoryByName("Sport")));
        mItems.add(new Task("FPV AUV Flight", new Date(), Category.getCategoryByName("Hobby")));

        // pohrana završeni zadataka
        for (Task task : mItems){
            task.setCompleted(1);
            task.save();
        }
    }
}
