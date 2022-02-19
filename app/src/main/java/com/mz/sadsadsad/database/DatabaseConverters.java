package com.mz.sadsadsad.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class DatabaseConverters {
    @TypeConverter
    public String userToJson(Contact contact) {
        Gson gson = new Gson();
        return gson.toJson(contact);
    }

    @TypeConverter
    public Contact jsonToUser(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Contact.class);

    }
}