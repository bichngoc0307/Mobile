package com.bichngoc.lab3;

<<<<<<< HEAD
=======
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

<<<<<<< HEAD
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

=======
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

<<<<<<< HEAD
=======
import com.squareup.picasso.Picasso;


>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
public class ItemFood extends AppCompatActivity {

    ListView lv;
    ArrayList<String> arrItem;
    ArrayAdapter adapter;
    TextView title, dec;
    Button more, cancel;
<<<<<<< HEAD
=======
    String urlFood;
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe

    public static ArrayList<Food> arrFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_food);

        Intent intent = getIntent();
<<<<<<< HEAD
//        get chuỗi url
//        get tiêu đề
        String url = intent.getStringExtra("url");
        String food_title = intent.getStringExtra("title");

//        ActionBar
=======
        //get chuỗi
        // xét tiêu đề
        String url = intent.getStringExtra("url");
        String food_title = intent.getStringExtra("title");
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.img_1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // ngày hiện tại
        Date date = Calendar.getInstance().getTime();
        //
        // Display a date in day, month, year format
        //
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);

<<<<<<< HEAD
//        set tiêu đề
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("PetFoodIndustry.com " + food_title + " " + today);

        lv = findViewById(R.id.list_item);


//        load rss đang xét
        new ReadRSS().execute(url);

//        set sự kiện click vào 1 item trong listView
=======
        // xét tiêu đề
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("PetFoodIndustry.com " + food_title + " " + today);

        lv = (ListView) findViewById(R.id.list_item);


        // load rss đang xét
        new ReadRSS().execute(url);

        // xét sự kiện click vào 1 item trong listView
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private ImageView image;

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
<<<<<<< HEAD
//                hiển thị dialog
=======
                // hiển thị dialog
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
                Dialog dialog = new Dialog(ItemFood.this);
                dialog.setContentView(R.layout.layout_dialog);
                title = (TextView) dialog.findViewById(R.id.dialog_item_title);
                dec = (TextView) dialog.findViewById(R.id.dialog_item_dec);
                image = (ImageView) dialog.findViewById(R.id.dialog_image);
                more = (Button) dialog.findViewById(R.id.more);
                cancel = (Button) dialog.findViewById(R.id.cancel);
                Food f = arrFood.get(i);
                title.setText(f.getTitle());
                dec.setText(f.getDec());

<<<<<<< HEAD
//                load ảnh
                ImageView imgView = (ImageView) dialog.findViewById(R.id.dialog_image);
                Glide.with(ItemFood.this).load(f.getImage()).placeholder(R.drawable.load)
                        .error(R.drawable.img_3)
                        .into(imgView);
                dialog.show();

//                set sự kiện click cancel
=======
                //load ảnh
                ImageView imgView = (ImageView) dialog.findViewById(R.id.dialog_image);
                Picasso.get().load(f.getImage()).into(imgView);
                dialog.show();

                // cancel
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                });

<<<<<<< HEAD
//                set sự kiện click more
=======
                // more
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
                more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(f.getLink()));
                        startActivity(intent);
                    }
                });

            }
        });
    }

    public void addItem() {

        arrItem = new ArrayList<>();
        for (Food value : arrFood) {
            arrItem.add(value.getTitle());
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrItem);
        lv.setAdapter(adapter);
    }

    private class ReadRSS extends AsyncTask<String, Void, String> {

        // đọc dữ liệu
        @Override
        protected String doInBackground(String... strings) {
<<<<<<< HEAD
//            khởi tạo biến chứa nội dung
            StringBuilder content = new StringBuilder();

            try {
//                khởi tạo đường dẫn
                URL url = new URL(strings[0]);

//                khởi tạo inputStream đọc dữ liệu
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

//                đọc từng dòng dữ liệu
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
//                    đổ dữ liệu vào biến content
=======
            //khởi tạo đường dẫn
            StringBuilder content = new StringBuilder();
            try {
                // khởi tạo đường dẫn
                URL url = new URL(strings[0]);

                // đọc đường dẫn kết nối
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                // tạo dòng lưu trữ
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    //đọc dòng
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
                    content.append(line + "\n");

                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

<<<<<<< HEAD
        //        trả dữ liệu sau khi đọc
=======
        // trả dữ liệu sau khi đọc
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
        @Override
        protected void onPostExecute(String s) {
            arrFood = new ArrayList<>();
            super.onPostExecute(s);
            XMLDOMParser parser = new XMLDOMParser();

<<<<<<< HEAD
//            khởi tạo document chứa nội dung cần
            Document document = parser.getDocument(s);
            String title = "", link = "", dec = "", image = "";

//            khởi tạo noteList chứa danh sách các item
            NodeList nodeList = document.getElementsByTagName("item");

//            đọc mô tả
            NodeList nodeListDescription = document.getElementsByTagName("description");

//            duyệt danh sách các item
            for (int i = 0; i < nodeList.getLength(); i++) {
//                tạo phần tử
=======
            // đọc document
            Document document = parser.getDocument(s);
            String title = "", link = "", dec = "", image = "";

            // khởi tạo noteList
            NodeList nodeList = document.getElementsByTagName("item");

            // đọc mô tả
            NodeList nodeListDescription = document.getElementsByTagName("description");
            for (int i = 0; i < nodeList.getLength(); i++) {
                // tạo phần tử
>>>>>>> ffe23e0d179a590b8ba2ffd9b3ac2a0489c8e8fe
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");


                dec = nodeListDescription.item(i + 1).getTextContent();
                dec = dec.replace("<p>", "");
                dec = dec.replace("</p>", "");


                Node media = document.getElementsByTagName("media:content").item(i);
                if (media != null) {
                    image = media.getAttributes().getNamedItem("url").getNodeValue();
                } else {
                    image = "https://t4.ftcdn.net/jpg/04/70/29/97/360_F_470299797_UD0eoVMMSUbHCcNJCdv2t8B2g1GVqYgs.jpg";
                }

                Food f = new Food(title, link, dec, image);
                arrFood.add(f);
            }

            addItem();
        }
    }

}