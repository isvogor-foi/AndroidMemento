package hr.heureka.memento.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by ivan on 28.09.16..
 */
@Database(name = DatabaseMain.NAME, version = DatabaseMain.VERSION)
public class DatabaseMain {
    public static final String NAME = "DatabaseMain";
    public static final int VERSION = 4;
}
