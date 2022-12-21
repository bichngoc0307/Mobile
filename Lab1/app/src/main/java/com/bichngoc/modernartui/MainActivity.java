package com.bichngoc.modernartui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.viewpager2.widget.ViewPager2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;



public class MainActivity extends AppCompatActivity {

    private TabLayout TabLayout;
    private ViewPager2 ViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout = findViewById(R.id.tab_layout);
        ViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        ViewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(TabLayout, ViewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("LinearLayout");
                    break;
                case 1:
                    tab.setText("RelativeLayout");
                    break;
                case 2:
                    tab.setText("TableLayout");
                    break;
            }
        }).attach();

    }
//    khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

//    gán sự kiện cho item trong menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                AlertDialog dialog = openDialog();
                dialog.show();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    hiện Dialog
    private AlertDialog openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("This is Team9")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // START THE GAME!
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}