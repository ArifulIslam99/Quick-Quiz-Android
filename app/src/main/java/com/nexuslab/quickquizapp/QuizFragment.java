package com.nexuslab.quickquizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nexuslab.quickquizapp.databinding.FragmentQuizBinding;
import com.nexuslab.quickquizapp.modelClass.HomeModel;
import com.nexuslab.quickquizapp.modelClass.QuizModel;

import java.util.ArrayList;
import java.util.Objects;


public class QuizFragment extends Fragment {

    private int position = 0;
    int right = 0;
    private static String answer = null;
    String positionNo;
    FragmentQuizBinding binding;
    ArrayList<QuizModel> list = new ArrayList<>();
    int allQuestion;
    String listSize;

    QuizModel quizModel;

    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuizBinding.inflate(getLayoutInflater());
        LoadQuestion();
        EnableOption();
        return binding.getRoot();
    }

    private void EnableOption() {
        binding.option1.setEnabled(true);
        binding.option2.setEnabled(true);
        binding.option3.setEnabled(true);
        binding.option4.setEnabled(true);
        binding.nextBtn.setEnabled(false);
    }

    private void LoadQuestion() {
        list.add(new QuizModel("Que1", "Op1", "Op2", "Op3", "Op4", "Op2"));
        list.add(new QuizModel("Que2", "Op1", "Op2", "Op3", "Op4", "Op1"));
        list.add(new QuizModel("Que3", "Op1", "Op2", "Op3", "Op4", "Op2"));
        list.add(new QuizModel("Que4", "Op1", "Op2", "Op3", "Op4", "Op3"));
        list.add(new QuizModel("Que5", "Op1", "Op2", "Op3", "Op4", "Op4"));

        allQuestion = list.size();
        listSize = String.valueOf(allQuestion);
        binding.totalQn.setText("/" + listSize);

        if (position != allQuestion) {
            positionNo = String.valueOf(position + 1);
        } else {
            positionNo = String.valueOf(position);
        }

        quizModel = list.get(position);
        answer = quizModel.getCorrectAnswer();

        binding.questionCon.setText(quizModel.getQuestion());
        binding.option1.setText(quizModel.getOp1());
        binding.option2.setText(quizModel.getOp2());
        binding.option3.setText(quizModel.getOp3());
        binding.option4.setText(quizModel.getOp4());

        optionCheckUp();

    }

    private void optionCheckUp() {
        binding.option1.setOnClickListener(v -> {
            if (Objects.equals(quizModel.getOp1(), quizModel.getCorrectAnswer())) {
                right++;
                binding.option1.setBackgroundResource(R.drawable.correct_background);
            } else {
                showRightAns();
                binding.option1.setBackgroundResource(R.drawable.incorrect_background);
            }

            DisableOption();
        });

        binding.option2.setOnClickListener(v -> {
            if (Objects.equals(quizModel.getOp2(), quizModel.getCorrectAnswer())) {
                right++;
                binding.option2.setBackgroundResource(R.drawable.correct_background);
            } else {
                showRightAns();
                binding.option2.setBackgroundResource(R.drawable.incorrect_background);
            }
            DisableOption();
        });

        binding.option3.setOnClickListener(v -> {
            if (Objects.equals(quizModel.getOp3(), quizModel.getCorrectAnswer())) {
                right++;
                binding.option3.setBackgroundResource(R.drawable.correct_background);
            } else {
                showRightAns();
                binding.option3.setBackgroundResource(R.drawable.incorrect_background);
            }
            DisableOption();
        });

        binding.option4.setOnClickListener(v -> {
            if (Objects.equals(quizModel.getOp4(), quizModel.getCorrectAnswer())) {
                right++;
                binding.option4.setBackgroundResource(R.drawable.correct_background);
            } else {
                showRightAns();
                binding.option4.setBackgroundResource(R.drawable.incorrect_background);
            }
            DisableOption();
        });
    }

    private void DisableOption() {
        binding.option1.setEnabled(false);
        binding.option2.setEnabled(false);
        binding.option3.setEnabled(false);
        binding.option4.setEnabled(false);
        binding.nextBtn.setEnabled(true);
    }

    private void showRightAns() {
        if (Objects.equals(quizModel.getOp1(), quizModel.getCorrectAnswer())) {
            binding.option1.setBackgroundResource(R.drawable.correct_background);
        } else  if (Objects.equals(quizModel.getOp2(), quizModel.getCorrectAnswer())) {
            binding.option2.setBackgroundResource(R.drawable.correct_background);
        } else  if (Objects.equals(quizModel.getOp3(), quizModel.getCorrectAnswer())) {
            binding.option3.setBackgroundResource(R.drawable.correct_background);
        } else  if (Objects.equals(quizModel.getOp4(), quizModel.getCorrectAnswer())) {
            binding.option4.setBackgroundResource(R.drawable.correct_background);
        }
    }
}