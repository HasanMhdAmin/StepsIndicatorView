package amin.mhd.hasan.stepsindicatorapp;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import amin.mhd.hasan.stepsindicator.StepsIndicatorView;

/**
 * Created by Hasan Mhd Amin on 3/8/2019.
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private StepsIndicatorView indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);

        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);


//        //set spacing between indicators
//        indicator.setIndicatorSpacing(10);
//
//        //set selected indicators color
//        indicator.setSelectedColor(Color.GREEN);
//
//        //set unSelected indicators color
//        indicator.setUnSelectedColor(Color.WHITE);

        indicator.setupWithViewPager(viewPager);



    }
}
