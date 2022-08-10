package com.bassant.madarsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bassant.madarsoft.Adapter.UserDetailsAdapter;

public class GetData extends AppCompatActivity {
    RecyclerView userRecyclerView;
    Button createUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();

    }

    private void init() {
        userRecyclerView = findViewById(R.id.user_recycler_view);
        createUserBtn = findViewById(R.id.create_user_button);
        createUserBtn.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
        getData();
    }

    private void getData() {
        userRecyclerView.setAdapter(new UserDetailsAdapter(getApplicationContext(), DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData()));
    }
}