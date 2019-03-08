package amin.mhd.hasan.stepsindicatorapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Hasan Mhd Amin on 3/8/2019.
 */

public class BlankFragment extends Fragment {


    private static final String ARG_COLOR = "arg_color";
    private String color;


    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String color) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getString(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        FrameLayout root = view.findViewById(R.id.root);
        root.setBackgroundColor(Color.parseColor(color));
        return view;
    }

}
