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
    String category, title;

    public QuizFragment() {
        // Required empty public constructor
    }

    public QuizFragment(String category, String title) {
        this.category = category;
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuizBinding.inflate(getLayoutInflater());
        LoadQuestion();
        EnableOption();
        binding.nextBtn.setOnClickListener(v -> {
            position++;
            LoadQuestion();
            EnableOption();
            ClearOption();
            CheckNext();
        });
        return binding.getRoot();
    }

    private void CheckNext() {
        if (position == allQuestion) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new ResultFragment(right, allQuestion, category)).commit();
            list.clear();
            position = 0;
        }
    }

    private void ClearOption() {
        binding.option1.setBackgroundResource(R.drawable.category_background);
        binding.option2.setBackgroundResource(R.drawable.category_background);
        binding.option3.setBackgroundResource(R.drawable.category_background);
        binding.option4.setBackgroundResource(R.drawable.category_background);
        binding.nextBtn.setBackgroundResource(R.drawable.disabled);
    }

    private void EnableOption() {
        binding.option1.setEnabled(true);
        binding.option2.setEnabled(true);
        binding.option3.setEnabled(true);
        binding.option4.setEnabled(true);
        binding.nextBtn.setEnabled(false);
    }

    private void LoadQuestion() {
        switch (title) {
            case "Capitals of the World":
                list.add(new QuizModel("What is the capital of France?", "Berlin", "Paris", "Rome", "Madrid", "Paris"));
                list.add(new QuizModel("Which city is the capital of Japan?", "Beijing", "Seoul", "Tokyo", "Bangkok", "Tokyo"));
                list.add(new QuizModel("What is the capital of Australia?", "Sydney", "Brisbane", "Melbourne", "Canberra", "Melbourne"));
                list.add(new QuizModel("Which city serves as the capital of Canada?", "Toronto", "Ottawa", "Vancouver", "Montreal", "Toronto"));
                list.add(new QuizModel("What is the capital of Brazil?", "Buenos Aires", " São Paulo", " Rio de Janeiro", " Brasília", " Brasília"));

            case "Famous Landmarks":
                list.add(new QuizModel("Which iconic structure is located in Paris and is known for its iron lattice?", "Great Wall of China", "Taj Mahal", "Eiffel Tower", "Sydney Opera House", "Eiffel Tower"));
                list.add(new QuizModel("What is the famous ancient structure in Rome that used to be an amphitheater?", "Colosseum", "Parthenon", "Pantheon", "Acropolis", "Colosseum"));
                list.add(new QuizModel("Which waterfall, located on the border of Canada and the United States, is one of the most famous in the world?", "Victoria Falls", "Niagara Falls", "Angel Falls", "Iguazu Falls", "Niagara Falls"));
                list.add(new QuizModel("Which Indian mausoleum is considered one of the New Seven Wonders of the World?", "Petra", "Christ the Redeemer", "Machu Picchu", "Taj Mahal", "Taj Mahal"));
                list.add(new QuizModel("What is the name of the ancient Egyptian pyramid that is one of the Seven Wonders of the Ancient World?", "Pyramid of Khafre", "Pyramid of Djoser", "Great Pyramid of Giza", " Pyramid of Menkaure", " Great Pyramid of Giza"));

            case "World Geography":
                list.add(new QuizModel("Which continent is known as the \"Land of the Rising Sun\"?", "Asia", "Europe", "Africa", "South America", "Asia"));
                list.add(new QuizModel("The Amazon River is located in which continent?", "North America", "South America", "Africa", "Asia", "South America"));
                list.add(new QuizModel("What is the largest ocean on Earth?", "Indian Ocean", "Atlantic Ocean", "Pacific Ocean", "Arctic Ocean", "Pacific Ocean"));
                list.add(new QuizModel("\n" +
                        "Which country is known as the \"Land of the Midnight Sun\"?", "Russia", "Norway", "Sweden", "Canada", "Norway"));
                list.add(new QuizModel("Mount Everest, the highest peak in the world, is part of which mountain range?", "Andes", "Alps", "Rocky Mountains", " Himalayas", " Himalayas"));

            case "Historical Events":
                list.add(new QuizModel("In which year did Christopher Columbus reach the Americas?", "1492", "1588", "1776", "1812", "1492"));
                list.add(new QuizModel("The Declaration of Independence in the United States was adopted in which year?", "1865", "1620", "1914", "1776", "1776"));
                list.add(new QuizModel("The French Revolution began in which year?", "1648", "1789", "1848", "1917", "1789"));
                list.add(new QuizModel("The Berlin Wall fell in which year, marking the end of the Cold War?", "1989", "1991", "1975", "1961", "1989"));
                list.add(new QuizModel("In which year did the Titanic sink after hitting an iceberg?", "1902", "1912", "1922", "1932", "1912"));
            case "Olympic Games":
                list.add(new QuizModel("In which city were the first modern Olympic Games held in 1896?", "Paris", " Athens", " London", "Rome", "Athens"));
                list.add(new QuizModel("The 2008 Summer Olympics took place in which city?", "Beijing", "Tokyo", "Rio de Janeiro", "Rome", "Beijing"));
                list.add(new QuizModel("Which country hosted the 2014 Winter Olympics?", "Canada", "Russia", "United States", "Norway", "Russia"));
                list.add(new QuizModel("In which year were the Summer and Winter Olympics held in the same year for the first time?", "1952", "1976", "1980", "1992", "1976"));
                list.add(new QuizModel("The 2024 Summer Olympics are scheduled to be held in which city?", "Tokyo", "Paris", "Los Angeles", "Rio de Janeiro", "Paris"));
            case "Famous Athletes":
                list.add(new QuizModel("Who is often referred to as \"The Greatest\" in boxing and won an Olympic gold medal in 1960?", "Muhammad Ali", "Mike Tyson", "Floyd Mayweather", "Manny Pacquiao", "Muhammad Ali"));
                list.add(new QuizModel("Usain Bolt, considered one of the greatest sprinters of all time, represents which country?", "United States", "Jamaica", "Kenya", "Trinidad and Tobago", "Jamaica"));
                list.add(new QuizModel("Serena Williams is a dominant figure in which sport?", "Swimming", "Golf", "Soccer", "Tennis", "Tennis"));
                list.add(new QuizModel("Michael Phelps holds the record for the most Olympic gold medals in which sport?", "Track and Field", "Swimming", "Cycling", "Gymnastics", "Swimming"));
                list.add(new QuizModel("Which basketball player is known as \"King James\" and has won multiple NBA championships?", "Kobe Bryant", "LeBron James", "Michael Jordan", "Shaquille O'Neal", "LeBron James"));
            case "Rules and Regulations":
                list.add(new QuizModel("In soccer, how many players are there on the field for each team during a match?", "8", "11", "10", "12", "11"));
                list.add(new QuizModel("What is the maximum number of hits allowed per side in volleyball before the ball must go over the net?", "2", "3", "4", "1", "3"));
                list.add(new QuizModel("In basketball, how many points is a free throw worth?", "1", "4", "3", "2", "1"));
                list.add(new QuizModel("How many fouls does a player need to accumulate in a basketball game before being disqualified?", "4", "5", "6", "8", "5"));
                list.add(new QuizModel("In tennis, what is it called when both players are tied at 40 points?", "Deuce", "Advantage", "Match Point", "Love", "Deuce"));
            case "Sports History":
                list.add(new QuizModel("Which country hosted the first FIFA World Cup in 1930?", "Brazil", "Germany", "Uruguay", "Italy", "Uruguay"));
                list.add(new QuizModel("In which year did the first modern Olympic Games take place?", "1920", "1936", "1904", "1896", "1896"));
                list.add(new QuizModel("Who was the first African American to break the color barrier in Major League Baseball?", "Babe Ruth", "Jackie Robinson", "Lou Gehrig", "Willie Mays", "Jackie Robinson"));
                list.add(new QuizModel("The \"Miracle on Ice\" refers to a historic moment in which sport during the 1980 Winter Olympics?", "Ice Skating", "Ski Jumping", "Ice Hockey", "Bobsleigh", "Ice Hockey"));
                list.add(new QuizModel("Who is known as the \"Babe Ruth of golf\" and has won the most major championships in golf history?", "Arnold Palmer", "Phil Mickelson", "Jack Nicklaus", "Tiger Woods", "Jack Nicklaus"));
            case "Inventions and Discoveries":
                list.add(new QuizModel("Who is credited with the invention of the telephone?", "Thomas Edison", " Alexander Graham Bell", "Nikola Tesla", "James Watt", " Alexander Graham Bell"));
                list.add(new QuizModel("What did Sir Isaac Newton famously discover when an apple fell on his head?", "Laws of Thermodynamics", "Theory of Relativity", "Law of Gravitation", "Laws of Motion", "Law of Gravitation"));
                list.add(new QuizModel("Marie Curie is renowned for her pioneering research in which field?", "Chemistry", "Physics", "Mathematics", "Medicine", "Physics"));
                list.add(new QuizModel("Who is the inventor of the World Wide Web (WWW)?", "Tim Berners-Lee", "Mark Zuckerberg", "Bill Gates", "Steve Jobs", "Tim Berners-Lee"));
                list.add(new QuizModel("In which year was penicillin discovered by Alexander Fleming?", "1928", "1935", "1942", "1950", "1928"));
            case "Literature and Arts":
                list.add(new QuizModel("Who wrote the play \"Romeo and Juliet\"?", "Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen", "William Shakespeare"));
                list.add(new QuizModel("What is the famous opening line of Charles Dickens' \"A Tale of Two Cities\"?", "\"It was the best of times, it was the worst of times.\"", "\"Call me Ishmael.\"", "\"In the beginning, God created the heavens and the earth.\"", "\"All happy families are alike; each unhappy family is unhappy in its own way.\"", "\"All happy families are alike; each unhappy family is unhappy in its own way.\""));
                list.add(new QuizModel("Who painted the Mona Lisa?", "Michelangelo", "Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Leonardo da Vinci"));
                list.add(new QuizModel("What is the famous novel by Jane Austen that begins with the line, \"It is a truth universally acknowledged, that a single man in possession of a good fortune, must be in want of a wife\"?", "Emma", "Pride and Prejudice", "Mansfield Park", "Sense and Sensibility", "Pride and Prejudice"));
                list.add(new QuizModel("Who is the author of the Harry Potter series?", "J.R.R. Tolkien", "J.K. Rowling", "C.S. Lewis", "George R.R. Martin", "J.K. Rowling"));
            case "Current Affairs":
                list.add(new QuizModel("In which year did the COVID-19 pandemic begin?", "2019", "2020", "2021", "2018", "2020"));
                list.add(new QuizModel("Who is the current President of the United States as of [knowledge cutoff date: January 2023]?", "Joe Biden", "Donald Trump", "Barack Obama", "George W. Bush", "Joe Biden"));
                list.add(new QuizModel("Which country hosted the 2021 Summer Olympics?", "Brazil", "Japan", "South Korea", "Australia", "Japan"));
                list.add(new QuizModel("What global climate agreement aims to limit global warming to well below 2 degrees Celsius above pre-industrial levels?", "Kyoto Protocol", "Paris Agreement", "Copenhagen Accord", "Marrakech Accords", "Paris Agreement"));
                list.add(new QuizModel("In which year did the United Kingdom officially leave the European Union (Brexit)?", "2016", "2018", "2019", "2020", "2020"));
            case "Famous Personalities":
                list.add(new QuizModel("Who is known as the \"Queen of Pop\" and has hits like \"Like a Virgin\" and \"Material Girl\"?", "Beyoncé", "Madonna", "Rihanna", "Lady Gaga", "Madonna"));
                list.add(new QuizModel("Microsoft", "Amazon", "Google", "Tesla", "Microsoft", "Tesla"));
                list.add(new QuizModel("Malala Yousafzai is known for advocating the right to education. In which country was she born?", "Afghanistan", "Pakistan", "India", "Bangladesh", "Pakistan"));
                list.add(new QuizModel("Who is the famous theoretical physicist and author of \"A Brief History of Time\"?", "Richard Dawkins", "Stephen Hawking", "Michio Kaku", "Neil deGrasse Tyson", "Stephen Hawking"));
                list.add(new QuizModel("Which tech entrepreneur co-founded Microsoft with Bill Gates?", "Mark Zuckerberg", "Steve Jobs", "Paul Allen", "Jeff Bezos", "Paul Allen"));
            case "Physics Wonders":
                list.add(new QuizModel("What is the phenomenon where light is bent as it passes through a transparent medium, such as glass or water?", "Reflection", "Refraction", "Dispersion", "Diffraction", "Refraction"));
                list.add(new QuizModel("What is the unit of measurement for electric resistance?", "Ampere", "Volt", "Ohm", "Watt", "Ohm"));
                list.add(new QuizModel("In physics, what is the force that opposes the motion of an object through a fluid (liquid or gas)?", "Gravity", "Friction", "Tension", "Inertia", "Friction"));
                list.add(new QuizModel("Which law of motion states that \"for every action, there is an equal and opposite reaction\"?", "Newton's First Law", "Newton's Second Law", "Newton's Third Law", "Law of Universal Gravitation", "Newton's Third Law"));
                list.add(new QuizModel("What is the SI unit of force?", "Newton", "Joule", "Watt", "Pascal", "Newton"));
            case "Chemistry Concepts":
                list.add(new QuizModel("What is the chemical symbol for gold?", "Gd", "Au", "Ag", "Fe", "Au"));
                list.add(new QuizModel("In chemistry, what is the pH scale used to measure?", "Temperature", "Acidity or Basicity", "Pressure", "Mass", "Acidity or Basicity"));
                list.add(new QuizModel("What is the smallest unit of an element that retains the chemical properties of that element?", "Atom", "Molecule", "Cell", "Ion", "Atom"));
                list.add(new QuizModel("Which gas makes up the majority of Earth's atmosphere?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "Nitrogen"));
                list.add(new QuizModel("What type of chemical bond is formed by the sharing of electrons between atoms?", "Ionic bond", "Covalent bond", "Van der Waals bond", "Metallic bond", "Covalent bond"));
            case "Space and Astronomy":
                list.add(new QuizModel("What is the closest star to Earth?", "Alpha Centauri", "Sirius", "Proxima Centauri", "Betelgeuse", "Proxima Centauri"));
                list.add(new QuizModel("Which planet is known as the \"Red Planet\"?", "Jupiter", "Mars", "Venus", "Saturn", "Mars"));
                list.add(new QuizModel("What is the name of the largest moon of Jupiter?", "Europa", "Ganymede", "Titan", "Io", "Ganymede"));
                list.add(new QuizModel("In the context of space exploration, what does NASA stand for?", "National Aeronautics and Space Administration", "National Astrophysics and Solar Astronomy", "New Astronomical Studies Association", "North American Space Agency", "National Aeronautics and Space Administration"));
                list.add(new QuizModel("Which galaxy is home to our solar system?", "Milky Way", "Andromeda", "Triangulum", "Whirlpool", "Milky Way"));
            case "Environmental Science":
                list.add(new QuizModel("What is the primary greenhouse gas responsible for Earth's warming?", "Methane", "Carbon Dioxide", "Nitrous Oxide", "Ozone", "Carbon Dioxide"));
                list.add(new QuizModel("Which layer of the Earth's atmosphere protects life on the planet by absorbing ultraviolet (UV) radiation from the sun?", "Troposphere", "Stratosphere", "Mesosphere", "Thermosphere", "Stratosphere"));
                list.add(new QuizModel("What is the term for the gradual increase in Earth's average surface temperature?", "Global Warming", "Ozone Depletion", "Acid Rain", "Deforestation", "Global Warming"));
                list.add(new QuizModel("What is the largest source of marine pollution?", "Radioactive waste", "Oil spills", "Heavy metals", "Plastic waste", "Plastic waste"));
                list.add(new QuizModel("Which environmental issue is associated with the depletion of the ozone layer?", "Deforestation", "Eutrophication", "Acid Rain", "Deforestation", "Deforestation"));
        }


        allQuestion = 5;
        listSize = String.valueOf(allQuestion);
        binding.totalQn.setText("/" + listSize);

        if (position != allQuestion) {
            positionNo = String.valueOf(position + 1);
            binding.qN.setText(positionNo);
        } else {
            positionNo = String.valueOf(position);
            binding.qN.setText(positionNo);
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
            binding.nextBtn.setBackgroundResource(R.color.button);
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
            binding.nextBtn.setBackgroundResource(R.color.button);
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
            binding.nextBtn.setBackgroundResource(R.color.button);
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
            binding.nextBtn.setBackgroundResource(R.color.button);
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
        } else if (Objects.equals(quizModel.getOp2(), quizModel.getCorrectAnswer())) {
            binding.option2.setBackgroundResource(R.drawable.correct_background);
        } else if (Objects.equals(quizModel.getOp3(), quizModel.getCorrectAnswer())) {
            binding.option3.setBackgroundResource(R.drawable.correct_background);
        } else if (Objects.equals(quizModel.getOp4(), quizModel.getCorrectAnswer())) {
            binding.option4.setBackgroundResource(R.drawable.correct_background);
        }
    }
}