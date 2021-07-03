package com.example.mark1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class First extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private Button signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        auth = FirebaseAuth.getInstance();

        signOut = (Button) findViewById(R.id.logout);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(First.this, LoginActivity.class));
                finish();

            }

        });

    }


    public void communication(View view){
        Intent intent = new Intent(getApplicationContext(), Communication.class);
        startActivity(intent);
    }
    public void leadership(View view){
        Intent intent = new Intent(getApplicationContext(), Leadership.class);
        startActivity(intent);
    }
    public void organisation(View view){
        Intent intent = new Intent(getApplicationContext(), Organisation.class);
        startActivity(intent);
    }
    public void problem(View view){
        Intent intent = new Intent(getApplicationContext(), Problem.class);
        startActivity(intent);
    }



}


