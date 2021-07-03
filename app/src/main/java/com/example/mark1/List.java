package com.example.mark1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {
    ListView mListView;

    int[] image={R.drawable.skill, R.drawable.skill1, R.drawable.skill3, R.drawable.login, R.drawable.skill5};
    String[] Name={"Types Of Skills","Role Of User","Audio & Video","Admin Login","Feedback"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView=(ListView)findViewById(R.id.listv);

        CustomAdapter customAdapter=new CustomAdapter();
        mListView.setAdapter(customAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getApplicationContext(), First.class);
                    intent.putExtra("name", Name);
                    startActivity(intent);
                }
                if (i == 1) {
                    Intent intent = new Intent(getApplicationContext(), Spinner.class);
                    intent.putExtra("name", Name);
                    startActivity(intent);
                }
                if (i == 2) {
                    Intent intent = new Intent(getApplicationContext(),Video.class);
                    intent.putExtra("name", Name);
                    startActivity(intent);
                }
                if (i == 3) {
                    Intent intent = new Intent(getApplicationContext(), Admin.class);
                    intent.putExtra("name", Name);
                    startActivity(intent);
                }
                if (i == 4) {
                    Intent intent = new Intent(getApplicationContext(), Second.class);
                    intent.putExtra("name", Name);
                    startActivity(intent);
                }

            }
        });
    }


    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView=view.findViewById(R.id.imageView1);
            TextView textView=view.findViewById(R.id.textview);
            imageView.setImageResource(image[position]);
            textView.setText(Name[position]);
            return view;
        }
    }
}


