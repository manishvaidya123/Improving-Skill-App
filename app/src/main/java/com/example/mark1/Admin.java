package com.example.mark1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {
    EditText Name, Pass, updateold, updatenew, delete;
    myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        Name = (EditText) findViewById(R.id.editName);
        Pass = (EditText) findViewById(R.id.editPass);
        updateold = (EditText) findViewById(R.id.editText3);
        updatenew = (EditText) findViewById(R.id.editText5);
        delete = (EditText) findViewById(R.id.editText6);

        helper = new myDbAdapter(this);
    }

    public void addUser(View view) {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter Both Name and Password", Toast.LENGTH_LONG).show();
        } else {
            long id =helper.insertData(t1, t2);
            if (id <= 0) {
                Toast.makeText(getApplicationContext(), "Insertion Unsuccessful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Pass.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Insertion Successful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Pass.setText("");
            }
        }
    }
    public void viewdata(View view)
    {
        String data = helper.getData();
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
    }




    public void update(View view) {
        String u1 = updateold.getText().toString();
        String u2 = updatenew.getText().toString();
        if (u1.isEmpty() || u2.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter Data", Toast.LENGTH_LONG).show();
        } else {
            int a = helper.updateName(u1, u2);
            if (a <= 0) {
                Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
                updateold.setText("");
                updatenew.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                updateold.setText("");
                updatenew.setText("");
            }
        }

    }

    public void delete(View view) {
        String uname = delete.getText().toString();
        if (uname.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter Data", Toast.LENGTH_SHORT).show();
        } else {
            int a = helper.delete(uname);
            if (a <= 0) {
                Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
                delete.setText("");
            } else {
                Toast.makeText(this, "DELETED", Toast.LENGTH_SHORT).show();
                delete.setText("");
            }
        }
    }
}



