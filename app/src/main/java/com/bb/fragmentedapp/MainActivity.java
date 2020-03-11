package com.bb.fragmentedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ExampleFragment.ExampleFragmentDelegate {

    private ExampleFragment exampleFragment = new ExampleFragment();

    private SecondFragment secondFragment = new SecondFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOpenFragments(View view) {

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame, exampleFragment)
                .addToBackStack(exampleFragment.getTag())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame_bottom, secondFragment)
                .addToBackStack(secondFragment.getTag())
                .commit();
    }


    public void communicateToSecond(String message){
        secondFragment.displayMessage(message);
    }
}
