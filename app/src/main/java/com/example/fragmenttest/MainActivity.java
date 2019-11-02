package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private boolean isFragmentA = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.frameLayout, new FragmentA());
        ft.commit();

        Button switchBtn = (Button)findViewById(R.id.switchBtn);
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });


    }

    public void switchFragment(){
        Fragment fr;

        if(isFragmentA){
            fr= new FragmentB();
            isFragmentA = false;
        } else{
            fr = new FragmentA();
            isFragmentA = true;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.frameLayout, fr);
        ft.commit();
    }
}
