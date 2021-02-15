package com.hfad.mycheckboxapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    public RecyclerView recyclerView;
    private List<CheckNames> namesCard;
    private NamesAdapter namesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycle_view);
        getList();

        namesAdapter = new NamesAdapter(namesCard, this);
        recyclerView.setAdapter(namesAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void getList() {
        namesCard = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            namesCard.add(new CheckNames("Name " + i, false, 0));
        }

    }

    @Override
    public void onItemClicked(int position, boolean isChecked) {

        CheckNames checkName = namesCard.get(position);
        int count = checkName.getCount();

        checkName.setChecked(isChecked);
        if (checkName.isChecked()) {
            count++;
            Log.d("TAG", "if (checkNames.isChecked()) {: count = [" + count + "]");
        }
        if (count > 2) {
            count = count / 2;
        }
        checkName.setCount(count);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                namesAdapter.notifyItemChanged(position);
            }
        });


    }
}