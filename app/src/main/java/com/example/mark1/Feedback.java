package com.example.mark1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {

    EditText editText;
    String texdata = "";
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        editText = findViewById(R.id.editText1);
        databaseReference = FirebaseDatabase.getInstance().getReference("Feedback");
    }
    public void btnadd(View view){
        texdata=editText.getText().toString().trim();
        databaseReference.push().setValue(texdata).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                editText.setText("");

                Toast.makeText(Feedback.this,"Data Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

