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
    private int selectedColor = Color.parseColor("#F9F871");
    private int unSelectedColor = Color.GRAY;
    private int previousPage = 0;
    private ViewPager viewPager;
    private int indicatorSpacing = 10;

    public StepsIndicatorView(Context context) {
        super(context);
        this.context = context;
    }

    public StepsIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

    }

    public int getUnSelectedColor() {
        return unSelectedColor;
    }

    public void setUnSelectedColor(int unSelectedColor) {
        this.unSelectedColor = unSelectedColor;
        build();
    }

    public int getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
        build();
    }

    public int getIndicatorSpacing() {
        return indicatorSpacing;
    }

    public void setIndicatorSpacing(int indicatorSpacing) {
        this.indicatorSpacing = indicatorSpacing;
        build();
    }

    public int getSteps() {
        return steps;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        build();
    }

    private void build() {

        this.removeAllViews();
        previousPage = 0;
        if (viewPager != null && viewPager.getAdapter() != null)
            steps = viewPager.getAdapter().getCount();

        this.setWeightSum(steps);

        final ArrayList<View> indicators = new ArrayList<>();

        for (int i = 0; i < steps; i++) {
            View step = new View(context);
            step.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));//EB0909
            if (i == 0) {
                step.setBackgroundColor(selectedColor);
            } else
                step.setBackgroundColor(unSelectedColor);
            LayoutParams p1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            p1.weight = 1;
            p1.setMarginStart(indicatorSpacing);
            p1.setMarginEnd(indicatorSpacing);

            step.setLayoutParams(p1);
            step.requestLayout();
            this.addView(step);
            indicators.add(step);

        }

        if (viewPager != null) {

            viewPager.clearOnPageChangeListeners();

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {
                    if (previousPage <= i) {
                        View v = indicators.get(i);
                        v.setBackgroundColor(selectedColor);
                    } else {
                        View v = indicators.get(i + 1);
                        v.setBackgroundColor(unSelectedColor);
                    }
                    previousPage = i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
        }
    }
}
