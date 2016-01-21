package com.vito_notes;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class NoteActivity extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        db = new DBHelper(this);
    }

    public void saveNote(View view)
    {
        Context context = getApplicationContext();
        CharSequence text = "Note saved!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        /*
        * Save note database code goes here
        * */
        EditText mEdit   = (EditText)findViewById(R.id.editText1);
        String theNote = mEdit.getText().toString();

        db.insertNote(theNote);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
