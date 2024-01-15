package harish.projects.moodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Quizpage1 extends AppCompatActivity {

    CardView a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage1);
    }



    public void s(View view) {
        CardView a = (CardView) findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), quizpage2.class);
                startActivityForResult(myIntent, 0);
            }
        });

        CardView b = (CardView) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), quizpage2.class);
                startActivityForResult(myIntent, 0);
            }
        });

        CardView c = (CardView) findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), quizpage2.class);
                startActivityForResult(myIntent, 0);
            }
        });

        CardView d = (CardView) findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), quizpage2.class);
                startActivityForResult(myIntent, 0);
            }
        });

        CardView e = (CardView) findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), quizpage2.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }

}