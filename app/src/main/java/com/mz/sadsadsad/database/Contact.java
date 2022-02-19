package com.mz.sadsadsad.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MyContacts")
public class Contact {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private  int id;
    @ColumnInfo(name = "Name")
    private  String name;
    @ColumnInfo(name = "Phone")
    private  String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
