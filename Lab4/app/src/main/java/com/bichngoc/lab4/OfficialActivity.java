package com.bichngoc.lab4;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bichngoc.lab4.constant.Party;
import com.bichngoc.lab4.dto.President;
import com.bichngoc.lab4.entity.Channel;
import com.bichngoc.lab4.entity.Officials;
import com.bumptech.glide.Glide;


public class OfficialActivity extends AppCompatActivity {
    private TextView role;
    private TextView name;
    private TextView party;
    private TextView address;
    private TextView phone;
    private TextView email;
    private TextView website;
    private ConstraintLayout wrapper;
    private ImageView avatar;

    private ImageView facebook;
    private ImageView youtube;
    private ImageView google;

    private Officials officials2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official);
        wrapper = findViewById(R.id.wrapper);
        role = findViewById(R.id.textView2);
        name = findViewById(R.id.textView3);
        party = findViewById(R.id.textView4);
        address = findViewById(R.id.textView6);
        phone = findViewById(R.id.textView11);
        email = findViewById(R.id.textView15);
        website = findViewById(R.id.textView17);
        avatar = findViewById(R.id.imageView);
        facebook = findViewById(R.id.imageView10);
        youtube = findViewById(R.id.imageView9);
        google = findViewById(R.id.imageView8);


        int position = getIntent().getIntExtra("position", -1);
        President president = (President) getIntent().getSerializableExtra("president");
        Officials officials = null;
        if (position != -1) {
            officials = MainActivity.civic.getOfficials().get(position);
        }
        role.setText(president.getRole());
        name.setText(officials.getName());
        party.setText(officials.getParty());
        address.setText(officials.getAddress() != null ? (officials.getAddress().get(0).getLine1() + "," + officials.getAddress().get(0).getCity() + "," + officials.getAddress().get(0).getState() + "," + officials.getAddress().get(0).getZip()) : "No data provider");
        phone.setText(officials.getPhones().get(0));
        email.setText("No data provider");
        website.setText(officials.getUrls().get(0));

//        m??u n???n theo ?????ng ph??i
        if (officials.getParty().equals(Party.DEMOCRATIC)) {
            wrapper.setBackgroundColor(Color.BLUE);
        } else if (officials.getParty().equals(Party.REPUBLICAN)) {
            wrapper.setBackgroundColor(Color.RED);
        } else {
            wrapper.setBackgroundColor(Color.BLACK);
        }
//        load ???nh
        Glide.with(this).load(officials.getPhotoUrl()).placeholder(R.drawable.img_1)
                .error(R.drawable.img)
                .into(avatar);

        avatar.setOnClickListener(v -> {
            Intent intent = new Intent(OfficialActivity.this, DetailPhotoActivity.class);
            intent.putExtra("position", position);
            intent.putExtra("president", president);
            startActivity(intent);
        });
//        s??? ki???n click c??c m???ng x?? h???i
        officials2 = officials;
        facebook.setOnClickListener(v -> {
            String url = "https://www.facebook.com/";
            for (Channel c : officials2.getChannels()) {
                if (c.getType().equals("Facebook")) {
                    url = url + c.getId();
                }
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
        youtube.setOnClickListener(v -> {
            String url = "https://www.youtube.com/";
            for (Channel c : officials2.getChannels()) {
                if (c.getType().equals("YouTube")) {
                    url = url + c.getId();
                }
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
        google.setOnClickListener(v -> {
            String url = "https://www.plus.google.com/";
            for (Channel c : officials2.getChannels()) {
                if (c.getType().equals("GooglePlus")) {
                    url = url + c.getId();
                }
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}