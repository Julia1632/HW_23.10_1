package com.example.user.myapplication;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LaunchActivity extends AppCompatActivity {
    private View mButtonLogin;
    private View mButtonLogup;
    private FragmentSingin fragmentSingin;
    private FragmentSingup fragmentSingup;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        init();
    }
    public void init() {
        mButtonLogin = findViewById(R.id.buttonLogin);
        mButtonLogup = findViewById(R.id.buttonLogup);
        fragmentSingin = new FragmentSingin();
        fragmentSingup = new FragmentSingup();
    }

    public void onClick(View view) {
        fragmentTransaction=getFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.buttonLogin:
                fragmentTransaction.add(R.id.fragment, fragmentSingin).show(fragmentSingin);break;
            case R.id.buttonLogup:
                fragmentTransaction.replace(R.id.fragment, fragmentSingup).show(fragmentSingup);break;
        }
        fragmentTransaction.commit();

    }

}


