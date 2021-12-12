package com.example.hw2application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts;
    private ListView listViewContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);



        listViewContacts = (ListView) findViewById(R.id.listViewContacts);

        contacts = new ArrayList<>();
        contacts.add(new Contact("Oralbek","Sapar","+7 700 745 69 60",R.drawable.my_img));
        contacts.add(new Contact("Madina","Asylbek","+7 707 291 35 11",R.drawable.madina_img));
        contacts.add(new Contact("Aslan","Kakashov","+7 700 128 08 07",R.drawable.aslan_img));
        contacts.add(new Contact("Assel","Zholdasbekova","+7 707 988 07 88",R.drawable.assel_img));
        contacts.add(new Contact("Azamat","Malikov","+7 707 896 80 28",R.drawable.aza_img));
        contacts.add(new Contact("Salida","Ali","+7 747 720 41 81",R.drawable.salida_img));


        ArrayAdapter<Contact> adapter = new ArrayAdapter<>(getApplicationContext(),  android.R.layout.simple_list_item_1, contacts);
        listViewContacts.setAdapter(adapter);

        listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Contact contact = contacts.get(position);
                Intent intent = new Intent(getApplicationContext(), ContactDetailActivity.class);
                intent.putExtra("name",contact.getName());
                intent.putExtra("lastname",contact.getLastname());
                intent.putExtra("resId",contact.getImageResourceId());
                intent.putExtra("number",contact.getNumber());
                startActivity(intent);
            }
        });


    }


}