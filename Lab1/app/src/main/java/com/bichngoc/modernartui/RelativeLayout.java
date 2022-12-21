package com.bichngoc.modernartui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import java.util.Random;

public class RelativeLayout extends Fragment {

    private View view1, view2, view3, view4, view5;
    private SeekBar seekBar;

    public RelativeLayout() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.linear_layout, container, false);

        seekBar = view.findViewById(R.id.seekBar);
        view1 = view.findViewById(R.id.view1);
        view2 = view.findViewById(R.id.view2);
        view3 = view.findViewById(R.id.view3);
        view4 = view.findViewById(R.id.view4);
        view5 = view.findViewById(R.id.view5);
        seekBar.setMax(5);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Random rnd = new Random();
                int color1 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                int color2 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                int color3 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                int color4 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                int color5 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                view1.setBackgroundColor(color1);
                view2.setBackgroundColor(color2);
                view3.setBackgroundColor(color3);
                view4.setBackgroundColor(color4);
                view5.setBackgroundColor(color5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
}