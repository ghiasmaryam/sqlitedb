package com.example.testsqlitedb;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText ed;
    private DBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.editText);
        dBhelper = new DBhelper(this);

        // Save data when user interacts with UI (e.g., clicking a button)
        saveDataToDatabase();

    }
    private void saveDataToDatabase() {
        // Get the data from the EditText
        String userInput = ed.getText().toString();

        // Get a writable database
        SQLiteDatabase db = dBhelper.getWritableDatabase();

        // Create a ContentValues object to store the data
        ContentValues values = new ContentValues();
        values.put(DBhelper.COLUMN_TEXT, userInput);

        // Insert the data into the database
        long newRowId = db.insert(DBhelper.TABLE_NAME, null, values);

        // Close the database
        db.close();
    }
}