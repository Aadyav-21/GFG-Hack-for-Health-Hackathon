package harish.projects.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Modelclass> listOfQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listOfQ = new ArrayList<>();

        listOfQ.add(new Modelclass("Select the emoji which describes your day best.","a","b","c","d","a,b,c,d"));
        listOfQ.add(new Modelclass("","a","b","c","d","a,b,c,d"));
        listOfQ.add(new Modelclass("","a","b","c","d","a,b,c,d"));




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity2.this,Quizpage1.class);
            }
        },1500);
    }
}