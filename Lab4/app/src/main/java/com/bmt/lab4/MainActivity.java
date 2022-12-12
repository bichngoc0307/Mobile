package com.bmt.lab4;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bmt.lab4.adapter.RecyclerAdapter;
import com.bmt.lab4.dto.President;
import com.bmt.lab4.entity.CivicInformation;
import com.bmt.lab4.entity.Offices;
import com.bmt.lab4.entity.Officials;
import com.bmt.lab4.repo.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView location;
    ProgressBar progressBar;
    private RecyclerView recyclerView;
    public static CivicInformation civic;

    private List<President> presidents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressbar);
        getCivicInformation();
        location = findViewById(R.id.location);
        recyclerView = findViewById(R.id.recyclerView);
        getCivicInformation();
    }
    private void renderData(){
        location.setText(civic.getNormalizedInput().getLine1()+","+civic.getNormalizedInput().getCity()+","+civic.getNormalizedInput().getState()+","+civic.getNormalizedInput().getZip());

        int index = 0;
        for (Officials official : civic.getOfficials()){
            presidents.add(new President(findRoleByName(index),official.getName(),official.getParty()));
            index ++;
        }
        RecyclerAdapter adapter = new RecyclerAdapter((position)->{
            Intent intent = new Intent(MainActivity.this, OfficialActivity.class);
            intent.putExtra("position",position);
            intent.putExtra("president",presidents.get(position));
            startActivity(intent);
        });
        adapter.setData(presidents);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private String findRoleByName(Integer index){
        for (Offices office : civic.getOffices()){
            for(Integer i: office.getOfficialIndices()){
                if(index == i){
                    return office.getName();
                }
            }
        }
        return "";
    }

    private void getCivicInformation(){
        Call<CivicInformation> call = RetrofitClient.getInstance().getMyApi().getCivicInformation();
        call.enqueue(new Callback<CivicInformation>() {
            @Override
            public void onResponse(Call<CivicInformation> call, Response<CivicInformation> response) {
                CivicInformation civics = response.body();
                civic = civics;
                renderData();
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<CivicInformation> call, Throwable t) {
                Log.e("THANH", t.getMessage());
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_avatar:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}