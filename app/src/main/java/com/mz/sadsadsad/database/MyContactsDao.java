package com.mz.sadsadsad.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mz.sadsadsad.database.Contact;

import java.util.List;

@Dao
public interface MyContactsDao {
    @Insert
    void insertContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Update
    void getContacts(Contact contact);

    @Query("SELECT * FROM MyContacts")
    List<Contact> getContacts();

    @Query("DELETE FROM MyContacts")
    void deleteMyContacts();

}
