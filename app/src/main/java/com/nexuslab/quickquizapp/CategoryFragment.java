package com.nexuslab.quickquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexuslab.quickquizapp.AdaptarClass.CategoryAdaptar;
import com.nexuslab.quickquizapp.databinding.FragmentCategoryBinding;
import com.nexuslab.quickquizapp.databinding.FragmentHomeBinding;
import com.nexuslab.quickquizapp.modelClass.CategoryModel;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;
    ArrayList<CategoryModel> list = new ArrayList<>();
    CategoryAdaptar adaptar;
    String title;
    public CategoryFragment() {
    }

    public CategoryFragment( String title) {
        this.title = title;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        if(title.equals("World"))
        {
            list.add(new CategoryModel("Capitals of the World", "", "World"));
            list.add(new CategoryModel("Famous Landmarks", "", "World"));
            list.add(new CategoryModel("World Geography", "", "World"));
            list.add(new CategoryModel("Historical Events", "", "World"));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));
        }
        else if(title.equals("Sports"))
        {
            list.add(new CategoryModel("Olympic Games", "", "Sports"));
            list.add(new CategoryModel("Famous Athletes", "", "Sports"));
            list.add(new CategoryModel("Rules and Regulations", "", "Sports"));
            list.add(new CategoryModel("Sports History", "", "Sports"));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));


        }
        else if(title.equals("General Knowledge"))
        {
            list.add(new CategoryModel("Inventions and Discoveries", "", "General Knowledge"));
            list.add(new CategoryModel("Literature and Arts", "", "General Knowledge"));
            list.add(new CategoryModel("Current Affairs", "", "General Knowledge"));
            list.add(new CategoryModel("Famous Personalities", "", "General Knowledge"));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));
        }
        else if(title.equals("Science"))
        {
            list.add(new CategoryModel("Physics Wonders", "", "Science"));
            list.add(new CategoryModel("Chemistry Concepts", "", "Science"));
            list.add(new CategoryModel("Space and Astronomy", "", "Science"));
            list.add(new CategoryModel("Environmental Science", "", "Science"));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));
        }

    }
}