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
}
