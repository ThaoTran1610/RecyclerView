package com.example.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewUser;
    List<User> users;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.recyclerUser);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        final UserAdapter userAdapter =new UserAdapter();
        recyclerViewUser.setAdapter(userAdapter);


        User user1 =new User("Lan", 8);
        User user2 =new User("Hoa", 9);
        User user3 =new User("Anh", 10);

        users = new ArrayList<User>();

            users.add(user1);
            users.add(user2);
            users.add(user3);

        userAdapter.users = users;

        click = findViewById(R.id.button_add);

        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                users.add(new User("Mai", 7));
                userAdapter.notifyDataSetChanged();

            }
        });

        click = findViewById(R.id.button_update);

        click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                users.get(2).name="Nhat";
                users.get(2).score=8;
                userAdapter.notifyDataSetChanged();

            }
        });


    }
}
