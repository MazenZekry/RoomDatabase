package com.mz.sadsadsad.model;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mz.sadsadsad.database.Contact;
import com.mz.sadsadsad.database.MyContactsDatabase;
import com.mz.sadsadsad.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {
    List<Contact> contactList;

    public ContactAdapter(List<Contact>contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
    Contact contact=contactList.get(position);
    holder.textViewName.setText(contact.getName());
    holder.textViewNumber.setText(contact.getPhone());
    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
           new AlertDialog.Builder(v.getContext())
                   .setMessage("Are you sure to delete this contact")
                   .setNegativeButton("Cancel",null)
                    .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MyContactsDatabase.instance.myContactsDao().deleteContact(contact);
                    contactList.remove(holder.getAdapterPosition());
                    notifyItemChanged(holder.getAdapterPosition());
                }
            }).show();

            return false;
        }
    });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactHolder extends RecyclerView.ViewHolder{
        TextView textViewName,textViewNumber;
        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.tv_contact_name);
            textViewNumber=itemView.findViewById(R.id.tv_contact_number);
        }
    }
}
