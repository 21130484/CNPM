package com.example.food;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import DAO.DatabaseHelper;
import model.Recipes;
import model.RecipesAdapter;

public class ListFavorite extends AppCompatActivity {
    private final String DATABASE_NAME = "data.db";
    private RecyclerView recycler;
    private RecipesAdapter recipesAdapter;
    private TextView home, favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite);

        recycler = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);
        List<Recipes> recipesList = DatabaseHelper.getRecipeFavorite(MainActivity.database, 1);
        recipesAdapter = new RecipesAdapter(this, recipesList);
        recycler.setAdapter(recipesAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recycler.addItemDecoration(itemDecoration);

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
    }

    private void goToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}