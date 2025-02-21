package com.example.myapplication2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

public class BTBackground extends AppCompatActivity {

    Switch switchBackgournd;
    int cur;
    int last;
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        bg.setBackgroundColor(Color.BLUE);
        bg.setBackgroundResource(R.drawable.background_intro);


        arrayList.add(R.drawable.logo);
        arrayList.add(R.drawable.pizza);
        arrayList.add(R.drawable.background_intro);
        arrayList.add(R.drawable.pop_3);

        //Random background
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));
        cur = vitri;

        chuyenBackground();
    }

    private void chuyenBackground(){
        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        Switch switchBackgournd = (Switch) findViewById(R.id.switch1);
        switchBackgournd.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                last = cur;
                cur = (cur + 1) % arrayList.size();
                bg.setBackgroundResource(arrayList.get(cur));
            } else {
                cur = last;
                bg.setBackgroundResource(arrayList.get(last));
            }
        });
    }
}