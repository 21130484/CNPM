package model;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.food.DetailRecipe;
import com.example.food.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>{

    private List<Recipes> listRecipes;
    private Context context;

    public RecipesAdapter(Context context, List<Recipes> listRecipes) {
        this.listRecipes = listRecipes;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list, parent, false);
        return new RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        Recipes recipes = this.listRecipes.get(position);
        if (recipes == null) {
            return;
        }
        AssetManager manager = context.getAssets();
        try {
            InputStream inputStream = manager.open(recipes.getImage());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            holder.img.setImageDrawable(drawable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        holder.text.setText(recipes.getTitle());
        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetail(recipes);
            }

        });
    }
    public void updateData(List<Recipes> newRecipesList) {
        this.listRecipes = newRecipesList;
        notifyDataSetChanged();
    }

    public void goToDetail(Recipes recipes) {
        Intent intent = new Intent(context, DetailRecipe.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("recipe", recipes);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void release() {
        this.context = null;
    }

    @Override
    public int getItemCount() {
        if (this.listRecipes != null) {
            return this.listRecipes.size();
        }
        return 0;

    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView img;
        private TextView text;
        private RelativeLayout layout_item;

        public RecipesViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.title);
            layout_item = itemView.findViewById(R.id.layout_item);
        }
    }

}
