package com.example.exp23;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button firstFragmentBtn, secondFragmentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragmentBtn = findViewById(R.id.button1);
        secondFragmentBtn= findViewById(R.id.button2);

        if (savedInstanceState == null) {
            // Create an instance of the default fragment
            Fragment_1 defaultFragment = new Fragment_1();
            
            // Get the FragmentManager and start a fragment transaction
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, defaultFragment) // Add the default fragment to the container
                    .commit();
        }

        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new Fragment_1());
            }
        });
        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new Fragment_2());
            }
        });



    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}