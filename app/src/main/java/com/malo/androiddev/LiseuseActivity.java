package com.malo.androiddev;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.malo.androiddev.LiseusePager.LiseuseDialog;
import com.malo.androiddev.LiseusePager.LiseusePagerAdapter;

public class LiseuseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liseuse);



        LiseusePagerAdapter adapter = new LiseusePagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);



        LiseuseDialog liseuseDialog = new LiseuseDialog();

        //liseuseDialog.show(getSupportFragmentManager(),"infodialog");
    }


}
