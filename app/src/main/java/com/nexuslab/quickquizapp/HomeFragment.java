package com.nexuslab.quickquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexuslab.quickquizapp.AdaptarClass.HomeAdaptar;
import com.nexuslab.quickquizapp.databinding.FragmentHomeBinding;
import com.nexuslab.quickquizapp.modelClass.HomeModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<HomeModel> list = new ArrayList<>();
    HomeAdaptar adaptar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        LoadData();
        return binding.getRoot();
    }

    private void LoadData() {
        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("World", "Politics and International Affairs"));
        list.add(new HomeModel("Sports", "Latest updates in Soccer Olympic and Many More"));
        list.add(new HomeModel("General Knowledge", "Common History"));
        list.add(new HomeModel("Science", "Fundamentals of Basic Science"));
        adaptar = new HomeAdaptar(getContext(), list);
        binding.rcv.setAdapter((adaptar));

    }
}