package harish.projects.moodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout dashboard, quote, quiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout next = (LinearLayout) findViewById(R.id.dashboard);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Dashboard.class);
                startActivityForResult(myIntent, 0);
            }
        });

        LinearLayout next2 = (LinearLayout) findViewById(R.id.quote);
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), Quote.class);
                startActivityForResult(myIntent, 0);
            }
        });

        LinearLayout next3 = (LinearLayout) findViewById(R.id.quiz);
        next3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent( view.getContext(), MainActivity2.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }

}