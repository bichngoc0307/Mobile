package com.bmt.lab4;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bmt.lab4.constant.Party;
import com.bmt.lab4.dto.President;
import com.bmt.lab4.entity.Officials;
import com.bumptech.glide.Glide;

public class DetailPhotoActivity extends AppCompatActivity {

    private TextView role;
    private TextView name;
    private ImageView avatar;
    private ConstraintLayout wrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_photo);
        role = findViewById(R.id.textView2);
        name = findViewById(R.id.textView3);
        avatar = findViewById(R.id.imageView);
        wrapper = findViewById(R.id.wrapper);
        int position = getIntent().getIntExtra("position",-1);
        President president = (President) getIntent().getSerializableExtra("president");
        Officials officials = null;
        if(position != -1){
            officials = MainActivity.civic.getOfficials().get(position);
        }
        role.setText( president.getRole());
        name.setText( officials.getName());
        if(officials.getParty().equals(Party.DEMOCRATIC)){
            wrapper.setBackgroundColor(Color.BLUE);
        }else if(officials.getParty().equals(Party.REPUBLICAN)){
            wrapper.setBackgroundColor(Color.RED);
        }else{
            wrapper.setBackgroundColor(Color.BLACK);
        }
        Glide.with(this).load(officials.getPhotoUrl()).placeholder(R.drawable.img_1)
                .error(R.drawable.img)
                .into(avatar);
    }
}