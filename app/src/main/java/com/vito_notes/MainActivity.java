package com.vito_notes;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button buttonStartNoteActivity;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);

        this.showNotes();
    }

    /*
    * Procedure that shows the notes on startup
    * */
    public void showNotes()
    {
        /*
        * Code to query database and show
        * all the notes
        * */
        String result = "";
        Cursor theCursor = db.getAllData();
        theCursor.moveToFirst();
        result += theCursor.getString(1) + "-";
        while(theCursor.moveToNext()){
            //create new TextView and add it to the screen

            result += theCursor.getString(1) + "-";
        }
        this.showToast(result);

    }


    public void addNote(View view)
    {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    public void showToast(String theMessage)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, theMessage, duration);
        toast.show();
    }

}
