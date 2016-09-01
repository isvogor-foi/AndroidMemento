package hr.heureka.memento.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hr.heureka.memento.entities.DbCategory;
import hr.heureka.memento.entities.DbTask;

/**
 * Created by ivan on 1.9.2016..
 */
public class MockDataLoader {

    public static List<DbTask> getDemoData(){
        List<DbTask> mItems = new ArrayList<>();
        mItems.add(new DbTask("Tennis on Sunday", new Date(), new DbCategory("Sport", "#000080")));
        mItems.add(new DbTask("Math", new Date(), new DbCategory("Homework", "#FF0000")));
        mItems.add(new DbTask("Drone flight", new Date(), new DbCategory("Hobby", "#CCCCCC")));
        return mItems;
    }

    public static void loadMockData(){

        // demo kategorije
        List<DbCategory> mCategories = new ArrayList<>();
        mCategories.add(new DbCategory("Sport", "#000080"));
        mCategories.add(new DbCategory("Books", "#00AA00"));
        mCategories.add(new DbCategory("Homework", "#FF0000"));
        mCategories.add(new DbCategory("Hobby", "#CCCCCC"));

        // pohrana kategorija u bazu podataka
        for (DbCategory category : mCategories){
            category.save();
        }

        // ne završeni demo zadaci
        List<DbTask> mItems = new ArrayList<>();
        mItems.add(new DbTask("Football on Sunday", new Date(), DbCategory.getCategoryByName("Sport")));
        mItems.add(new DbTask("Concert", new Date(), DbCategory.getCategoryByName("Hobby")));
        mItems.add(new DbTask("Math homework", new Date(), DbCategory.getCategoryByName("Homework")));

        // pohrana ne završenih zadataka
        for (DbTask task : mItems){
            task.save();
        }
        mItems.clear();

        // završeni demo zadaci
        mItems.add(new DbTask("Cycling cup", new Date(), DbCategory.getCategoryByName("Sport")));
        mItems.add(new DbTask("FPV AUV Flight", new Date(), DbCategory.getCategoryByName("Hobby")));

        // pohrana završeni zadataka
        for (DbTask task : mItems){
            task.setCompleted(1);
            task.save();
        }
    }
}
