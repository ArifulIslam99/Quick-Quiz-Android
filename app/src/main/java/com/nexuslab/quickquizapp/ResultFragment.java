package com.nexuslab.quickquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexuslab.quickquizapp.databinding.FragmentResultBinding;

public class ResultFragment extends Fragment {

    FragmentResultBinding binding;
    int right, allQuestion;
    public ResultFragment() {
        // Required empty public constructor
    }

    public ResultFragment(int right, int allQuestion) {
    this.right = right;
    this.allQuestion = allQuestion;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentResultBinding.inflate(getLayoutInflater());
       binding.correct.setText(String.valueOf(right)+" Correct");
       binding.incorrect.setText(String.valueOf(allQuestion-right)+" Incorrect");
       binding.score.setText("You got "+right+" out of "+allQuestion+"!");


       if(right <= 3)
       {
           binding.salute.setText("Try Again for Better Score!");
       }
        return binding.getRoot();
    }
}