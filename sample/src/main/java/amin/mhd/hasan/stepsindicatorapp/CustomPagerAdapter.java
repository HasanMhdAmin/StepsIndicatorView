package amin.mhd.hasan.stepsindicatorapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Hasan Mhd Amin on 3/6/2019.
 */
public class CustomPagerAdapter extends FragmentPagerAdapter {


    Context context;

    public CustomPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return BlankFragment.newInstance("#7E57C2");
            case 1:
                return BlankFragment.newInstance("#5C6BC0");
            case 2:
                return BlankFragment.newInstance("#42A5F5");
            case 3:
                return BlankFragment.newInstance("#26A69A");
            case 4:
                return BlankFragment.newInstance("#D4E157");
            default:
                return BlankFragment.newInstance("#005CD9");
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
