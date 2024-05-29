package com.example.food;

import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import DAO.DatabaseHelper;
import model.Recipes;

public class DetailRecipe extends AppCompatActivity {
    TextView title,instructions;
    ImageView img;
    Button btn_favorite;
    private SQLiteDatabase database;
    TextView ingredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) return;
        Recipes recipe = (Recipes) bundle.get("recipe");
        title = findViewById(R.id.title);
        img = findViewById(R.id.img);
        instructions = findViewById(R.id.instructions);
        title.setText(recipe.getTitle());
        AssetManager manager = this.getAssets();
        try {
            InputStream inputStream = manager.open(recipe.getImage());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            img.setImageDrawable(drawable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        instructions.setText(recipe.getInstructions());
        ingredients = findViewById(R.id.ingredients);
        String ingredient = DatabaseHelper.getIngredientName(MainActivity.database, recipe.getId());
        ingredients.setText(ingredient);
        btn_favorite = findViewById(R.id.btn_favorite);
        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DatabaseHelper.addFavoriteRecipe(DetailRecipe.this, 1, recipe.getId()) != -1) {
                    Toast.makeText(DetailRecipe.this, "Đã thêm vào danh sách yêu thích!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}