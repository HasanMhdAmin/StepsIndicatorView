package amin.mhd.hasan.stepsindicator;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Hasan Mhd Amin on 3/8/2019.
 */
public class StepsIndicatorView extends LinearLayout {

    private Context context;
    private int steps;
    private int color = Color.parseColor("#F9F871");
    private int previousPage = 0;

    public StepsIndicatorView(Context context) {
        super(context);
        this.context = context;
    }

    public StepsIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

    }

    public int getSteps() {
        return steps;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null)
            steps = viewPager.getAdapter().getCount();

//        LinearLayout myLayout = findViewById(R.id.testView);
        LinearLayout myLayout = this;

        myLayout.setWeightSum(steps);


        final ArrayList<View> indicators = new ArrayList<>();

        for (int i = 0; i < steps; i++) {
            View step = new View(context);
            step.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));//EB0909
            if (i == 0) {
                step.setBackgroundColor(color);
            } else
                step.setBackgroundColor(Color.parseColor("#ffffff"));
            LayoutParams p1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            p1.weight = 1;
            p1.setMarginStart(10);
            p1.setMarginEnd(10);

            step.setLayoutParams(p1);
            step.requestLayout();
            myLayout.addView(step);
            indicators.add(step);

        }


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (previousPage <= i) {
                    View v = indicators.get(i);
                    v.setBackgroundColor(color);
                } else {
                    View v = indicators.get(i + 1);
                    v.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                previousPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

}
