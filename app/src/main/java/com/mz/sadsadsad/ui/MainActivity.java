package com.mz.sadsadsad.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import com.mz.sadsadsad.database.Contact;
import com.mz.sadsadsad.database.MyContactsDao;
import com.mz.sadsadsad.database.MyContactsDatabase;
import com.mz.sadsadsad.R;
import com.mz.sadsadsad.model.ContactAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyContactsDao myContactsDao;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyContactsDatabase.getInstance(getApplicationContext());
        recyclerView=findViewById(R.id.recycler_view_contacts);
        //myContactsDao=MyContactsDatabase.getInstance(this).myContactsDao();
        List<Contact>contactList=MyContactsDatabase.instance.myContactsDao().getContacts();
        ContactAdapter contactAdapter=new ContactAdapter(contactList);
        recyclerView.setAdapter(contactAdapter);

    }

    public void addNewContact(View view) {
        Intent intent=new Intent(MainActivity.this, AddContact.class);
        startActivity(intent);
    }
}