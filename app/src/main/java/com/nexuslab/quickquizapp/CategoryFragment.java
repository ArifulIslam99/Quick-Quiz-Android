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
import com.nexuslab.quickquizapp.modelClass.HomeModel;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;
    ArrayList<HomeModel> list = new ArrayList<>();
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
            list.add(new HomeModel("Capitals of the World", ""));
            list.add(new HomeModel("Famous Landmarks", ""));
            list.add(new HomeModel("World Geography", ""));
            list.add(new HomeModel("Historical Events", ""));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));
        }
        else if(title.equals("Sports"))
        {
            list.add(new HomeModel("Olympic Games", ""));
            list.add(new HomeModel("Famous Athletes", ""));
            list.add(new HomeModel("Rules and Regulations", ""));
            list.add(new HomeModel("Sports History", ""));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));


        }
        else if(title.equals("General Knowledge"))
        {
            list.add(new HomeModel("Inventions and Discoveries", ""));
            list.add(new HomeModel("Literature and Arts", ""));
            list.add(new HomeModel("Current Affairs", ""));
            list.add(new HomeModel("Famous Personalities", ""));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));
        }
        else if(title.equals("Science"))
        {
            list.add(new HomeModel("Physics Wonders", ""));
            list.add(new HomeModel("Chemistry Concepts", ""));
            list.add(new HomeModel("Space and Astronomy", ""));
            list.add(new HomeModel("Environmental Science", ""));
            adaptar = new CategoryAdaptar(getContext(), list);
            binding.rcv.setAdapter((adaptar));
        }

    }
}