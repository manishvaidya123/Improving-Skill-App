package com.example.mark1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {
    android.widget.Spinner spinner;
    EditText editText;
    String texdata="";

    DatabaseReference databaseReference;
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner=findViewById(R.id.spinner);
        editText=findViewById(R.id.editText1);

        databaseReference= FirebaseDatabase.getInstance().getReference("SpinnerData");

        arrayList=new ArrayList<>();
        adapter=new ArrayAdapter<String>(Spinner.this,android.R.layout.simple_spinner_dropdown_item,arrayList);

        spinner.setAdapter(adapter);
        retrieveData();
    }

    public void btnadd(View view){
        texdata=editText.getText().toString().trim();
        databaseReference.push().setValue(texdata).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                editText.setText("");
                arrayList.clear();
                retrieveData();
                adapter.notifyDataSetChanged();

                Toast.makeText(Spinner.this,"Data Inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void retrieveData(){
    listener=databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot item:dataSnapshot.getChildren()){
                arrayList.add(item.getValue().toString());
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });
    }
}