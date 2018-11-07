package com.example.tommy.comevuoiapplication;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import model.Movie;
import rest.RestInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewRequest extends AppCompatActivity {

    private ArrayList<String > titles = new ArrayList<>();
    private ArrayList<String> urlImages = new ArrayList<>();
    private String[] requestTitles = {"Halloween", "Venom", "Iron Man", "Rocky", "Harry Potter", "The lord of the rings"};

    public NewRequest(){
        doRequest();
    }

    private void doRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestInterface restInterface = retrofit.create(RestInterface.class);

        for(int i = 0; i < requestTitles.length; i++){

            restInterface.getMovie(requestTitles[i], "97d25df9").enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    titles.add(response.body().getTitle());
                    urlImages.add(response.body().getUrlImage());
                    if(requestTitles.length == urlImages.size()){
                        initRecicleView();
                    }
                }
                @Override
                public void onFailure(Call<Movie> call, Throwable t) {
                    System.out.println("Error Api");
                }
            });
        }
    }

    public ArrayList<String> getTitles(){
        return titles;
    }

    public ArrayList<String> getImages() {
        return urlImages;
    }

    public void initRecicleView(){
        RecyclerView recyclerView = findViewById(R.id.recicleView);
        ViewAdapter viewAdapter = new ViewAdapter(titles, urlImages, this);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
