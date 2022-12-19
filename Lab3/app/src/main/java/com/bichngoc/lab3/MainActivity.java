package com.bichngoc.lab3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
<<<<<<< HEAD
=======
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listTieuDe;
    ArrayList<String> arrTitle;
    ArrayAdapter arrayAdapter;
    ArrayList<String> url;


    public void addUrl() {
        url = new ArrayList<>();
        url.add("https://www.petfoodindustry.com/rss/topic/292-proteins");
        url.add("https://www.petfoodindustry.com/rss/topic/293-amino-acids");
        url.add("https://www.petfoodindustry.com/rss/topic/294-grains-and-starches");
        url.add("https://www.petfoodindustry.com/rss/topic/295-fibers-and-legumes");
        url.add("https://www.petfoodindustry.com/rss/topic/296-vitamins");
        url.add("https://www.petfoodindustry.com/rss/topic/297-minerals");
        url.add("https://www.petfoodindustry.com/rss/topic/298-nutraceuticals");
        url.add("https://www.petfoodindustry.com/rss/topic/299-processing-functional-ingredients");
    }

    public void addString() {
        arrTitle = new ArrayList<>();
        arrTitle.add("Proteins");
        arrTitle.add("Amino Acids");
        arrTitle.add("Grains and Starches");
        arrTitle.add("Fibers and Legumes");
        arrTitle.add("Vitamins");
        arrTitle.add("Minerals");
        arrTitle.add("Nutraceuticals");
        arrTitle.add("Processing functional ingredients");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.img_1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

<<<<<<< HEAD
//        hiển thị ngày
        Date date = Calendar.getInstance().getTime();
=======

        Date date = Calendar.getInstance().getTime();

//        hiển thị ngày
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);

//        hiển thị tiêu đề
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("PetFoodIndustry.com " + today);

        listTieuDe = (ListView) findViewById(R.id.list_title);
<<<<<<< HEAD
        addUrl();
        addString();

//        khởi tạo mảng chuỗi Adapter
=======

        addUrl();
        addString();

        // khởi tạo mảng chuỗi adapter
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrTitle);
        listTieuDe.setAdapter(arrayAdapter);
        listTieuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ItemFood.class);
                intent.putExtra("url", url.get(i));
                intent.putExtra("title", arrTitle.get(i));
                startActivity(intent);
            }
        });


    }


}