package com.bichngoc.modernartui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LinearLayout();
            case 1:
                return new RelativeLayout();
            case 2:
                return new TableLayout();
            default:
                return new LinearLayout();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
