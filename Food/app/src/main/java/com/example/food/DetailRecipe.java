package com.example.food;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import DAO.DatabaseHelper;
import model.Recipes;

public class DetailRecipe extends AppCompatActivity {
    TextView header_title,title,instructions;
    ImageView img;
    Button btn_favorite;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recipe);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) return;
        Recipes recipe = (Recipes) bundle.get("recipe");
        header_title = findViewById(R.id.header_title);
        title = findViewById(R.id.title);
        instructions = findViewById(R.id.instructions);
        header_title.setText(recipe.getTitle());
        title.setText(recipe.getTitle());
        instructions.setText(recipe.getInstructions());
        btn_favorite = findViewById(R.id.btn_favorite);
        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DatabaseHelper.addFavoriteRecipe(MainActivity.database, 1, recipe.getId()) != -1) {
                    Toast.makeText(DetailRecipe.this, "Đã thêm vào danh sách yêu thích!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}