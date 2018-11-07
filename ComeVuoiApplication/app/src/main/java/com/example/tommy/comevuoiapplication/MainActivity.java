package com.example.tommy.comevuoiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import model.Movie;

public class MainActivity extends AppCompatActivity {



    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> imagesURL = new ArrayList<>();
    private NewRequest request;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request = new NewRequest();
        initBipMapImage();
    }

    private void initBipMapImage(){
        names = request.getTitles();
        imagesURL = request.getImages();
        initRecicleView();
    }

    public void initRecicleView(){
        RecyclerView recyclerView = findViewById(R.id.recicleView);
        ViewAdapter viewAdapter = new ViewAdapter(names, imagesURL, this);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
