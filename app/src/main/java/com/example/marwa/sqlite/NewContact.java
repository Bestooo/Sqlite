package com.example.marwa.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.marwa.sqlite.db.Data;
import com.example.marwa.sqlite.db.DbHelper;

public class NewContact extends AppCompatActivity {

    private EditText nameField;
    private EditText phoneField;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DbHelper helper = new DbHelper(this);
         db = helper.getWritableDatabase();
        nameField = (EditText) findViewById(R.id.editText);
         phoneField = (EditText) findViewById(R.id.editText2);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               long row =  saveNewContacts();
                if(row > 0) {
                    final Snackbar snackBar = Snackbar.make(view, "Contact Saved", Snackbar.LENGTH_LONG);
                    snackBar.setAction("Dismiss", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackBar.dismiss();
                            }
                        }).show();
                }
            }
        });
    }

    private long saveNewContacts() {
        ContentValues values = new ContentValues();
        values.put(Data.KEY_NAME,nameField.getText().toString());
        values.put(Data.KEY_PHONE,phoneField.getText().toString());

        long insertedRow = db.insert(Data.TABLE_NAME, null, values);
        return insertedRow;
    }

}
