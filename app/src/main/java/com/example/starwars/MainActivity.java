package com.example.starwars;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starwars.API.APIClient;
import com.example.starwars.API.APIService;
import com.example.starwars.API.Result;
import com.example.starwars.Model.Planets;

import java.util.ArrayList;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Planets> list = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        //setup recyclerview
        recyclerView=findViewById(R.id.recyclerview_planets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        readJSON();

    }

    public void readJSON(){
        APIService getResponse = APIClient.getAPIService();
        Call<Result> call = getResponse.showPlanets();
        call.enqueue(new Callback<Result>(){

            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    AdapterPlanet adapter = new AdapterPlanet(MainActivity.this,response.body().getResult());
                    adapter.updateList(response.body().getResult());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
