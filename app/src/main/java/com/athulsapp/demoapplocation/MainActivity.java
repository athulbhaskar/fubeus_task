package com.athulsapp.demoapplocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.athulsapp.demoapplocation.Adapter.Adapter;
import com.athulsapp.demoapplocation.Model.CoffieModel;
import com.athulsapp.demoapplocation.Network.RetrofitInstence;
import com.athulsapp.demoapplocation.Network.getData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
        getdetails();
    }

    private void getdetails() {
        getData serviece= RetrofitInstence.getRetrofit().create(getData.class);
        Call<List<CoffieModel>> repos =serviece.GetData();
        repos.enqueue(new Callback<List<CoffieModel>>() {
            @Override
            public void onResponse(Call<List<CoffieModel>> call, Response<List<CoffieModel>> response) {
                loadDetails(response.body());
            }
            @Override
            public void onFailure(Call<List<CoffieModel>> call, Throwable t) {

            }
        });
    }

    private void loadDetails(List<CoffieModel> body) {
        Adapter adapter = new Adapter(body, this);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initUi() {
        recyclerView=findViewById(R.id.recyclerView);
    }
}