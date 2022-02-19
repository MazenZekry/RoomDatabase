
package com.mz.sadsadsad.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.mz.sadsadsad.database.Contact;
import com.mz.sadsadsad.database.MyContactsDatabase;
import com.mz.sadsadsad.R;

public class AddContact extends AppCompatActivity {
    TextView textViewName,textViewPhone;
    TextInputEditText editTextName,editTextPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        textViewName=findViewById(R.id.tv_contact_name);
        textViewPhone=findViewById(R.id.tv_contact_number);
        editTextPhone=findViewById(R.id.et_phoneNumber);
        editTextName=findViewById(R.id.et_username);

    }

    public void addContact(View view) {
        String username=editTextName.getText().toString();
        String phone=editTextPhone.getText().toString();
        if(username.isEmpty())
        {
            editTextName.setError("Name required");
            return;
        }
        if (phone.isEmpty())
        {
            editTextPhone.setError("Phone is required");
            return;
        }
    Contact contact=new Contact(username,phone);
        MyContactsDatabase.instance.myContactsDao().insertContact(contact);
        Intent intent=new Intent(AddContact.this, MainActivity.class);
        startActivity(intent);
    }
}