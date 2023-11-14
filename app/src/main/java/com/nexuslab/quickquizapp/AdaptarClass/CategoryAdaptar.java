package com.nexuslab.quickquizapp.AdaptarClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.nexuslab.quickquizapp.CategoryFragment;
import com.nexuslab.quickquizapp.QuizFragment;
import com.nexuslab.quickquizapp.R;
import com.nexuslab.quickquizapp.modelClass.CategoryModel;

import java.util.ArrayList;

public class CategoryAdaptar extends RecyclerView.Adapter<CategoryAdaptar.ViewHolder> {
    Context context;
    ArrayList<CategoryModel> list;

    public CategoryAdaptar(Context context, ArrayList<CategoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryAdaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptar.ViewHolder holder, int position) {
        CategoryModel model = list.get(position);
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

        holder.itemView.setOnClickListener(v->{
        AppCompatActivity activity = (AppCompatActivity) v.getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new QuizFragment(model.getCategory(), model.getTitle())).addToBackStack(null).commit();
        });
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
