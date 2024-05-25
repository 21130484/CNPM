package com.example.food;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
    }
}