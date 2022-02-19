package com.mz.sadsadsad.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// @TypeConverter(DatabaseConverters.class) lw h3ml convert
@Database(entities = {Contact.class},version =2,exportSchema = false)
public abstract class MyContactsDatabase extends RoomDatabase {
    public static MyContactsDatabase instance;
    public abstract MyContactsDao myContactsDao();
    public static MyContactsDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context,MyContactsDatabase.class,"ContactsDatabase")
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

}
