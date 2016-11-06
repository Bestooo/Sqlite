package com.example.marwa.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.marwa.sqlite.adapters.ContactAdapter;
import com.example.marwa.sqlite.db.Data;
import com.example.marwa.sqlite.db.DbHelper;
import com.example.marwa.sqlite.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelper helper = new DbHelper(this);
        db = helper.getWritableDatabase();
        getContactData();

    }

    private void getContactData() {
        List<Contact> contactList = new ArrayList<Contact>();
        String columns[]={Data.KEY_ID , Data.KEY_NAME , Data.KEY_PHONE};
        Cursor c = db.query(Data.TABLE_NAME,columns,null,null,null,null,Data.KEY_NAME);
        if(c.moveToFirst()){
            do{
//               int idIndex =  c.getColumnIndex(Data.KEY_ID);
//                int contact_id  = c.getInt(idIndex);
                int contact_id = c.getInt(c.getColumnIndex(Data.KEY_ID));
                String contact_name = c.getString(c.getColumnIndex(Data.KEY_NAME));
                String contact_phone = c.getString(c.getColumnIndex(Data.KEY_PHONE));
                contactList.add(new Contact(contact_id,contact_name,contact_phone));


            }while(c.moveToNext());


            ListView list = (ListView) findViewById(R.id.listView);
            ContactAdapter adapter = new ContactAdapter(this,contactList);
            list.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.add:
                Intent i = new Intent(MainActivity.this,NewContact.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
