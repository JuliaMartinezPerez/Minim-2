package com.example.restclientservweb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BadgesActivity extends AppCompatActivity {

    private ApiService apiService;
    private String username;
    private String idUser;
    private List<Badge> badges;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_badges);

        username = getIntent().getStringExtra("username");
        idUser = getIntent().getStringExtra("idUser");
        //email = getIntent().getStringExtra("email");
        Log.d("JULIA", "activity creada");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/dsaApp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        recyclerView = findViewById(R.id.viewBadges);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        if(idUser != null){
            Log.d("JULIA", "getBadges");
            getBadges();
        }

    }

    private void getBadges(){
        Call<List<Badge>> call = apiService.getBadges(idUser);
        Log.d("JULIA", "call badges");
        call.enqueue(new Callback<List<Badge>>() {
            @Override
            public void onResponse(Call<List<Badge>> call, Response<List<Badge>> response) {
                badges = response.body();
                BadgesAdapter adapter = new BadgesAdapter(BadgesActivity.this, badges);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Badge>> call, Throwable throwable) {
                Toast.makeText(BadgesActivity.this, "An error occurred", Toast.LENGTH_SHORT).show();
                backToPerfil();
            }
        });
    }

    public void click_btnBack(View v){
        backToPerfil();
    }
    public void backToPerfil(){
        Intent intent = new Intent(BadgesActivity.this, PerfilActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("idUser", idUser);
        startActivity(intent);
    }
}